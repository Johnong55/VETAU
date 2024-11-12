package com.PBL4.test.DTO.response;

import com.PBL4.test.entity.Carriage;
import com.PBL4.test.entity.Seat;
import com.PBL4.test.entity.TrainTrip_Carriage;
import com.PBL4.test.enums.CarriageClass;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seat_Response {
    String seatId;
    String seatName;
    boolean situation;
    private String sku;
    String carriageName;
    private String seatType;
}
