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
    
    private List<SensorDTO> sensors;

    
    @JsonCreator
    public DeviceDTO(@JsonProperty("id") Long id, @JsonProperty("dataFrequency") int dataFrequency, @JsonProperty("name") String name,
			@JsonProperty("deviceSN") String deviceSN, @JsonProperty("token") String token){
    	
    	this.id = id;
    	this.dataFrequency = dataFrequency;
    	this.name = name;
    	this.deviceSN = deviceSN;
    	this.token = token;
    }
    
    public DeviceDTO(){
    	
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

	public Device toDevice(){
    	Device device = new Device();
    	
    	device.setDataFrequency(dataFrequency);
    	device.setId(id);
    	device.setName(name);
    	device.setToken(token);
    	
    	return device;
    }

	public String getDeviceSN() {
		return deviceSN;
	}

	public void setDeviceSN(String deviceSN) {
		this.deviceSN = deviceSN;
	}
	
	
    
}
