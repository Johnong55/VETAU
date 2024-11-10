package com.PBL4.test.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String trainId;
    String trainName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<TrainTrip> trainTrips;

    @OneToMany(fetch = FetchType.LAZY)
    List<Schedule> schedules;

    public void addTrainTrip(TrainTrip trainTrip) {
        trainTrips.add(trainTrip);
        trainTrip.setTrain(this);
    }
}
