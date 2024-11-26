package com.PBL4.test.DTO.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Schedule_Response {
    String scheduleId;
    LocalDateTime timeToRun;
    LocalDateTime arrivalTime;
    String departureStationName;
    String arrivalStationName;
    String trainId;
    List<String> stopStationName;
}
