package de.asr.iot.entities;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Class holding information on hosts.
 */
@Entity
@Table(name = "host"
)
@NamedQuery(name = "AllHosts", query = "select h from Host h")
public class Host {
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Timestamp version;
    
    @Column(length=255, unique=true, nullable=false) 
    private String hostName;
    @OneToMany
    private Set<Sensor> sensors;
    @OneToMany
    private Set<SensorData> sensorData;
    

    public Host() {
		super();
	}
	
    public Host(String hostName) {
		this.hostName = hostName;
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
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public Set<Sensor> getSensors() {
		return sensors;
	}
	public void setSensors(Set<Sensor> sensors) {
		this.sensors = sensors;
	}
	public Set<SensorData> getSensorData() {
		return sensorData;
	}
	public void setSensorData(Set<SensorData> sensorData) {
		this.sensorData = sensorData;
	}
	
}
