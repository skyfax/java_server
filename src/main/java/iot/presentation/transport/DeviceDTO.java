package iot.presentation.transport;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import iot.core.entities.device.Device;

public class DeviceDTO {

    private Long id;
    private int dataFrequency;
    private String name;
    private String deviceSN;
    private String token;
    private int accessLevel;
    private String location;

    private List<SensorDTO> sensors;


    @JsonCreator
    public DeviceDTO(@JsonProperty("id") Long id, @JsonProperty("dataFrequency") int dataFrequency, @JsonProperty("name") String name,
                     @JsonProperty("deviceSN") String deviceSN, @JsonProperty("token") String token, @JsonProperty("accessLevel") int accessLevel,
                     @JsonProperty("location") String location) {

        this.id = id;
        this.dataFrequency = dataFrequency;
        this.name = name;
        this.deviceSN = deviceSN;
        this.token = token;
        this.accessLevel = accessLevel;
        this.location = location;
    }

    public DeviceDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDataFrequency() {
        return dataFrequency;
    }

    public void setDataFrequency(int dataFrequency) {
        this.dataFrequency = dataFrequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<SensorDTO> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorDTO> sensors) {
        this.sensors = sensors;
    }

    public Device toDevice() {
        Device device = new Device();

        device.setDataFrequency(dataFrequency);
        device.setId(id);
        device.setName(name);
        device.setToken(token);
        device.setAccessLevel(accessLevel);
        device.setLocation(location);
        device.setDeviceSN(deviceSN);

        return device;
    }

    public String getDeviceSN() {
        return deviceSN;
    }

    public void setDeviceSN(String deviceSN) {
        this.deviceSN = deviceSN;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
