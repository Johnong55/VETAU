
package com.PBL4.test.entity;

import java.time.LocalDateTime;


import jakarta.persistence.*;

@Entity

public class StopSchedule {

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


	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Schedule Schedule;






	private LocalDateTime TimeToRun;
	private LocalDateTime ArrivalTime;




	public Schedule getSchedule() {
		return Schedule;
	}

	public void setSchedule(Schedule schedule) {
		Schedule = schedule;

	}

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
	  
	  
	  
	  public StopSchedule() { super(); // TODO Auto-generated constructor stub
	  }
	  
	
	
	

}
