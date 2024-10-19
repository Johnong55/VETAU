package com.PBL4.test.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class TrainTrip_Carriage {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String ID;
	@ManyToOne(cascade = CascadeType.ALL)
	private TrainTrip traintrip;
	@ManyToOne(cascade = CascadeType.ALL)
	private Carriage carriage;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public TrainTrip getTraintrip() {
		return traintrip;
	}
	public void setTraintrip(TrainTrip traintrip) {
		this.traintrip = traintrip;
	}
	public Carriage getCarriage() {
		return carriage;
	}
	public void setCarriage(Carriage carriage) {
		this.carriage = carriage;
	}
	public TrainTrip_Carriage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
