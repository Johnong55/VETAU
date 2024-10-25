package com.PBL4.test.DTO.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seat_Response {
    String IdSeat;
    String Seat_Name;
    String Seat_Status;
}
