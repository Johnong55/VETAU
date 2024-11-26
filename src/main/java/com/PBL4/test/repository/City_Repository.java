package com.PBL4.test.repository;

import com.PBL4.test.entity.City;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface City_Repository extends JpaRepository<City,String> {
    Boolean existsByCityName(String cityName);

    @EntityGraph(attributePaths = "stations")
    Optional<City> findByCityName(String cityName);

    @EntityGraph(attributePaths = "stations")
    Optional<City> findByCityID(String cityName);

    @Query("SELECT c FROM City c ORDER BY c.cityID DESC LIMIT 1")
    City findLastCity();
}
