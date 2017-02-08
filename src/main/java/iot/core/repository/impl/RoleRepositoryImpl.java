package iot.core.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import iot.core.entities.user.Role;
import iot.core.repository.RoleRepo;

@Repository
public class RoleRepositoryImpl implements RoleRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Role getRoleById(long id) {
		return em.find(Role.class, id);
	}

	@Override
	public boolean addRole(Role role) {
		em.persist(role);

		return true;
	}

}
