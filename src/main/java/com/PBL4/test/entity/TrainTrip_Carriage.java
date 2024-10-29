package com.PBL4.test.entity;

import jakarta.persistence.*;

@Entity
public class TrainTrip_Carriage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL)
    @JoinColumn(name = "Carriage")
    private Carriage carriage;
    @JoinColumn(name = "TrainTrip")
    @ManyToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL)
    private TrainTrip trainTrip;

    public TrainTrip_Carriage() {
        super();
    }

    public TrainTrip_Carriage(int id, Carriage carriage, TrainTrip trainTrip) {
        this.id = id;
        this.carriage = carriage;
        this.trainTrip = trainTrip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carriage getCarriage() {
        return carriage;
    }

    public void setCarriage(Carriage carriage) {
        this.carriage = carriage;
    }

    public TrainTrip getTrainTrip() {
        return trainTrip;
    }

    public void setTrainTrip(TrainTrip trainTrip) {
        this.trainTrip = trainTrip;
    }
}
