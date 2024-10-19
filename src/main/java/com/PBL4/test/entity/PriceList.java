package com.PBL4.test.entity;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity

public class PriceList {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String PriceList_ID;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "price")
	private SeatType seatType;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(nullable = true)
	private Train train;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ArrivalStation")

	private Station ArrivalStation;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DepartureStation")
	private Station DepartureStation;
	
	private double giatien;

	
	public Station getArrivalStation() {
		return ArrivalStation;
	}

	public void setArrivalStation(Station arrivalStation) {
		ArrivalStation = arrivalStation;
	}

	public Station getDepartureStation() {
		return DepartureStation;
	}

	public void setDepartureStation(Station departureStation) {
		DepartureStation = departureStation;
	}

	public String getPriceList_ID() {
		return PriceList_ID;
	}

	public void setPriceList_ID(String priceList_ID) {
		PriceList_ID = priceList_ID;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public double getGiatien() {
		return giatien;
	}

	public void setGiatien(double giatien) {
		this.giatien = giatien;
	}

	public PriceList() { super(); // TODO Auto-generated constructor stub 
	
	}
	

}
