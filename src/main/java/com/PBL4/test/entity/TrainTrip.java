package com.PBL4.test.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class TrainTrip {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String TrainTripId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Train", nullable = true)
	private Train train;
	private LocalDate ngaydi;
	private LocalDate ngayde;
	@OneToMany(mappedBy = "traintrip", fetch = FetchType.LAZY)
	private List<TrainTrip_Carriage> trainTrip_Carriages;
	
	public List<TrainTrip_Carriage> getTrainTrip_Carriages() {
		return trainTrip_Carriages;
	}
	public void setTrainTrip_Carriages(List<TrainTrip_Carriage> trainTrip_Carriages) {
		this.trainTrip_Carriages = trainTrip_Carriages;
	}
	public String getTrainTripId() {
		return TrainTripId;
	}
	public void setTrainTripId(String trainTripId) {
		TrainTripId = trainTripId;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public Train getTau() {
		return train;
	}
	public void setTau(Train train) {
		this.train = train;
	}
	public LocalDate getNgaydi() {
		return ngaydi;
	}
	public void setNgaydi(LocalDate ngaydi) {
		this.ngaydi = ngaydi;
	}
	public LocalDate getNgayde() {
		return ngayde;
	}
	public void setNgayde(LocalDate ngayde) {
		this.ngayde = ngayde;
	}
	public TrainTrip() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChuyenTau [id=" + TrainTripId + ", tau=" + train + ", ngaydi=" + ngaydi + ", ngayde=" + ngayde + "]";
	}
	
	
}
