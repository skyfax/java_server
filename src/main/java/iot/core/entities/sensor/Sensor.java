package iot.core.entities.sensor;

import iot.core.entities.device.Device;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sensors")

public class Sensor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double maxVal;

    private Double minVal;

    private String name;

    private int sensorType;

    //bi-directional many-to-one association to Device
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deviceId")
    private Device device;

    public Sensor() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMaxVal() {
        return this.maxVal;
    }

    public void setMaxVal(Double maxVal) {
        this.maxVal = maxVal;
    }

    public Double getMinVal() {
        return this.minVal;
    }

    public void setMinVal(Double minVal) {
        this.minVal = minVal;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSensorType() {
        return this.sensorType;
    }

    public void setSensorType(int sensorType) {
        this.sensorType = sensorType;
    }

    public Device getDevice() {
        return this.device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

}
