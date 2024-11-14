
package com.PBL4.test.entity;

import java.time.LocalDateTime;


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
    LocalDateTime ArrivalTime;

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

    @OneToOne
    @JoinColumn(name = "StopStation")
    Station stopStation;
}
