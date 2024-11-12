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
    String seatId;
    String seatName;
    boolean situation;

    @Column(nullable = false, unique = true)
    private String sku;

    @ManyToOne
    @JoinColumn(name = "carriage_id", nullable = false)
    Carriage carriage;

    @Column(name = "seat_type")
    private String seatType;
}
