package com.PBL4.test.DTO.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stop_Schedule_Response {

    String  stopStationName;
    String arrivalStationName;
    String departureStationName;
    double arrivalTime;
    LocalDateTime timeToRun;
    String scheduleId;
    List<String> orderedSeat;
}
