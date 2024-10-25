package com.PBL4.test.DTO.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Carriage_Response {
    String IdCarriage;
    String Carriage_Name;
    String Carriage_Price;
    Set<Seat_Response> listSeat;
}