package com.PBL4.test.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class TrainTrip_Carriage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carriage_id") // tên khóa ngoại rõ ràng hơn
    private Carriage carriage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_trip_id") // tên khóa ngoại rõ ràng hơn
    private TrainTrip trainTrip;

}
