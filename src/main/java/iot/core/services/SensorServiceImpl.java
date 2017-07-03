package iot.core.services;

import java.util.List;

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

	@Override
	public boolean addSensor(SensorDTO sensor) {

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
	public boolean removeSensor(long sensorId) {
		boolean result = sensorRepo.removeSensor(sensorId);

		return result;
	}

	@Override
	public boolean editSensor(SensorDTO sensor) {
		Sensor s = sensorRepo.getSensorById(sensor.getId());

		s.setIsEventEnabled(sensor.isEventEnable());
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
	public List<SensorDTO> getDeviceSensors(long deviceId) {
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
	public SensorDTO getSensorById(long sensorId) {
		Sensor sensor = sensorRepo.getSensorById(sensorId);
		
		return SensorConverter.toSensorDTO(sensor);
	}

}
