package iot.common;

import java.util.ArrayList;
import java.util.List;

import iot.core.entities.sensor.Sensor;
import iot.core.entities.sensor.SensorType;
import iot.core.entities.sensorValue.SensorValue;
import iot.presentation.transport.SensorDTO;
import iot.presentation.transport.SensorValueDTO;

public class SensorConverter {

    public static SensorDTO toSensorDTO(Sensor sensor) {
        SensorDTO s = new SensorDTO();

        s.setDeviceId(sensor.getDevice().getId());
        s.setMaxValue(sensor.getMaxVal());
        s.setMinValue(sensor.getMinVal());
        s.setName(sensor.getName());
        s.setId(sensor.getId());
        s.setSensorType(SensorType.getSensorType(sensor.getSensorType()));

        return s;
    }

    public static List<SensorDTO> toSensorDTOList(List<Sensor> sensors) {
        List<SensorDTO> sList = new ArrayList<>();

        for (Sensor s : sensors) {
            sList.add(toSensorDTO(s));
        }

        return sList;
    }

    public static SensorValueDTO toSensorValueDTO(SensorValue sensor) {
        SensorValueDTO s = new SensorValueDTO();

        s.setId(sensor.getId());
        s.setValue(sensor.getValue());
        s.setSensorId(sensor.getSensor().getId());

        return s;
    }

    public static List<SensorValueDTO> toSensorValueDTOList(List<SensorValue> sensors) {
        List<SensorValueDTO> sList = new ArrayList<>();

        for (SensorValue s : sensors) {
            sList.add(toSensorValueDTO(s));
        }

        return sList;
    }


}
