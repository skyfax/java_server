package iot.core.entities.sensorValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import iot.core.entities.sensor.Sensor;

@Entity
public class SensorValue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double value;
	
	@ManyToOne
	private Sensor sensor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
}
