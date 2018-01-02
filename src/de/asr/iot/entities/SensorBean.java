package de.asr.iot.entities;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class SensorBean
 */
@Stateless
@LocalBean
public class SensorBean {

	@PersistenceContext(unitName="IOT-DB")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Sensor> getAllSensor() {
		return em.createNamedQuery("AllSensors").getResultList();
	}

	public void flush() {
		em.flush();
	}
	
	public void insertSensor(Sensor sensor) {
		em.persist(sensor);
		em.flush();
	}
	
	public void attachSensorDataToSensor(Sensor sensor, SensorData sensorData) {
		sensor.getHost().getSensorData().add(sensorData);
		sensor.getSensorData().add(sensorData);
		sensorData.setHost(sensor.getHost());
		sensorData.setSensor(sensor);
		em.flush();
	}
}
