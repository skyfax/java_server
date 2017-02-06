package iot.core.services;

import iot.core.services.interfaces.DeviceService;
import iot.presentation.transport.DeviceDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService{

	@Override
	public boolean addDevice(DeviceDTO device) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeDevice(long deviceId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editDevice(DeviceDTO device) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<?> searchResults(String searchData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getUserDevices(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getGroupDevices(long groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviceDTO getDeviceById(long deviceId) {
		return null;
	}

}
