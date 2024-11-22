package com.PBL4.test.DTO.request;

import com.PBL4.test.entity.Account;
import com.PBL4.test.entity.PriceList;
import com.PBL4.test.entity.Schedule;
import com.PBL4.test.entity.Seat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket_Request {

    String purchaseMethod;
    LocalDateTime purchaseDate;
    String status;

    String scheduleId;

    String priceList;

}
