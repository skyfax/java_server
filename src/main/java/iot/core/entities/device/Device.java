package iot.core.entities.device;

import iot.core.entities.sensor.Sensor;
import iot.core.entities.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int dataFrequency;
    private String name;
    private String token;
    @ManyToOne
    private User owner;

    @OneToMany
    private List<Sensor> sensors;

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

}
