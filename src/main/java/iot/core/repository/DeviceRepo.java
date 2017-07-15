package iot.core.repository;

import java.util.List;

import iot.core.entities.device.Device;

public interface DeviceRepo {
	
	 boolean addDevice(Device device);
	
	 boolean removeDevice(long deviceId);
	
	 boolean editDevice(Device device);
		
	 List<Device> getUserDevices(long userId);
	
	 List<Device> getGroupDevices(long groupId);

	 Device findDeviceById(long deviceId);

	Device authenticateDevice(String name, String serialNumber);

}
