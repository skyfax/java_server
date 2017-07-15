package iot.core.entities.group;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the groups database table.
 * 
 */
@Entity
@Table(name="groups")
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String name;

	//bi-directional many-to-one association to GroupToDevice
	@OneToMany(mappedBy="group")
	private List<GroupToDevice> groupToDevices;

	//bi-directional many-to-one association to GroupToUser
	@OneToMany(mappedBy="group")
	private List<GroupToUser> groupToUsers;

	public Group() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GroupToDevice> getGroupToDevices() {
		return this.groupToDevices;
	}

	public void setGroupToDevices(List<GroupToDevice> groupToDevices) {
		this.groupToDevices = groupToDevices;
	}

	public GroupToDevice addGroupToDevice(GroupToDevice groupToDevice) {
		getGroupToDevices().add(groupToDevice);
		groupToDevice.setGroup(this);

		return groupToDevice;
	}

	public GroupToDevice removeGroupToDevice(GroupToDevice groupToDevice) {
		getGroupToDevices().remove(groupToDevice);
		groupToDevice.setGroup(null);

		return groupToDevice;
	}

	public List<GroupToUser> getGroupToUsers() {
		return this.groupToUsers;
	}

	public void setGroupToUsers(List<GroupToUser> groupToUsers) {
		this.groupToUsers = groupToUsers;
	}

	public GroupToUser addGroupToUser(GroupToUser groupToUser) {
		getGroupToUsers().add(groupToUser);
		groupToUser.setGroup(this);

		return groupToUser;
	}

	public GroupToUser removeGroupToUser(GroupToUser groupToUser) {
		getGroupToUsers().remove(groupToUser);
		groupToUser.setGroup(null);

		return groupToUser;
	}

}