package iot.core.repository;

import java.util.List;

import iot.common.SearchCriteria;
import iot.core.entities.sensorValue.SensorValue;

public interface SensorValueRepo {

    boolean addSensorValue(SensorValue sVal);

    boolean removeSensorValue(long sensorValueId);

    List<SensorValue> getSensorValues(long sensorId);

    List<SensorValue> getSensorValuesForSearch(SearchCriteria criteria, boolean isLoggedIn, boolean isInGroup);

}
