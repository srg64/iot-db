package de.asr.iot.entities;

import java.sql.Timestamp;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class Persistence
 */
@Stateless
@LocalBean
public class PersistenceBean {
	@EJB
	NamespaceBean namespaceBean;
	@EJB
	HostBean hostBean;
	@EJB
	SensorBean sensorBean;
	@EJB
	SensorDataBean sensorDataBean;

	@PersistenceContext(unitName="IOT-DB")
	private EntityManager em;

	/**
     * Default constructor. 
     */
    public PersistenceBean() {
    }

	public Host getHostByHostName(String hostName) {
		try {
			return em.createQuery("select h from Host h where h.hostName = :hostName", Host.class)
					.setParameter("hostName", hostName)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public Namespace getNamespaceByNamespaceName(String namespaceName) {
		try {
			return em.createQuery("select n from Namespace n where n.namespaceName = :namespaceName", Namespace.class)
					.setParameter("namespaceName", namespaceName)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public Sensor getSensorByHostNameSensorName(String hostName, String sensorName) {
		try {
			return em.createQuery("select s from Sensor s where s.hostName = :hostName and s.sensorName = :sensorName", Sensor.class)
					.setParameter("hostName", hostName)
					.setParameter("sensorName", sensorName)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public void addSensorDataToDataBase(String sensorDataCSV) {
		// TODO Optimize method: Create and use simple cache for namespace, host and sensor  
		if (sensorDataCSV == null || sensorDataCSV.isEmpty()) {
			return;
		}
		String[] sensorDataSet = sensorDataCSV.split("\\s{1,2}");
		if (sensorDataSet == null || sensorDataSet.length == 0) {
			return;
		}
		for (int i = 0; i < sensorDataSet.length; i++) {
			String[] sensorDataParameters = sensorDataSet[i].split(";");
			if (sensorDataParameters == null || sensorDataParameters.length != 7) {
				return;
			}
			String namespaceName = sensorDataParameters[0];
			String hostName = sensorDataParameters[1];
			String sensorName = sensorDataParameters[2];
			String sensorType = sensorDataParameters[3];
			Timestamp createdAt = new Timestamp(Long.parseLong(sensorDataParameters[4]));
			Double value = Double.valueOf(sensorDataParameters[5]);
			String unit = sensorDataParameters[6];
			
			Namespace namespace = fetchOrInsertNamespace(namespaceName);
			Host host = fetchOrInsertHost(hostName);
			Sensor sensor = fetchOrInsertSensor(hostName, sensorName, sensorType, unit, host);
			
			insertSensorData(namespaceName, hostName, sensorName, sensorType, createdAt, value, unit, namespace, host, sensor);
		}
	}

	public Namespace fetchOrInsertNamespace(String namespaceName) {
		Namespace namespace = getNamespaceByNamespaceName(namespaceName);
		if (namespace == null) {
			namespace = new Namespace(namespaceName);
			em.persist(namespace);
			em.flush();
		}
		return namespace;
	}

	public Host fetchOrInsertHost(String hostName) {
		Host host = getHostByHostName(hostName);
		if (host == null) {
			host = new Host(hostName);
			em.persist(host);
			em.flush();
		}
		return host;
	}

	public Sensor fetchOrInsertSensor(String hostName, String sensorName, String sensorType, String unit, Host host) {
		Sensor sensor = getSensorByHostNameSensorName(hostName, sensorName);
		if (sensor == null) {
			sensor = new Sensor(hostName, sensorName, sensorType, unit);
			em.persist(sensor);
			em.flush();
			sensor.setHost(host);
			host.getSensors().add(sensor);
		}
		return sensor;
	}

	public SensorData insertSensorData(String namespaceName, String hostName, String sensorName, String sensorType,
			Timestamp createdAt, Double value, String unit, Namespace namespace, Host host, Sensor sensor) {
		SensorData sensorData = new SensorData(namespaceName, hostName, sensorName, sensorType, createdAt, value, unit);
		em.persist(sensorData);
		em.flush();
		namespace.getSensorData().add(sensorData);
		host.getSensorData().add(sensorData);
		sensor.getSensorData().add(sensorData);
		sensorData.setNamespace(namespace);
		sensorData.setHost(sensor.getHost());
		sensorData.setSensor(sensor);
		return sensorData;
	}

	public void createTestData() {
		// Create standard test data
		Namespace namespace01 = new Namespace("namespace01");
		Host host01 = new Host("hostname01");
		Host host02 = new Host("hostname02");
		Sensor sensor01 = new Sensor("hostname01", "sensorname01", "sensortype01", "unit01");
		Sensor sensor02 = new Sensor("hostname01", "sensorname02", "sensortype02", "unit02");
		Sensor sensor03 = new Sensor("hostname02", "sensorname03", "sensortype01", "unit01");
		Sensor sensor04 = new Sensor("hostname02", "sensorname04", "sensortype02", "unit02");
		long now = System.currentTimeMillis();
		SensorData sensor01Data = new SensorData("namespace01", "hostname01", "sensorname01", "sensortype01", new Timestamp(now - ( 1 * 60000)),  1.0, "unit01");
		SensorData sensor02Data = new SensorData("namespace01", "hostname01", "sensorname01", "sensortype01", new Timestamp(now - ( 2 * 60000)),  2.0, "unit01");
		SensorData sensor03Data = new SensorData("namespace01", "hostname01", "sensorname01", "sensortype01", new Timestamp(now - ( 3 * 60000)),  3.0, "unit01");
		SensorData sensor04Data = new SensorData("namespace01", "hostname01", "sensorname01", "sensortype01", new Timestamp(now - ( 4 * 60000)),  4.0, "unit01");
		SensorData sensor05Data = new SensorData("namespace01", "hostname01", "sensorname02", "sensortype02", new Timestamp(now - ( 5 * 60000)),  5.0, "unit02");
		SensorData sensor06Data = new SensorData("namespace01", "hostname01", "sensorname02", "sensortype02", new Timestamp(now - ( 6 * 60000)),  6.0, "unit02");
		SensorData sensor07Data = new SensorData("namespace01", "hostname01", "sensorname02", "sensortype02", new Timestamp(now - ( 7 * 60000)),  7.0, "unit02");
		SensorData sensor08Data = new SensorData("namespace01", "hostname01", "sensorname02", "sensortype02", new Timestamp(now - ( 8 * 60000)),  8.0, "unit02");
		SensorData sensor09Data = new SensorData("namespace01", "hostname02", "sensorname03", "sensortype01", new Timestamp(now - ( 9 * 60000)),  9.0, "unit01");
		SensorData sensor10Data = new SensorData("namespace01", "hostname02", "sensorname03", "sensortype01", new Timestamp(now - (10 * 60000)), 10.0, "unit01");
		SensorData sensor11Data = new SensorData("namespace01", "hostname02", "sensorname03", "sensortype01", new Timestamp(now - (11 * 60000)), 11.0, "unit01");
		SensorData sensor12Data = new SensorData("namespace01", "hostname02", "sensorname03", "sensortype01", new Timestamp(now - (12 * 60000)), 12.0, "unit01");
		SensorData sensor13Data = new SensorData("namespace01", "hostname02", "sensorname04", "sensortype02", new Timestamp(now - (13 * 60000)), 13.0, "unit02");
		SensorData sensor14Data = new SensorData("namespace01", "hostname02", "sensorname04", "sensortype02", new Timestamp(now - (14 * 60000)), 14.0, "unit02");
		SensorData sensor15Data = new SensorData("namespace01", "hostname02", "sensorname04", "sensortype02", new Timestamp(now - (15 * 60000)), 15.0, "unit02");
		SensorData sensor16Data = new SensorData("namespace01", "hostname02", "sensorname04", "sensortype02", new Timestamp(now - (16 * 60000)), 16.0, "unit02");
		
		namespaceBean.insertNamespace(namespace01);
		
		hostBean.insertHost(host01);
		hostBean.insertHost(host02);
		
		sensorBean.insertSensor(sensor01);
		sensorBean.insertSensor(sensor02);
		sensorBean.insertSensor(sensor03);
		sensorBean.insertSensor(sensor04);
		
		sensorDataBean.insertSensorData(sensor01Data);
		sensorDataBean.insertSensorData(sensor02Data);
		sensorDataBean.insertSensorData(sensor03Data);
		sensorDataBean.insertSensorData(sensor04Data);
		sensorDataBean.insertSensorData(sensor05Data);
		sensorDataBean.insertSensorData(sensor06Data);
		sensorDataBean.insertSensorData(sensor07Data);
		sensorDataBean.insertSensorData(sensor08Data);
		sensorDataBean.insertSensorData(sensor09Data);
		sensorDataBean.insertSensorData(sensor10Data);
		sensorDataBean.insertSensorData(sensor11Data);
		sensorDataBean.insertSensorData(sensor12Data);
		sensorDataBean.insertSensorData(sensor13Data);
		sensorDataBean.insertSensorData(sensor14Data);
		sensorDataBean.insertSensorData(sensor15Data);
		sensorDataBean.insertSensorData(sensor16Data);
		
		hostBean.attachSensorToHost(host01, sensor01);
		hostBean.attachSensorToHost(host01, sensor02);
		hostBean.attachSensorToHost(host02, sensor03);
		hostBean.attachSensorToHost(host02, sensor04);
		
		sensorBean.attachSensorDataToSensor(sensor01, sensor01Data);
		sensorBean.attachSensorDataToSensor(sensor01, sensor02Data);
		sensorBean.attachSensorDataToSensor(sensor01, sensor03Data);
		sensorBean.attachSensorDataToSensor(sensor01, sensor04Data);
		sensorBean.attachSensorDataToSensor(sensor02, sensor05Data);
		sensorBean.attachSensorDataToSensor(sensor02, sensor06Data);
		sensorBean.attachSensorDataToSensor(sensor02, sensor07Data);
		sensorBean.attachSensorDataToSensor(sensor02, sensor08Data);
		sensorBean.attachSensorDataToSensor(sensor03, sensor09Data);
		sensorBean.attachSensorDataToSensor(sensor03, sensor10Data);
		sensorBean.attachSensorDataToSensor(sensor03, sensor11Data);
		sensorBean.attachSensorDataToSensor(sensor03, sensor12Data);
		sensorBean.attachSensorDataToSensor(sensor04, sensor13Data);
		sensorBean.attachSensorDataToSensor(sensor04, sensor14Data);
		sensorBean.attachSensorDataToSensor(sensor04, sensor15Data);
		sensorBean.attachSensorDataToSensor(sensor04, sensor16Data);

		namespaceBean.attachSensorDataToNamespace(namespace01, sensor01Data);
		namespaceBean.attachSensorDataToNamespace(namespace01, sensor02Data);
		namespaceBean.attachSensorDataToNamespace(namespace01, sensor03Data);
		namespaceBean.attachSensorDataToNamespace(namespace01, sensor04Data);
		namespaceBean.attachSensorDataToNamespace(namespace01, sensor05Data);
		namespaceBean.attachSensorDataToNamespace(namespace01, sensor06Data);
		namespaceBean.attachSensorDataToNamespace(namespace01, sensor07Data);
		namespaceBean.attachSensorDataToNamespace(namespace01, sensor08Data);
		namespaceBean.attachSensorDataToNamespace(namespace01, sensor09Data);
		namespaceBean.attachSensorDataToNamespace(namespace01, sensor10Data);
		namespaceBean.attachSensorDataToNamespace(namespace01, sensor11Data);
		namespaceBean.attachSensorDataToNamespace(namespace01, sensor12Data);
		namespaceBean.attachSensorDataToNamespace(namespace01, sensor13Data);
		namespaceBean.attachSensorDataToNamespace(namespace01, sensor14Data);
		namespaceBean.attachSensorDataToNamespace(namespace01, sensor15Data);
		namespaceBean.attachSensorDataToNamespace(namespace01, sensor16Data);
	}
}
