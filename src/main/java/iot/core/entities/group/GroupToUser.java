package iot.core.entities.group;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the group_to_user database table.
 * 
 */
@Entity
@Table(name="group_to_user")
@NamedQuery(name="GroupToUser.findAll", query="SELECT g FROM GroupToUser g")
public class GroupToUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private Long userId;

	//bi-directional many-to-one association to Group
	@ManyToOne
	@JoinColumn(name="groupId")
	private Group group;

	public GroupToUser() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}