
package com.PBL4.test.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class SeatType {

    @Id
    String seatTypeId;
    String type;

    @OneToMany(mappedBy = "typeOfSeat", fetch = FetchType.LAZY)
    List<Seat> seats;

}
