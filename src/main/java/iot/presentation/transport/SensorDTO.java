package iot.presentation.transport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import iot.core.entities.sensor.Sensor;
import iot.core.entities.sensor.SensorType;

public class SensorDTO {

    private Long id;

    private String name;

    private Double minValue;

    private Double maxValue;

    private Integer isEventEnable;

    private SensorType sensorType;

    private Long deviceId;

    @JsonCreator
    public SensorDTO(@JsonProperty("id") Long id,
                     @JsonProperty("name") String name,
                     @JsonProperty("sensorType") int sensorType,
                     @JsonProperty("deviceId") Long deviceId,
                     @JsonProperty("minValue") Double minValue,
                     @JsonProperty("maxValue") Double maxValue,
                     @JsonProperty("isEventEnable") Integer isEventEnable) {
        this.id = id;
        this.name = name;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.isEventEnable = isEventEnable;
        this.setSensorType(SensorType.getSensorType(sensorType));
        this.deviceId = deviceId;
    }

    public SensorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer isEventEnable() {
        return isEventEnable;
    }

    public void setEventEnable(Integer eventEnable) {
        isEventEnable = eventEnable;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Sensor toSensor() {
        Sensor sensor = new Sensor();

        sensor.setIsEventEnabled(isEventEnable);
        sensor.setId(id);
        sensor.setMaxVal(maxValue);
        sensor.setMinVal(minValue);
        sensor.setName(name);
        sensor.setSensorType(sensorType.getValue());

        return sensor;
    }
}
