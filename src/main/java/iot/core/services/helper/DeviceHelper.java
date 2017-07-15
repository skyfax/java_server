package iot.core.services.helper;

import iot.core.entities.sensor.Sensor;

import java.util.List;

/**
 * Created by Shyzzle on 15/07/2017.
 */
public class DeviceHelper {

    public static Sensor getDesiredSensor(List<Sensor> sensors, String sensorName) {
        Sensor result = null;
        for (Sensor sensor : sensors) {
            if (sensor.getName().equalsIgnoreCase(sensorName)) {
                result = sensor;
                break;
            }
        }

        return result;
    }
}
