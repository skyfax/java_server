package iot.core.repository;

import iot.core.entities.role.Role;

public interface RoleRepo {

	public Role getRoleById(long id);
	
	public boolean addRole(Role role);
}
