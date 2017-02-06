package iot.presentation.transport;

import iot.core.entities.sensor.SensorType;

public class SensorDTO {

    private long id;

    private String name;

    private double minValue;

    private double maxValue;

    private boolean isEventEnable;

    private SensorType sensorType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public boolean isEventEnable() {
        return isEventEnable;
    }

    public void setEventEnable(boolean eventEnable) {
        isEventEnable = eventEnable;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }
}
