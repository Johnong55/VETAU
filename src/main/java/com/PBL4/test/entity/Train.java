package com.PBL4.test.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Train {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String TrainId;
	private String TrainName;
	
	
	
	@OneToMany(mappedBy = "train",fetch = FetchType.LAZY)
	private List<TrainTrip> trainTrips;
	
	@OneToMany(mappedBy = "train",fetch = FetchType.LAZY)
	private List<PriceList> priceLists;
	
	@OneToMany(mappedBy = "train",fetch = FetchType.LAZY)
	private List<Schedule> schedules;
	
	@OneToMany(mappedBy = "train", fetch = FetchType.LAZY)
	private List<Carriage> carriages;

	public List<Carriage> getCarriages() {
		return carriages;
	}

	public void setCarriages(List<Carriage> carriages) {
		this.carriages = carriages;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}



	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}



	public List<PriceList> getPriceLists() {
		return priceLists;
	}



	public void setPriceLists(List<PriceList> priceLists) {
		this.priceLists = priceLists;
	}



	public String getTrainId() {
		return TrainId;
	}



	public void setTrainId(String trainId) {
		TrainId = trainId;
	}



	public String getTrainName() {
		return TrainName;
	}



	public void setTrainName(String trainName) {
		TrainName = trainName;
	}



	public List<TrainTrip> getTrainTrips() {
		return trainTrips;
	}



	public void setTrainTrips(List<TrainTrip> trainTrips) {
		this.trainTrips = trainTrips;
	}



	public Train() {
			trainTrips = new ArrayList<>();
			carriages= new ArrayList<>();
			schedules = new ArrayList<>();
			priceLists = new ArrayList<>();
	}

	public void addtrainTrip(TrainTrip trainTrip) {
		trainTrips.add(trainTrip);
	}
	public void addcarriage(Carriage carriage) {
		carriages.add(carriage);
	}
	public void addSchedule(Schedule schedule) {
		schedules.add(schedule);
	}
}
