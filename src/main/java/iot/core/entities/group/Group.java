package iot.core.entities.group;

import iot.core.entities.device.Device;
import iot.core.entities.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="groups")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	//bi-directional many-to-one association to Device
	@ManyToOne
	@JoinColumn(name="deviceId")
	private Device device;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	public Group() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

