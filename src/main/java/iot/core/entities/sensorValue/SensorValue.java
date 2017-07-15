package iot.core.entities.sensorValue;

import iot.core.entities.sensor.Sensor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the sensorvalue database table.
 * 
 */
@Entity
@Table(name="sensor_value")
@NamedQuery(name="SensorValue.findAll", query="SELECT s FROM SensorValue s")
public class SensorValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sensorId", nullable = false)
	private Sensor sensor;

	private double value;

	private Date readDate;

	public SensorValue() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sensor getSensor() {
		return this.sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getReadDate() {
		return readDate;
	}

	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}
}