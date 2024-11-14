package com.PBL4.test.DTO.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Schedule_Request {
    LocalDateTime timeToRun;
    LocalDateTime arrivalTime;
    String departureStationId;
    String arrivalStationId;
    String trainId;
}
