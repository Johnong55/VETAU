package com.PBL4.test.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(
        name = "Seat",
        uniqueConstraints = @UniqueConstraint(
                name = "sku_unique",
                columnNames = "sku"
        )
)
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String SeatID;
    String seatName;
    boolean situation;

    @Column(nullable =  false, unique = true)
    private String sku;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Carriage")
    Carriage carriage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TypeofSeat")
    SeatType typeOfSeat;

}
