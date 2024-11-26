package com.PBL4.test.DTO.response;


import com.PBL4.test.enums.CarriageClass;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceList_Response {
    String priceListID;
    String departureStationName;
    String arrivalStationName;
    String scheduleId;
    CarriageClass carriageClass;
    String seasonName;
    String trainName;
    double rateMultiplier;
    double price;


}