package com.PBL4.test.repository;

import com.PBL4.test.entity.City;
import com.PBL4.test.entity.SeasonalRate;
import com.PBL4.test.entity.ServiceFee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Season_Rate_Repository extends JpaRepository<SeasonalRate,String> {
    Boolean existsBySeasonName(String seasonName);

    @EntityGraph(attributePaths = "priceList")
    Optional<SeasonalRate> findBySeasonalRateId(String seasonalRateId);

    @EntityGraph(attributePaths = "priceList")
    Optional<SeasonalRate> findBySeasonName(String seasonName);

    @Query("SELECT c FROM SeasonalRate c ORDER BY c.seasonalRateId DESC LIMIT 1")
    SeasonalRate findLastSeasonalRate();
}