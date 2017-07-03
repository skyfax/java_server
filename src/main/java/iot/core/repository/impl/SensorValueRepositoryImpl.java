package iot.core.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import iot.core.entities.sensorValue.SensorValue;
import iot.core.repository.SensorValueRepo;

@Repository
public class SensorValueRepositoryImpl implements SensorValueRepo {

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean addSensorValue(SensorValue sVal) {
		em.persist(sVal);

		return true;
	}

	@Override
	public boolean removeSensorValue(long sensorValueId) {
		SensorValue sv = getSensorValueById(sensorValueId);
		boolean result = false;

		if (sv != null) {
			em.remove(sv);
			result = false;
		}
		return result;
	}

	@Override
	public List<SensorValue> getSensorValues(long sensorId) {
		String sql = "SELECT s FROM SensorValue s WHERE s.sensor.id = :sensorId";

		Query query = em.createQuery(sql);
		query.setParameter("sensorId", sensorId);
		List results = query.getResultList();

		@SuppressWarnings("unchecked")
		List<SensorValue> result = query.getResultList();
		
		return result;
	}

	private SensorValue getSensorValueById(long id) {
		return em.find(SensorValue.class, id);
	}
}
