package iot.core.services.interfaces;

import iot.presentation.transport.SensorDTO;
import iot.presentation.transport.SensorValueDTO;
import net.minidev.json.JSONObject;

import java.util.List;

public interface SensorService {

	 boolean addSensor(SensorDTO sensor, long requesterId);

	 boolean removeSensor(long sensorId, long requesterId);

	 boolean editSensor(SensorDTO sensor, long requesterId);

	 boolean addSensorValue(SensorValueDTO sVal);

	 List<SensorDTO> getDeviceSensors(long deviceId, long requesterId);
	
	 List<SensorValueDTO> getSensorValues(long sensorId);
	
	 SensorDTO getSensorById(long sensorId,long requester);

	 SensorValueDTO getCurrentValueOfTheSensor(long sensorId, long requesterId);

	JSONObject searchItems(String text, Long requesterId);
}
