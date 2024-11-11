package com.PBL4.test.repository;

import com.PBL4.test.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface Station_Repository extends JpaRepository<Station, String> {

    @Query("select a from Station  a where a.StationName = :station_name")
    public Optional<Station> findByStation_name(@Param("station_name") String station_name);
}
