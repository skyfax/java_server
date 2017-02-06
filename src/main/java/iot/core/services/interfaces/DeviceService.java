package iot.core.services.interfaces;

import iot.presentation.transport.DeviceDTO;

import java.util.List;

public interface DeviceService {
	
	public boolean addDevice(DeviceDTO device);
	
	public boolean removeDevice(long deviceId);
	
	public boolean editDevice(DeviceDTO device);
	
	public List<?> searchResults(String searchData);
	
	public List<?> getUserDevices(long userId);
	
	public List<?> getGroupDevices(long groupId);

	public DeviceDTO getDeviceById(long deviceId);

}
