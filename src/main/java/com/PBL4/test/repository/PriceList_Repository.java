package com.PBL4.test.repository;

import com.PBL4.test.enums.CarriageClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PBL4.test.entity.PriceList;

import java.util.List;
import java.util.Optional;

@Repository
public interface PriceList_Repository extends JpaRepository<PriceList, String> {

 Boolean existsByDepartureStation_StationIdAndArrivalStation_StationIdAndSchedule_scheduleIdAndCarriageClass(String departureStationID, String arrivalStationID, String scheduleID, CarriageClass carriageClass);
 Optional<PriceList> findByPriceListID(String priceListID);

 List<PriceList> findByDepartureStation_StationIdAndArrivalStation_StationId(String departureStationId, String arrivalStationId);

 List<PriceList> findByDepartureStation_StationId(String departureStationId);
 List<PriceList> findByArrivalStation_StationId(String arrivalStationId);

 List<PriceList> findByCarriageClass(CarriageClass carriageClass);

 @Query("SELECT c FROM PriceList c ORDER BY c.priceListID DESC LIMIT 1")
 PriceList findLastPriceList();

 @Query("SELECT p FROM PriceList p WHERE p.price BETWEEN :minPrice AND :maxPrice")
 List<PriceList> findByPriceBetween(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);

 @Query("SELECT p FROM PriceList p where p.departureStation.stationName = :departureStation and p.arrivalStation.stationName= :arrivalStation and p.schedule.scheduleId = :schedule and p.carriageClass = :carriageClass")
 Optional<PriceList> findPriceByClient(@Param("departureStation") String departureStation, @Param("arrivalStation") String arrivalStation, @Param("schedule") String scheduleID, @Param("carriageClass") CarriageClass carriageClass);
}