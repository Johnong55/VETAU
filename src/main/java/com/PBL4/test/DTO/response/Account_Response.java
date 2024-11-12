package com.PBL4.test.DTO.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account_Response {
    String id;
    String username;
    String email;
    String firstName;
    String lastName;
    LocalDate dob;
    String address;
    String phoneNumber;
    String cid;
    String role;
//    private List<TicketResponse> tickets;
}
