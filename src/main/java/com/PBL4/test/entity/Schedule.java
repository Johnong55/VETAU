package com.PBL4.test.entity;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Schedule {
    @Id
    private String ScheduleId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "train", nullable = true)
    private Train train;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Schedules")
    private List<StopStation> stopStations;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DepartureStation")
    private Station DepartureStation;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ArrivalStation")
    private Station ArrivalStation;
    
    // Getters and setters remain the same
    
    
    public Schedule() {
        super();
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

	public List<StopStation> getStopStations() {
		return stopStations;
	}

	public void setStopStations(List<StopStation> stopStations) {
		this.stopStations = stopStations;
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