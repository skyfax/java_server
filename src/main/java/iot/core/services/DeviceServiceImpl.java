package iot.core.services;

import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.util.*;

import iot.core.entities.sensor.Sensor;
import iot.core.entities.sensorValue.SensorValue;
import iot.core.repository.SensorRepo;
import iot.core.repository.SensorValueRepo;
import iot.core.services.helper.*;
import iot.core.services.interfaces.SensorService;
import iot.core.services.interfaces.UserService;
import iot.presentation.transport.NotificationDTO;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iot.common.DeviceConverter;
import iot.core.entities.device.Device;
import iot.core.entities.user.User;
import iot.core.repository.DeviceRepo;
import iot.core.repository.UserRepo;
import iot.core.services.interfaces.DeviceService;
import iot.presentation.transport.DeviceDTO;

import javax.websocket.*;

import static iot.core.services.helper.DeviceHelper.getDesiredSensor;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    UserRepo userRepository;

    @Autowired
    DeviceRepo deviceRepository;

    @Autowired
    UserService userService;

    @Autowired
    SensorValueRepo sensorValueRepo;

    @Autowired
    SensorRepo sensorRepo;

    private static DeviceServiceImpl instance = null;

    public static DeviceService getInstance() {
        if (instance == null) {
            instance = new DeviceServiceImpl();
            ApplicationContext context = new ClassPathXmlApplicationContext("business-config.xml");
            AutowireCapableBeanFactory factory = context.getAutowireCapableBeanFactory();
            factory.autowireBean(instance);
        }

        return instance;
    }

    private static HashMap<Session, Boolean> preAuthenticatedList;
    private static HashMap<Session, Long> authenticatedSessions;
    private static HashMap<Long, Session> activeDevices;
    private static HashMap<Long, Device> devices;


    public DeviceServiceImpl() {
        preAuthenticatedList = new HashMap<>();
        authenticatedSessions = new HashMap<>();
        activeDevices = new HashMap<>();
        devices = new HashMap<>();
//        this.userRepository = userRepository;
//        this.deviceRepository = deviceRepository;
//        this.userService = userService;
    }

    @Override
    public boolean addDevice(DeviceDTO device, long userId) {
        Device dev = device.toDevice();
        User user = userRepository.getUser(userId);
        boolean result = false;

        if (user != null) {
            dev.setOwnerId(user.getId());
            result = deviceRepository.addDevice(dev);
        }

        return result;
    }

    @Override
    public boolean removeDevice(long deviceId, long requesterId) {
        return deviceRepository.removeDevice(deviceId);
    }

    @Override
    public boolean editDevice(DeviceDTO device, long requesterId) {
        Device dev = deviceRepository.findDeviceById(device.getId());

        dev.setDataFrequency(device.getDataFrequency());
        dev.setName(device.getName());
        dev.setToken(device.getToken());
        dev.setLocation(device.getLocation());
        dev.setDeviceSN(device.getDeviceSN());

        return deviceRepository.editDevice(dev);
    }

    @Override
    public List<DeviceDTO> getUserDevices(long userId) {
        List<Device> devs = deviceRepository.getUserDevices(userId);

        return DeviceConverter.toDeviceDTOList(devs);
    }


    @Override
    public DeviceDTO getDeviceById(long deviceId) {
        Device dev = deviceRepository.findDeviceById(deviceId);

        return DeviceConverter.toDeviceDTO(dev);
    }

    @Override
    public void parseMessageFromDevice(String message, Session session) {
        SimpleAction action = ActionParser.parseUnencryptedCommand(message);

        if (preAuthenticatedList.containsKey(session)) {
            if (Command.AUTHENTICATE == Command.toCommand(action.getCommand())) {
                Device dev = deviceRepository.authenticateDevice(action.getSensor(), action.getValue());
                if (dev != null) {
                    preAuthenticatedList.remove(session);
                    authenticatedSessions.put(session, dev.getId());
                    activeDevices.put(dev.getId(), session);
                    devices.put(dev.getId(), dev);
                } else {
                    // authentication failed remove connection
                    preAuthenticatedList.remove(session);
                    try {
                        session.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                SimpleAction authentication = new SimpleAction().setCommand("AUTHENTICATE");
                sendCommandToDevice(authentication, session);
            }
        } else {
            Long deviceId = authenticatedSessions.get(session);
            Device device = devices.get(deviceId);
            interpretMessage(message, device);
        }
    }

    @Override
    public void putDeviceInPreAuthenticationList(Session session) {
        preAuthenticatedList.put(session, Boolean.FALSE);
    }

    private void interpretMessage(String message, Device device) {
        SimpleAction action = ActionParser.parseUnencryptedCommand(message);
        Command deviceCommand = Command.toCommand(action.getCommand());
        if (Command.UNKNOWN != deviceCommand) {
            switch (deviceCommand) {
                case EVENT:
                    sendEventToUser(action, device, true);
                case GET_VALUE:
                    sendEventToUser(action, device, false);
            }
        } else {
            ComplexAction complexAction = ActionParser.parseComplexAction(message);
            if (Command.INTERVAL == Command.toCommand(complexAction.getCommand())) {
                List<Sensor> sensors = sensorRepo.getDeviceSensors(device.getId());
                saveGatheredData(sensors, complexAction);
            }
        }

    }

    private void saveGatheredData(List<Sensor> sensors, ComplexAction complexAction) {
        List<SensorPair> pairs = complexAction.getData();

        for (SensorPair pair : pairs) {
            Sensor sensor = getDesiredSensor(sensors, pair.getSensor());
            saveSensorValue(sensor,Double.parseDouble(pair.getValue()));
        }
    }

    @Override
    public void removeDeviceFromActiveConnections(Session session) {

        if (preAuthenticatedList.containsKey(session)) {
            preAuthenticatedList.remove(session);
        } else {
            if (authenticatedSessions.containsKey(session)) {
                Long deviceId = authenticatedSessions.get(session);

                authenticatedSessions.remove(session);
                activeDevices.remove(deviceId);
                devices.remove(deviceId);
            }
        }
    }

    private void sendEventToUser(SimpleAction action, Device device, boolean saveToDb) {
        NotificationDTO notification = new NotificationDTO();
        notification.setSensor(action.getSensor());
        notification.setValue(action.getValue());
        notification.setUserId(device.getOwnerId());

        userService.sendNotification(notification);

        if (saveToDb) {
            List<Sensor> sensors = sensorRepo.getDeviceSensors(device.getId());
            Sensor sensor = getDesiredSensor(sensors, action.getSensor());
            saveSensorValue(sensor, Double.parseDouble(action.getValue()));
        }
    }


    private void saveSensorValue(Sensor sensor, double value) {
        if (sensor != null) {
            SensorValue sensorValue = new SensorValue();
            sensorValue.setSensor(sensor);
            sensorValue.setValue(value);
            sensorValue.setReadDate(new Date());

            sensorValueRepo.addSensorValue(sensorValue);
        }
    }

    private void sendCommandToDevice(SimpleAction action, Session session) {
        String message = action.toJSON().toJSONString();

        System.out.println("Message to " + session.getId() + ": " + message);
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
