package com.PBL4.test.DTO.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class City_Response {
    String cityID;
    String cityName;
    List<Station_Response> stations;
}
