package iot.core.repository;

import java.util.List;

import iot.core.entities.device.Device;

public interface DeviceRepo {
	
	public boolean addDevice(Device device);
	
	public boolean removeDevice(long deviceId);
	
	public boolean editDevice(Device device);
		
	public List<Device> getUserDevices(long userId);
	
	public List<Device> getGroupDevices(long groupId);

	public Device findDeviceById(long deviceId);

}
