package com.PBL4.test.DTO.response;


import com.PBL4.test.entity.Station;
import com.PBL4.test.entity.TrainTrip;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE )
public class ListTrip_Response {
    LocalDate StartDate;
    Set<TrainTrip_Response> listTrip;
}
