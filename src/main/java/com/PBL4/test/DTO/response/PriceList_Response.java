package com.PBL4.test.DTO.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceList_Response {
    String departureStationName;
    String arrivalStationName;
    String scheduleId;
    String carriageClass;
    String seasonName;
    double rateMultiplier;
    double price;


}
