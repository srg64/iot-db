package de.asr.iot.entities;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class HostBean
 */
@Stateless
@LocalBean
public class NamespaceBean {

	@PersistenceContext(unitName="IOT-DB")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Host> getAllHost() {
		return em.createNamedQuery("AllHosts").getResultList();
	}

	public void flush() {
		em.flush();
	}
	
	public void insertNamespace(Namespace namespace) {
		em.persist(namespace);
		em.flush();
	}
	
	public void attachSensorDataToNamespace(Namespace namespace, SensorData sensorData) {
		sensorData.setNamespace(namespace);
		namespace.getSensorData().add(sensorData);
		em.flush();
	}
}
