package iot.core.entities.device;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import iot.core.entities.sensor.Sensor;
import iot.core.entities.user.User;


/**
 * The persistent class for the device database table.
 * 
 */
@Entity
@Table(name="devices")
@NamedQuery(name="Device.findAll", query="SELECT d FROM Device d")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int dataFrequency;

	private String name;

	private String token;
	
	private String deviceSN;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="owner_id")
	private User user;

	//bi-directional many-to-one association to DeviceSensor
	@OneToMany(mappedBy="device")
	private List<Sensor> deviceSensors;

	public Device() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDataFrequency() {
		return this.dataFrequency;
	}

	public void setDataFrequency(int dataFrequency) {
		this.dataFrequency = dataFrequency;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Sensor> getSensors() {
		return this.deviceSensors;
	}

	public void setSensors(List<Sensor> deviceSensors) {
		this.deviceSensors = deviceSensors;
	}

	public Sensor addSensor(Sensor deviceSensor) {
		getSensors().add(deviceSensor);
		deviceSensor.setDevice(this);

		return deviceSensor;
	}

	public Sensor removeSensor(Sensor deviceSensor) {
		getSensors().remove(deviceSensor);
		deviceSensor.setDevice(null);

		return deviceSensor;
	}

	public String getDeviceSN() {
		return deviceSN;
	}

	public void setDeviceSN(String deviceSN) {
		this.deviceSN = deviceSN;
	}
	
}