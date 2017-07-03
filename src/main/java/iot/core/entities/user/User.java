package iot.core.entities.user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import iot.core.entities.device.Device;
import iot.core.entities.role.Role;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="users")

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String email;

	private String password;

	private Long phone;

	private String username;

//	//bi-directional many-to-one association to Device
//	@OneToMany(mappedBy="user")
//	private List<Device> devices;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

	public User() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhone() {
		return this.phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	public List<Device> getDevices() {
//		return this.devices;
//	}
//
//	public void setDevices(List<Device> devices) {
//		this.devices = devices;
//	}
//
//	public Device addDevice(Device device) {
//		getDevices().add(device);
//		device.setOwnerId(this.getId());
//
//		return device;
//	}
//
//	public Device removeDevice(Device device) {
//		getDevices().remove(device);
//		device.setOwnerId(null);
//
//		return device;
//	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}