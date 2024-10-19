
package com.PBL4.test.entity;

import java.time.LocalDateTime;

import java.util.List;



import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity

public class StopStation  {

	@Id
	@GeneratedValue(strategy =GenerationType.UUID)
	private String ID;
	

	@ManyToOne
	@JoinColumn(name = "ArrivalStation")
	private Station ArrivalStation;
	
	@ManyToOne
	  @JoinColumn(name = "DepartureStation")
	private Station DepartureStation;
	
	@ManyToOne
	@JoinColumn(name = "Train")
	private Train train;
	
	@ManyToOne
	@JoinColumn(name = "Schedules")
	private Schedule Schedules;
	
	@OneToOne
	@JoinColumn(name = "StopStation")
	private Station stopstation;
	
	private LocalDateTime TimeToRun;
	
	private LocalDateTime ArrivalTime;
	
	
	  public Schedule getSchedules() {
		return Schedules;
	}

	public void setSchedules(Schedule schedules) {
		Schedules = schedules;
	}

	public Station getStopstation() {
		return stopstation;
	}

	public void setStopstation(Station stopstation) {
		this.stopstation = stopstation;
	}

	public LocalDateTime getTimeToRun() {
		return TimeToRun;
	}

	public void setTimeToRun(LocalDateTime timeToRun) {
		TimeToRun = timeToRun;
	}

	public LocalDateTime getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		ArrivalTime = arrivalTime;
	}

	public Schedule getLichtrinh() {
		return Schedules;
	}

	public void setLichtrinh(Schedule lichtrinh) {
		this.Schedules = lichtrinh;
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

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public String getID() { return ID; }
	  
	  public void setID(String iD) { ID = iD; }
	  
	  
	  
	  public StopStation() { super(); // TODO Auto-generated constructor stub 
	  }
	  
	
	
	

}
