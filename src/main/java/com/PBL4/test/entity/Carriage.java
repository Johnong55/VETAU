package com.PBL4.test.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Carriage {
    @Id
    String carriageId;
    String carriageName;
    String carriageRank;
    int seatCount;

    @OneToMany(mappedBy = "carriage", fetch = FetchType.LAZY)
    List<Seat> Seats;

    @OneToMany(mappedBy = "carriage")
    List<TrainTrip_Carriage> trainTripCarriages;
}
