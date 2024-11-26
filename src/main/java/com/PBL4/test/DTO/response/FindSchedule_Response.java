package com.PBL4.test.DTO.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

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
    public FindSchedule_Response(String departureCity, String arrivalCity,
                                 LocalDateTime departureTimeAtDepartureCity,
                                 LocalDateTime arrivalTimeAtArrivalCity,
                                 String trainName) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureTimeAtDepartureCity = departureTimeAtDepartureCity;
        this.arrivalTimeAtArrivalCity = arrivalTimeAtArrivalCity;
        this.trainName = trainName;
    }
}
