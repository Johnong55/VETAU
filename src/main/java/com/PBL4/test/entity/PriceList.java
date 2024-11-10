package com.PBL4.test.entity;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String priceListID;
    double price;

    @ManyToOne(cascade = CascadeType.ALL)
    TrainTrip_Carriage trainTrip_Carriage;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ArrivalStation")
    Station arrivalStation;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "DepartureStation")
    Station departureStation;
}
