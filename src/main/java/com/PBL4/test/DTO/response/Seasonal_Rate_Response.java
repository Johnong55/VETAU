package com.PBL4.test.DTO.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seasonal_Rate_Response {
    String seasonalRateId;
    String seasonName;
    double rateMultiplier;
}
