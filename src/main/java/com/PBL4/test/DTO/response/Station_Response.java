package com.PBL4.test.DTO.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Station_Response {
    String IdStation;
    String StationName;
    String IdCity;
    String AddressStation;
}
