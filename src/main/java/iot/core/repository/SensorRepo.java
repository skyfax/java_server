package iot.core.repository;

import java.util.List;

import iot.core.entities.sensor.Sensor;

public interface SensorRepo {
	
	public boolean addSensor(Sensor sensor);

	public boolean removeSensor(long sensorId);

	public boolean editSensor(Sensor sensor);

	public List<Sensor> getDeviceSensors(long deviceId);
	
	public Sensor getSensorById(long sensorId);

}
