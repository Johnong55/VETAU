package com.PBL4.test.DTO.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
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
    List<Carriage_Response> carriages;
    String scheduleId;
    public FindSchedule_Response(String scheduleId,String departureCity, String arrivalCity,
                                 LocalDateTime departureTimeAtDepartureCity,
                                 LocalDateTime arrivalTimeAtArrivalCity,
                                 String trainName) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureTimeAtDepartureCity = departureTimeAtDepartureCity;
        this.arrivalTimeAtArrivalCity = arrivalTimeAtArrivalCity;
        this.trainName = trainName;
        this.scheduleId = scheduleId;
    }
}
