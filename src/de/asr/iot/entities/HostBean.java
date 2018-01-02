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
public class HostBean {

	@PersistenceContext(unitName="IOT-DB")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Host> getAllHost() {
		return em.createNamedQuery("AllHosts").getResultList();
	}

	public void flush() {
		em.flush();
	}
	
	public void insertHost(Host host) {
		em.persist(host);
		em.flush();
	}
	
	public void attachSensorToHost(Host host, Sensor sensor) {
		sensor.setHost(host);
		host.getSensors().add(sensor);
		em.flush();
	}
}
