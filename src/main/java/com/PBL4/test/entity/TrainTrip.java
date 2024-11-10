package com.PBL4.test.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class TrainTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String TrainTripId;
    LocalDate ngaydi;
    LocalDate ngayden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id", nullable = false)
    Train train;

    @OneToMany(mappedBy = "trainTrip")
    List<TrainTrip_Carriage> trainTripCarriages;

    @Override
    public String toString() {
        return "ChuyenTau [id=" + TrainTripId + ", tau=" + train + ", ngaydi=" + ngaydi + ", ngayde=" + ngayden + "]";
    }
}
