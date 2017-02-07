package iot.core.services.interfaces;

import iot.presentation.transport.SensorDTO;
import iot.presentation.transport.SensorValueDTO;

import java.util.List;

public interface SensorService {

	public SensorDTO addSensor(SensorDTO sensor);

	public boolean removeSensor(long sensorId);

	public boolean editSensor(SensorDTO sensor);

	public boolean addSensorValue(SensorValueDTO sVal);

	public List<SensorDTO> getDeviceSensors(long deviceId);
	
	public List<SensorDTO> getSensorValues(long sensorId);
	
	public SensorDTO getSensorById(long sensorId);
}
