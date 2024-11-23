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
    String priceListId;
    String accountId;
    String seatId;
    public String generateSkuTicket() {
        // Format the purchase date as a string (e.g., YYYYMMDDHHMMSS)
        String formattedDate = purchaseDate != null ?
                purchaseDate.format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) :
                "00000000000000";

        // Combine fields to create a unique SKU
        return String.format(
                "SKU-%s-%s-%s-%s-%s-%s",
                scheduleId != null ? scheduleId : "UNKNOWN",
                priceListId != null ? priceListId : "UNKNOWN",
                accountId != null ? accountId : "UNKNOWN",
                seatId != null ? seatId : "UNKNOWN",
                status != null ? status : "PENDING",
                formattedDate
        );
    }

}
