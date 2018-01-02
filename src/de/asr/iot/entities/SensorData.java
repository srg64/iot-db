package de.asr.iot.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * Class holding information on sensor data.
 */
@Entity
@Table(name = "sensor_data", uniqueConstraints=@UniqueConstraint(columnNames={"namespacename", "hostname", "sensorname", "createdat"}))
@NamedQuery(name = "AllSensorData", query = "select sd from SensorData sd")
public class SensorData {
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Timestamp version;
    
    @Column(length=255, nullable=false) 
    private String namespaceName;
    @Column(length=255, nullable=false) 
    private String hostName;
    @Column(length=255, nullable=false) 
    private String sensorName;
    @Column(length=255, nullable=false) 
    private String sensorType;
    @Column(nullable=false) 
    private Timestamp createdAt;
    @Column(nullable=false) 
    private Double value;
    @Column(length=50, nullable=false) 
    private String unit;
	@OneToOne
    private Namespace namespace;
	@OneToOne
    private Host host;
    @OneToOne
    private Sensor sensor;
    
    public SensorData() {
    }

	public SensorData(String namespaceName, String hostName, String sensorName, String sensorType, Timestamp createdAt, Double value, String unit) {
		this.namespaceName = namespaceName;
		this.hostName = hostName;
		this.sensorName = sensorName;
		this.sensorType = sensorType;
		this.createdAt = createdAt;
		this.value = value;
		this.unit = unit;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getVersion() {
		return version;
	}
	public void setVersion(Timestamp version) {
		this.version = version;
	}
    public String getNamespaceName() {
		return namespaceName;
	}
	public void setNamespaceName(String namespaceName) {
		this.namespaceName = namespaceName;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getSensorName() {
		return sensorName;
	}
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}
	public String getSensorType() {
		return sensorType;
	}
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
    public Namespace getNamespace() {
		return namespace;
	}
	public void setNamespace(Namespace namespace) {
		this.namespace = namespace;
	}
	public Host getHost() {
		return host;
	}
	public void setHost(Host host) {
		this.host = host;
	}
	public Sensor getSensor() {
		return sensor;
	}
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	@Override
	public String toString() {
		return "id: '" + id 
				+ "', version: '" + version 
				+ "', namespaceName: '" + namespaceName 
				+ "', hostName: '" + hostName 
				+ "', sensorName: '" + sensorName 
				+ "', sensorType: '" + sensorType 
				+ "', createdAt: '" + createdAt 
				+ "', value: '" + value 
				+ "', unit: '" + unit
				+ "'";
	}
}
