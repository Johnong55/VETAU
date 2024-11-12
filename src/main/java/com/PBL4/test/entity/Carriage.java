package com.PBL4.test.entity;

import com.PBL4.test.enums.CarriageClass;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Carriage {
    @Id
    String carriageId;
    int seatCount;
    String carriageName;

    @Enumerated(EnumType.STRING)
    CarriageClass carriageClass;

    @OneToMany(mappedBy = "carriage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Seat> seats;

    @OneToMany(mappedBy = "carriage")
    List<TrainTrip_Carriage> trainTripCarriages;
}
