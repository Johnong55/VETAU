package com.PBL4.test.DTO.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Service_Fee_Request {
    String serviceName;
    double feeAmount;
}
