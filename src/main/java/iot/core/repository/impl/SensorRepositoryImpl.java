package iot.core.repository.impl;

import iot.core.entities.sensor.Sensor;
import iot.core.repository.SensorRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;



@Repository
public class SensorRepositoryImpl implements SensorRepo {

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean addSensor(Sensor sensor) {
		em.persist(sensor);

		return true;
	}

	@Override
	public boolean removeSensor(long sensorId) {
		Sensor sensor = getSensorById(sensorId);
		boolean result = false;
		if (sensor != null) {
			em.remove(sensor);
			result = true;
		}

		return result;
	}

	@Override
	public boolean editSensor(Sensor sensor) {
		em.persist(sensor);

		return true;
	}

	@Override
	public List<Sensor> getDeviceSensors(long deviceId) {
		String sql = "SELECT s FROM Sensor s WHERE s.device.id = :deviceId";

		Query query = em.createQuery(sql);
		query.setParameter("deviceId", deviceId);

		@SuppressWarnings("unchecked")
		List<Sensor> result = query.getResultList();
		
		return result;
	}

	@Override
	public Sensor getSensorById(long sensorId) {
		Sensor sensor = em.find(Sensor.class, sensorId);

		return sensor;
	}

}
