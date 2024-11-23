package com.PBL4.test.entity;

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
public class SeasonalRate {
    @Id
    String seasonalRateId;

    String seasonName;
    double rateMultiplier;

    @OneToMany(mappedBy = "seasonalRate", cascade = CascadeType.ALL)

    List<PriceList> priceList;
}
