package com.PBL4.test.DTO.response;

import com.PBL4.test.entity.City;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Station_Response {
    String stationId;
    String stationName;
    String address;
    String cityName;
}
