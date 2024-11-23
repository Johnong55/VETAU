package com.PBL4.test.DTO.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FindSchedule_Response {
    String arrivalCity;
    String departureCity;
    LocalDateTime departureTimeAtDepartureCity;
    LocalDateTime arrivalTimeAtArrivalCity;
    String trainName;
}
