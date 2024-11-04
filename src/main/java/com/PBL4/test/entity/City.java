package com.PBL4.test.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class City {

	@Id
	private String CityID;
	private String CityName;

	@OneToMany(mappedBy = "CityId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Station> stations;



	/* getter and setter */



	public String getCityID() {
		return CityID;
	}

	public void setCityID(String cityID) {
		CityID = cityID;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
	public void addStation(Station station) {
		stations.add(station);
	}
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
