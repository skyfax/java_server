package iot.core.services.interfaces;

import iot.presentation.transport.DeviceDTO;
import net.minidev.json.JSONObject;

import javax.websocket.Session;
import java.util.List;

public interface DeviceService {
	
	 boolean addDevice(DeviceDTO device, long userId);
	
	 boolean removeDevice(long deviceId,long requesterId);
	
	 boolean editDevice(DeviceDTO device, long requesterId);

	 List<DeviceDTO> getUserDevices(long userId);
	
	 DeviceDTO getDeviceById(long deviceId);

	 void parseMessageFromDevice(String message, Session session);

	 void putDeviceInPreAuthenticationList(Session session);

	 void removeDeviceFromActiveConnections(Session session);
}
