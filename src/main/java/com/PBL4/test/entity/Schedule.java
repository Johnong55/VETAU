package com.PBL4.test.entity;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
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
public class Schedule {
    @Id
    String scheduleId;

    LocalDateTime departureTime;
    LocalDateTime arrivalTime;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "DepartureStation")
    Station departureStation;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "ArrivalStation")
    Station arrivalStation;

    @ManyToOne
    @JoinColumn(name = "train_id")
    Train train;

    @OneToMany(mappedBy = "schedule", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    List<PriceList> priceLists;
    @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    List<StopSchedule> stopSchedules;


}