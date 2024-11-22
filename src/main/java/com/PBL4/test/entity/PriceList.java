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
    String priceListID;
    double price;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "seasonal_rate_id")
    SeasonalRate seasonalRate;

    @ManyToOne
    @JoinColumn(name ="departure_station_id")
    Station departureStation;

    @ManyToOne
    @JoinColumn(name = "arrival-Station_id")
    Station arrivalStation;

    @Enumerated(EnumType.STRING)
    CarriageClass carriageClass;

}
