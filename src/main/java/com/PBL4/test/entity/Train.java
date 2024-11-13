package com.PBL4.test.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Train {
    @Id
    String trainId;
    String trainName;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<Carriage> carriages;
}
