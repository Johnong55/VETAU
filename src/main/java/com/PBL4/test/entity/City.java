package com.PBL4.test.entity;

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
public class City {

    @Id
    String cityID;
    String cityName;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Station> stations;

    public void addStation(Station station) {
        stations.add(station);
        station.setCity(this);
    }
}
