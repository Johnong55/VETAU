
package com.PBL4.test.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class SeatType {

	@Id
	private String SeatTypeId;

	@OneToMany(mappedBy = "TypeofSeat", fetch = FetchType.LAZY)
	private List<Carriage> carriages;

	@OneToMany(mappedBy = "TypeofSeat", fetch = FetchType.LAZY)
	private List<Seat> seats;

	@OneToOne( fetch = FetchType.LAZY)
	private PriceList price;

	public PriceList getPrice() {
		return price;
	}

	public void setPrice(PriceList price) {
		this.price = price;
	}

	public String getSeatTypeId() {
		return SeatTypeId;
	}

	public void setSeatTypeId(String seatTypeId) {
		SeatTypeId = seatTypeId;
	}

	public List<Carriage> getCarriages() {
		return carriages;
	}

	public void setCarriages(List<Carriage> carriages) {
		this.carriages = carriages;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public SeatType() {
		super();
		// TODO Auto-generated constructor stub
	}

}
