package com.PBL4.test.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Schedule {
    @Id
    private String ScheduleId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "train", nullable = true)
    private Train train;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DepartureStation")
    private Station DepartureStation;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ArrivalStation")
    private Station ArrivalStation;
	private LocalDateTime TimeToRun;
	private LocalDateTime ArrivalTime;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private TrainTrip traintrip;

	@OneToMany(mappedBy = "Schedules",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<StopSchedule> stopSchedules;






	public List<StopSchedule> getStopSchedules() {
		return stopSchedules;
	}

	public void setStopSchedules(List<StopSchedule> stopSchedules) {
		this.stopSchedules = stopSchedules;
	}

// Getters and setters


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

	public TrainTrip getTraintrip() {
		return traintrip;
	}

	public void setTraintrip(TrainTrip traintrip) {
		this.traintrip = traintrip;
	}

	public Schedule() {
		stopSchedules = new ArrayList<StopSchedule>();
    }

	public String getScheduleId() {
		return ScheduleId;
	}

	public void setScheduleId(String scheduleId) {
		ScheduleId = scheduleId;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}


	public Station getDepartureStation() {
		return DepartureStation;
	}

	public void setDepartureStation(Station departureStation) {
		DepartureStation = departureStation;
	}

	public Station getArrivalStation() {
		return ArrivalStation;
	}

	public void setArrivalStation(Station arrivalStation) {
		ArrivalStation = arrivalStation;
	}
    
    // Rest of the code remains the same
}