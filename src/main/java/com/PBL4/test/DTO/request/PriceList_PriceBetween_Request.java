package com.PBL4.test.DTO.request;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceList_PriceBetween_Request {
    @NotNull
    double minPrice;
    @NotNull
    double maxPrice;
}