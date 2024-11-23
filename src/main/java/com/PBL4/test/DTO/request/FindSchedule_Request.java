package com.PBL4.test.DTO.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FindSchedule_Request {
    String departureCity;
    String arrivalCity;
    LocalDate departureDate;
}
