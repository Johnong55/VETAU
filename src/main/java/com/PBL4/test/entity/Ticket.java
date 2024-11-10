package com.PBL4.test.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
}
