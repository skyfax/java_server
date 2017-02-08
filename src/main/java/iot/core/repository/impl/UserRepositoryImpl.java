package iot.core.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import iot.core.entities.user.User;
import iot.core.repository.UserRepo;

/**
 * Created by Usera on 04/02/2017.
 */

@Repository
public class UserRepositoryImpl implements UserRepo {

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean isUsernameUnique(String username) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> user = cq.from(User.class);

		cq.select(user);
		cq.where(cb.equal(user.get("username"), username));
		Query query = em.createQuery(cq);

		@SuppressWarnings("unchecked")
		List<User> result = query.getResultList();

		return result.isEmpty();
	}

	@Override
	public boolean addUser(User user) {

		em.persist(user);

		return true;
	}

	@Override
	public boolean editUser(User user) {
		em.persist(user);

		return true;
	}

	@Override
	public boolean authenticateUser(String username, String password) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> user = cq.from(User.class);

		cq.select(user);
		cq.where(cb.and(cb.equal(user.get("username"), username), cb.equal(user.get("password"), password)));
		Query query = em.createQuery(cq);

		User result = (User) query.getSingleResult();

		return result != null;
	}

	@Override
	public User getUser(long userId) {
		User user = em.find(User.class, userId);

		return user;
	}

	@Override
	public boolean deleteUser(long userId) {
		User user = getUser(userId);
		boolean result = false;

		if (user != null) {
			em.remove(user);
			result = true;
		}

		return result;
	}

	@Override
	public User getUserByUsername(String username) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> user = cq.from(User.class);

		cq.select(user);
		cq.where(cb.equal(user.get("username"), username));
		Query query = em.createQuery(cq);

		User result = (User) query.getSingleResult();

		return result;
	}

}
