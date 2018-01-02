package de.asr.iot.entities;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * Class holding information on sensors.
 */
@Entity
@Table(name = "sensor", uniqueConstraints=@UniqueConstraint(columnNames={"hostname", "sensorname"}))
@NamedQuery(name = "AllSensors", query = "select s from Sensor s")
public class Sensor {
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Timestamp version;
    
    @Column(length=255, nullable=false) 
    private String hostName;
    @Column(length=255, nullable=false) 
    private String sensorName;
    @Column(length=255, nullable=false) 
    private String sensorType;
    @Column(length=255, nullable=false) 
    private String unit;
    @OneToOne
    private Host host;
    @OneToMany
    private Set<SensorData> sensorData;

    public Sensor() {
		super();
	}
    
	public Sensor(String hostName, String sensorName, String sensorType, String unit) {
		this.hostName = hostName;
		this.sensorName = sensorName;
		this.sensorType = sensorType;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Set<SensorData> getSensorData() {
		return sensorData;
	}
	public void setSensorData(Set<SensorData> sensorData) {
		this.sensorData = sensorData;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public Host getHost() {
		return host;
	}
	public void setHost(Host host) {
		this.host = host;
	}
}
