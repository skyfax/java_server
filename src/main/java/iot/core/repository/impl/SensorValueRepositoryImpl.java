package iot.core.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<SensorValue> cq = cb.createQuery(SensorValue.class);
		Root<SensorValue> sv = cq.from(SensorValue.class);

		cq.select(sv);
		cq.where(cb.equal(sv.get("sensor.id"), sensorId));
		Query query = em.createQuery(cq);

		@SuppressWarnings("unchecked")
		List<SensorValue> result = query.getResultList();
		
		return result;
	}

	private SensorValue getSensorValueById(long id) {
		return em.find(SensorValue.class, id);
	}
}
