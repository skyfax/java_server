package iot.core.repository;

import java.util.List;

import iot.core.entities.sensorValue.SensorValue;

public interface SensorValueRepo {
	
	public boolean addSensorValue(SensorValue sVal);
	
	public boolean removeSensorValue(long sensorValueId);
	
	public List<SensorValue> getSensorValues(long sensorId);

}
