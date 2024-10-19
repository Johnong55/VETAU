package com.PBL4.test.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(
	    name = "Seat",
	    uniqueConstraints = @UniqueConstraint(
	        name = "sku_unique",
	        columnNames = "sku"
	    )
	)
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String SeatID;
	@Column(nullable =  false, unique = true)
	private String sku;
	
	public String getSku() {
		return sku;
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Carriage")
	private Carriage Carriage_id;
	
	
	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "TypeofSeat")
	private SeatType TypeofSeat;
	
	private int situation;
	
	public SeatType getTypeofSeat() {
		return TypeofSeat;
	}

	public void setTypeofSeat(SeatType typeofSeat) {
		TypeofSeat = typeofSeat;
	}

	public int getSituation() {
		return situation;
	}

	public void setSituation(int situation) {
		this.situation = situation;
	}

	public String getSeatID() {
		return SeatID;
	}

	public void setSeatID(String seatID) {
		SeatID = seatID;
	}

	public SeatType getSeatType() {
		return TypeofSeat;
	}

	public void setSeatType(SeatType seatType) {
		this.TypeofSeat = seatType;
	}

	public Carriage getCarriage_id() {
		return Carriage_id;
	}

	public void setCarriage_id(Carriage carriage_id) {
		Carriage_id = carriage_id;
	}

	public String getMachongoi() {
		return SeatID;
	}
	public void setMachongoi(String machongoi) {
		SeatID = machongoi;
	}

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
