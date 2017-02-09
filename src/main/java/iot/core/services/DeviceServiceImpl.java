package iot.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iot.common.DeviceConverter;
import iot.core.entities.device.Device;
import iot.core.entities.user.User;
import iot.core.repository.DeviceRepo;
import iot.core.repository.UserRepo;
import iot.core.services.interfaces.DeviceService;
import iot.presentation.transport.DeviceDTO;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	UserRepo userRepository;

	@Autowired
	DeviceRepo deviceRepository;

	@Override
	public boolean addDevice(DeviceDTO device, long userId) {
		Device dev = device.toDevice();
		User user = userRepository.getUser(userId);
		boolean result = false;

		if (user != null) {
			dev.setOwner(user);
			result = deviceRepository.addDevice(dev);
		}

		return result;
	}

	@Override
	public boolean removeDevice(long deviceId) {
		return deviceRepository.removeDevice(deviceId);
	}

	@Override
	public boolean editDevice(DeviceDTO device) {
		Device dev = deviceRepository.findDeviceById(device.getId());

		dev.setDataFrequency(device.getDataFrequency());
		dev.setName(device.getName());
		dev.setToken(device.getToken());

		return deviceRepository.editDevice(dev);
	}

	@Override
	public List<DeviceDTO> searchResults(String searchData) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Search functionality not implemented yet!");
	}

	@Override
	public List<DeviceDTO> getUserDevices(long userId) {
		List<Device> devs = deviceRepository.getUserDevices(userId);

		return DeviceConverter.toDeviceDTOList(devs);
	}

	@Override
	public List<DeviceDTO> getGroupDevices(long groupId) {
		List<Device> devs = deviceRepository.getGroupDevices(groupId);

		return DeviceConverter.toDeviceDTOList(devs);
	}

	@Override
	public DeviceDTO getDeviceById(long deviceId) {
		Device dev = deviceRepository.findDeviceById(deviceId);
		
		return DeviceConverter.toDeviceDTO(dev);
	}

}
