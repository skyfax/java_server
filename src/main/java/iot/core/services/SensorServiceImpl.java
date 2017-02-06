package iot.core.services;

import iot.core.services.interfaces.SensorService;
import iot.presentation.transport.SensorDTO;
import iot.presentation.transport.SensorValueDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SensorServiceImpl implements SensorService{

	@Override
	public SensorDTO addSensor(SensorDTO sensor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeSensor(long sensorId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editSensor(SensorDTO sensor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addSensorValue(SensorValueDTO sVal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<?> getDeviceSensors(long deviceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getSensorValues(long sensorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SensorDTO getDeviceById(long deviceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
