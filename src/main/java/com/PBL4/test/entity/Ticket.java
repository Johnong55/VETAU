package com.PBL4.test.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.engine.internal.Cascade;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(
        name = "Ticket",
        uniqueConstraints = @UniqueConstraint(
                name = "sku_unique",
                columnNames = "sku_TK"
        )
)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String ticketId;
    String purchaseMethod;
    LocalDateTime purchaseDate;
    String status;

    @Column(nullable = false, unique = true)
    String sku_TK;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "schedule")
    private Schedule schedule;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PriceList")
    private PriceList priceList;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Account")
    Account account;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Seat")
    Seat seat;

    long total;

    LocalDateTime departureTime;
    LocalDateTime arrivalTime;


}
