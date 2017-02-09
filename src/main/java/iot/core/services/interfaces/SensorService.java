package iot.core.services.interfaces;

import iot.presentation.transport.SensorDTO;
import iot.presentation.transport.SensorValueDTO;

import java.util.List;

public interface SensorService {

	public boolean addSensor(SensorDTO sensor);

	public boolean removeSensor(long sensorId);

	public boolean editSensor(SensorDTO sensor);

	public boolean addSensorValue(SensorValueDTO sVal);

	public List<SensorDTO> getDeviceSensors(long deviceId);
	
	public List<SensorValueDTO> getSensorValues(long sensorId);
	
	public SensorDTO getSensorById(long sensorId);
}
