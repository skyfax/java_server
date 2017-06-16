package iot.core.entities.device;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import iot.core.entities.sensor.Sensor;
import iot.core.entities.user.User;


/**
 * The persistent class for the device database table.
 * 
 */
@Entity
@NamedQuery(name="Device.findAll", query="SELECT d FROM Device d")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int dataFrequency;

	private String name;

	private String token;

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

}