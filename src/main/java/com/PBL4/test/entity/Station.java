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
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String stationId;
    String address;
    @Column(unique = true)
    String stationName;

    @ManyToOne
    @JoinColumn(name = "city_id")
    City city;
}
