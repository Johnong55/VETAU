package com.PBL4.test.entity;

import java.time.LocalDateTime;

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
	    name = "Ticket",
	    uniqueConstraints = @UniqueConstraint(
	        name = "sku_unique",
	        columnNames = "sku_TK"
	    )
	)
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String TicketId;
	@Column(nullable =  false, unique = true)
	private String sku_TK;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Trip")
	private TrainTrip trainTrip;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carriage")
	private  Carriage carriage;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ArrivalStation")
	private Station ArrivalStation;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DepartureStation")
	private Station DepartureStation;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SeatType")
	private SeatType seatType;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Train")
	private Train train;
	private LocalDateTime purchase_date;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seat")
	private Seat seat;

	private double price;
	public String getTicketId() {
		return TicketId;
	}
	public void setTicketId(String ticketId) {
		TicketId = ticketId;
	}
	public String getSku_TK() {
		return sku_TK;
	}
	public void setSku_TK(String sku_TK) {
		this.sku_TK = sku_TK;
	}
	public TrainTrip getTrainTrip() {
		return trainTrip;
	}
	public void setTrainTrip(TrainTrip trainTrip) {
		this.trainTrip = trainTrip;
	}
	public Carriage getCarriage() {
		return carriage;
	}
	public void setCarriage(Carriage carriage) {
		this.carriage = carriage;
	}
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
	public LocalDateTime getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(LocalDateTime purchase_date) {
		this.purchase_date = purchase_date;
	}
	
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
	
}
