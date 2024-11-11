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
    private String id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String address;
    private String phoneNumber;
    private String cid;
    String role;
//    private List<TicketResponse> tickets;
}
