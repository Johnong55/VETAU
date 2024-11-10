package com.PBL4.test.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Account")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    String username;

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;

    String firstName;
    String lastName;
    LocalDate dob;
    String address;
    String phoneNumber;

    @Column(nullable = false, unique = true)
    String cid; // citizen identification card

    @OneToMany(mappedBy = "account", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Ticket> tickets;

}