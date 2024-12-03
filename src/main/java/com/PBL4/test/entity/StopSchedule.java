
package com.PBL4.test.entity;

import java.time.LocalDateTime;
import java.util.List;


import com.PBL4.test.DTO.request.StopSchedule_Request;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class StopSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String ID;
    LocalDateTime TimeToRun;
    double ArrivalTime;

    
    @ManyToOne
    @JoinColumn(name = "ArrivalStation")
    Station ArrivalStation;

    @ManyToOne
    @JoinColumn(name = "DepartureStation")
    Station DepartureStation;

    @ManyToOne
    @JoinColumn(name = "Train")
    Train train;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule")
    Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "StopStation")
    Station stopStation;
    //ghe da order
    @ElementCollection
    List<String> orderedSeat ;
    @Override
    public String toString() {
            return "Arrival" + this.getArrivalStation().getStationId() +"\n departure: "+ getDepartureStation().getStationId()+"\n train"+getTrain().getTrainId()+"\n station"+stopStation.getStationId();
    }
}