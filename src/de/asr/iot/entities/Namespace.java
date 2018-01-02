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
 * Class holding information on namespaces.
 */
@Entity
@Table(name = "namespace")
@NamedQuery(name = "AllNamespaces", query = "select n from Namespace n")
public class Namespace {
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Timestamp version;
    
    @Column(length=255, unique=true, nullable=false) 
    private String namespaceName;
    @OneToMany
    private Set<SensorData> sensorData;
    

    public Namespace() {
	}
	
    public Namespace(String namespaceName) {
		this.namespaceName = namespaceName;
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
	public Set<SensorData> getSensorData() {
		return sensorData;
	}
	public void setSensorData(Set<SensorData> sensorData) {
		this.sensorData = sensorData;
	}
}
