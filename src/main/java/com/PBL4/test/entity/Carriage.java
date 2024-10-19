package com.PBL4.test.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Carriage {
	@Id
	private String CarriageId;
	private String CarriageName;
	private int SeatCount;

	@OneToMany(mappedBy = "Carriage_id", fetch = FetchType.LAZY)
	private List<Seat> ListOfSeat;
	
	@OneToMany(mappedBy = "carriage",fetch = FetchType.LAZY)
	private List<TrainTrip_Carriage> trip_Carriages;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TypeofSeat")
	private SeatType  TypeofSeat;
	
	
	public SeatType getSeatType() {
		return TypeofSeat;
	}

	public void setSeatType(SeatType seatType) {
		this.TypeofSeat = seatType;
	}

	public String getCarriageId() {
		return CarriageId;
	}

	public void setCarriageId(String carriageId) {
		CarriageId = carriageId;
	}

	public String getCarriageName() {
		return CarriageName;
	}

	public void setCarriageName(String carriageName) {
		CarriageName = carriageName;
	}

	public int getSeatCount() {
		return SeatCount;
	}

	public void setSeatCount(int seatCount) {
		SeatCount = seatCount;
	}

	public List<Seat> getListOfSeat() {
		return ListOfSeat;
	}

	public void setListOfSeat(List<Seat> listOfSeat) {
		ListOfSeat = listOfSeat;
	}

	public List<TrainTrip_Carriage> getTrip_Carriages() {
		return trip_Carriages;
	}

	public void setTrip_Carriages(List<TrainTrip_Carriage> trip_Carriages) {
		this.trip_Carriages = trip_Carriages;
	}
	

}
