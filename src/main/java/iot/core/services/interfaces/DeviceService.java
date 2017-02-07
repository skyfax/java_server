package iot.core.services.interfaces;

import iot.presentation.transport.DeviceDTO;

import java.util.List;

public interface DeviceService {
	
	public boolean addDevice(DeviceDTO device);
	
	public boolean removeDevice(long deviceId);
	
	public boolean editDevice(DeviceDTO device);
	
	public List<DeviceDTO> searchResults(String searchData);
	
	public List<DeviceDTO> getUserDevices(long userId);
	
	public List<DeviceDTO> getGroupDevices(long groupId);

	public DeviceDTO getDeviceById(long deviceId);

}
