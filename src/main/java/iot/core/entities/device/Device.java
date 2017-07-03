package iot.core.entities.device;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import iot.core.entities.group.Group;
import iot.core.entities.sensor.Sensor;
import iot.core.entities.user.User;


/**
 * The persistent class for the device database table.
 */
@Entity
@Table(name="devices")
@NamedQuery(name="Device.findAll", query="SELECT d FROM Device d")
public class Device implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int accessLevel;

    private int dataFrequency;

    private String deviceSN;

    private String location;

    private String name;

    @Column(name="owner_id")
    private Long ownerId;

    //bi-directional many-to-one association to DeviceSensor
    @OneToMany(mappedBy="device")
    private List<Sensor> sensors;

    private String token;

    public Device() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccessLevel() {
        return this.accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getDataFrequency() {
        return this.dataFrequency;
    }

    public void setDataFrequency(int dataFrequency) {
        this.dataFrequency = dataFrequency;
    }

    public String getDeviceSN() {
        return this.deviceSN;
    }

    public void setDeviceSN(String deviceSN) {
        this.deviceSN = deviceSN;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }
}