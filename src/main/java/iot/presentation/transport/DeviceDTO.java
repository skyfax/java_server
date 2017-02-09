package iot.presentation.transport;

import java.util.List;

import iot.core.entities.device.Device;

public class DeviceDTO {

    private Long id;
    private int dataFrequency;
    private String name;
    private String token;
    
    private List<SensorDTO> sensors;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
    
}
