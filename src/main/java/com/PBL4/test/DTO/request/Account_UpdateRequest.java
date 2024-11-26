package com.PBL4.test.DTO.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account_UpdateRequest {
    @Size(min = 8, message = "INVALID_PASSWORD")
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String address;
    private String email;
    private String phoneNumber;

}
