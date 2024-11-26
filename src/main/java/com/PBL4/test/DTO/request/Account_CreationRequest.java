package com.PBL4.test.DTO.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account_CreationRequest {
    @Size(min = 5, message = "INVALID_USERNAME")
    String username;

    String email;
    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;

    String firstName;
    String lastName;
    LocalDate dob;
    String address;
    String phoneNumber;

    String cid; // citizen identification card
}
