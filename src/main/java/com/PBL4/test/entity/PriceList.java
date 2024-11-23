package com.PBL4.test.entity;

import com.PBL4.test.enums.CarriageClass;
import io.micrometer.common.lang.Nullable;
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

public class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String priceListID;
    double price;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "seasonal_Rate")
    SeasonalRate seasonalRate;

    @ManyToOne
    @JoinColumn(name ="DepartureStation")
    Station departureStation;

    @ManyToOne
    @JoinColumn(name = "ArrivalStation")
    Station arrivalStation;

    @Enumerated(EnumType.STRING)
    CarriageClass carriageClass;

}
