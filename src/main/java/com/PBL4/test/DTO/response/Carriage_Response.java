package com.PBL4.test.DTO.response;

import com.PBL4.test.entity.Seat;
import com.PBL4.test.enums.CarriageClass;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Carriage_Response {
    String carriageId;
    String carriageName;
    int seatCount;
    String seatType;
    String trainID;
}
