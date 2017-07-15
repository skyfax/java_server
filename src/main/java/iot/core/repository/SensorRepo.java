package iot.core.repository;

import java.util.List;

import iot.core.entities.sensor.Sensor;

public interface SensorRepo {
	
	 boolean addSensor(Sensor sensor);

	 boolean removeSensor(long sensorId);

	 boolean editSensor(Sensor sensor);

	 List<Sensor> getDeviceSensors(long deviceId);
	
	 Sensor getSensorById(long sensorId);

}
