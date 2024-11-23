package com.PBL4.test.DTO.request;


import com.PBL4.test.enums.CarriageClass;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceList_Request {
    @NotNull
    String departureStationId;
    @NotNull
    String arrivalStationId;
    @NotNull
    String scheduleId;
    @NotNull
    CarriageClass carriageClass;
    @NotNull
    double price;

    String seasonalRateId;
}