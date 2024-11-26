package com.PBL4.test.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ServiceFee {
    @Id
    String serviceFeeId;

    String serviceName;
    double feeAmount;

}
