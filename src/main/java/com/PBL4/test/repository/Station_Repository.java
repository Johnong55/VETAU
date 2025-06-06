package com.PBL4.test.repository;

import com.PBL4.test.entity.Station;
import com.PBL4.test.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface Station_Repository extends JpaRepository<Station, String> {
    Optional<Station> findByStationName(String stationName);
    Optional<Station> findByStationId(String stationId);
    boolean existsByStationName(String stationName);
    boolean existsByStationId(String stationId);

    @Query("SELECT c FROM Station c where c.city.cityID= :city ORDER BY c.stationId DESC LIMIT 1")
    Station findLastStation(@Param("city") String city);
}
