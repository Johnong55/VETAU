package com.PBL4.test.repository;

import com.PBL4.test.entity.City;
import com.PBL4.test.entity.Seat;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Seat_Repository extends JpaRepository<Seat,String> {
    Boolean existsBySeatId(String seatId);
    boolean existsBySeatName(String stationName);
    Optional<Seat> findBySeatId(String seatId);

    Optional<Seat> findBySku(String sku);



    @Query("SELECT c FROM Seat c ORDER BY c.seatId DESC LIMIT 1")
    Seat findLastSeat();

    List<Seat> findByCarriage_CarriageId(String carriageId);
    void deleteByCarriage_CarriageId(String carriageID);
}
