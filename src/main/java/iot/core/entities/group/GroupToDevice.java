package iot.core.entities.group;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the group_to_device database table.
 * 
 */
@Entity
@Table(name="group_to_device")
@NamedQuery(name="GroupToDevice.findAll", query="SELECT g FROM GroupToDevice g")
public class GroupToDevice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private Long deviceId;

	//bi-directional many-to-one association to Group
	@ManyToOne
	@JoinColumn(name="groupId")
	private Group group;

	public GroupToDevice() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}