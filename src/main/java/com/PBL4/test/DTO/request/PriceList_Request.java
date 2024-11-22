package com.PBL4.test.DTO.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceList_Request {
    String departureStationId;
    String arrivalStationId;
    String scheduleId;
    String carriageClass;
    double seasonalRateId;
    double price;
}
