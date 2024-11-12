package com.PBL4.test.DTO.request;


import com.PBL4.test.enums.CarriageClass;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seat_UpdateRequest {
    @NotNull
    boolean situation;
}
