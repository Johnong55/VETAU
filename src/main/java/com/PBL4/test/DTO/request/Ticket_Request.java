package com.PBL4.test.DTO.request;

import com.PBL4.test.entity.Account;
import com.PBL4.test.entity.PriceList;
import com.PBL4.test.entity.Schedule;
import com.PBL4.test.entity.Seat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket_Request {

    String purchaseMethod;
    String status = "AVAILABLE";
    String scheduleId;
    String departureStationName;
    String arrivalStationName;
    String accountId;
    String seatId;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;
    public String generateSkuTicket() {
        // Format the purchase date as a string (e.g., YYYYMMDDHHMMSS)


        // Combine fields to create a unique SKU
        return String.format(
                "SKU-%s-%s-%s-%s-%s-%s",
                scheduleId != null ? scheduleId : "UNKNOWN",
                departureStationName != null ? departureStationName : "UNKNOWN",
                arrivalStationName != null ? arrivalStationName : "UNKNOWN",
                accountId != null ? accountId : "UNKNOWN",
                seatId != null ? seatId : "UNKNOWN",
                departureTime != null ? departureTime : "UNKNOWN",
                arrivalTime !=null ? arrivalTime :"UNKNOWN",
                status != null ? status : "PENDING"

        );
    }

}
