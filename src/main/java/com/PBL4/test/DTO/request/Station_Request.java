package com.PBL4.test.DTO.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Station_Request {
    String stationName;
    String address;
    String cityID;
}
