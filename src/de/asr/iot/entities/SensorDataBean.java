package de.asr.iot.entities;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class SensorDataBean
 */
@Stateless
@LocalBean
public class SensorDataBean {

	@PersistenceContext(unitName="IOT-DB")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<SensorData> getAllSensorData() {
		return em.createNamedQuery("AllSensorData").getResultList();
	}

	public void insertSensorData(SensorData sensorData) {
		em.persist(sensorData);
		em.flush();
	}
}
