package com.PBL4.test.DTO.request;

import com.PBL4.test.entity.Carriage;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seat_Request {
    String carriageID;
}
