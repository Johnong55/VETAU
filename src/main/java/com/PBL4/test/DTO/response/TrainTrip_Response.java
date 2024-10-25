package com.PBL4.test.DTO.response;


import com.PBL4.test.entity.Train;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrainTrip_Response {
    String IdTrain;
    String NameTrain;
    LocalDate StartDate;
    LocalDate EndDate;
    Station_Response DepartureStation;
    Station_Response ArrivalStation;
    Set<Carriage_Response> listCarriage;
}
