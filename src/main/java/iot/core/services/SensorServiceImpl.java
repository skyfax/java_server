package iot.core.services;

import java.util.ArrayList;
import java.util.List;

import iot.common.SearchCriteria;
import iot.common.SearchTextParser;
import iot.core.entities.group.Group;
import iot.core.repository.UserRepo;
import iot.core.services.interfaces.GroupService;
import iot.presentation.transport.GroupDTO;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iot.common.SensorConverter;
import iot.core.entities.device.Device;
import iot.core.entities.sensor.Sensor;
import iot.core.entities.sensorValue.SensorValue;
import iot.core.repository.DeviceRepo;
import iot.core.repository.SensorRepo;
import iot.core.repository.SensorValueRepo;
import iot.core.services.interfaces.SensorService;
import iot.presentation.transport.SensorDTO;
import iot.presentation.transport.SensorValueDTO;

@Service
@Transactional
public class SensorServiceImpl implements SensorService {

    @Autowired
    SensorRepo sensorRepo;

    @Autowired
    DeviceRepo deviceRepo;

    @Autowired
    SensorValueRepo sensorValueRepo;

    @Autowired
    GroupService groupService;

    @Override
    public boolean addSensor(SensorDTO sensor, long requesterId) {

        Sensor sen = sensor.toSensor();
        Long deviceId = sensor.getDeviceId();
        boolean result = false;
        if (deviceId != null) {
            Device device = deviceRepo.findDeviceById(deviceId);

            sen.setDevice(device);
            result = sensorRepo.addSensor(sen);
        }

        return result;
    }

    @Override
    public boolean removeSensor(long sensorId, long requesterId) {
        boolean result = sensorRepo.removeSensor(sensorId);

        return result;
    }

    @Override
    public boolean editSensor(SensorDTO sensor, long requesterId) {
        Sensor s = sensorRepo.getSensorById(sensor.getId());

        s.setMaxVal(sensor.getMaxValue());
        s.setMinVal(sensor.getMinValue());
        s.setName(sensor.getName());
        s.setSensorType(sensor.getSensorType().getValue());

        boolean result = sensorRepo.editSensor(s);

        return result;
    }

    @Override
    public boolean addSensorValue(SensorValueDTO sVal) {
        SensorValue sValToSave = new SensorValue();
        Sensor sensor = sensorRepo.getSensorById(sVal.getSensorId());
        boolean result = false;

        if (sensor != null) {
            sValToSave.setValue(sVal.getValue());
            sValToSave.setSensor(sensor);
            result = sensorValueRepo.addSensorValue(sValToSave);
        }

        return result;
    }

    @Override
    public List<SensorDTO> getDeviceSensors(long deviceId, long requesterId) {
        List<SensorDTO> sensors = SensorConverter.toSensorDTOList(sensorRepo.getDeviceSensors(deviceId));

        return sensors;
    }

    @Override
    public List<SensorValueDTO> getSensorValues(long sensorId) {
        List<SensorValue> svals = sensorValueRepo.getSensorValues(sensorId);
        List<SensorValueDTO> values = SensorConverter.toSensorValueDTOList(svals);

        return values;
    }

    @Override
    public SensorDTO getSensorById(long sensorId, long requester) {
        Sensor sensor = sensorRepo.getSensorById(sensorId);

        return SensorConverter.toSensorDTO(sensor);
    }

    @Override
    public SensorValueDTO getCurrentValueOfTheSensor(long sensorId, long requesterId) {
        return null;
    }

    @Override
    public JSONObject searchItems(String text, Long requesterId) {
        JSONObject response = new JSONObject();
        SearchCriteria searchCriteria = SearchTextParser.parseAndValidateSearchText(text);
        boolean isLoggedIn = requesterId != null;
        boolean hasGroupDevices = false;
        List<SensorValue> sensorValues;

        if (searchCriteria != null) {
            if (isLoggedIn) {
                isLoggedIn = true;
                List<GroupDTO> groups = groupService.getGroupList(requesterId);
                if (!groups.isEmpty()) {
                    hasGroupDevices = true;
                }
            }

            sensorValues = sensorValueRepo.getSensorValuesForSearch(searchCriteria, isLoggedIn, hasGroupDevices);
            if(sensorValues!= null){
                response =  SearchTextParser.convertSearchResults(sensorValues,searchCriteria);
            }else {
                putErrorOnResponse(response, "No valid data from devices could be found.", "2");
            }
        } else {
            putErrorOnResponse(response, "Invalid search text.", "1");
        }

        return response;
    }

    private void putErrorOnResponse(JSONObject obj, String error, String errorCode) {
        obj.put("error", error);
        obj.put("errorCode", errorCode);
    }


}
