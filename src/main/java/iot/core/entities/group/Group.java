package iot.core.entities.group;

import iot.core.entities.device.Device;
import iot.core.entities.user.User;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public class Group implements Serializable{



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private List<User> users;
	private List<Device> devices;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Device> getDevices() {
		return devices;
	}
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
}

