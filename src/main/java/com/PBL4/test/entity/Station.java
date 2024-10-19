
package com.PBL4.test.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity

public class Station {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String StationId;

	@Column(unique = true)
	private String StationName;

	@ManyToOne(cascade = CascadeType.ALL)
	private City CityId;
	
	private String address;

	
	public String getStationId() {
		return StationId;
	}

	public void setStationId(String stationId) {
		StationId = stationId;
	}

	public String getStationName() {
		return StationName;
	}

	public void setStationName(String stationName) {
		StationName = stationName;
	}

	public City getCityId() {
		return CityId;
	}

	public void setCityId(City cityId) {
		CityId = cityId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Station() {
		super(); // TODO Auto-generated constructor stub

	}

}
