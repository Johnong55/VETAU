package com.PBL4.test.DTO.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ListTrip_Request {
    String StarCity;
    String EndCity;
    LocalDate StartDate;
}
