package com.PBL4.test.DTO.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Service_Fee_Response {
    String serviceFeeId;
    String serviceName;
    double feeAmount;
}
