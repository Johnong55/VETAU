package com.PBL4.test.DTO.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket_Response {
    String sku;
    String purchaseMethod;
    LocalDateTime purchaseDate;
    String status;
    String scheduleId;
    String Train;
    String departureStation;
    String arrivalStation;
    String account;
    String Carriage;
    String seat;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;
    long total;
}
