package com.PBL4.test.repository;

import com.PBL4.test.entity.Schedule;
import com.PBL4.test.entity.Station;
import com.PBL4.test.entity.StopSchedule;
import com.PBL4.test.entity.Train;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface StopSchedule_Repository extends JpaRepository<StopSchedule, String> {
    @Query("select s from StopSchedule s where s.schedule.scheduleId= :schedule " +
            "order by s.ArrivalTime")
    List<StopSchedule> findByScheduleId(@Param("schedule") String schedule);

    Optional<StopSchedule> findByID(@Param("id") String id);

    @Query("SELECT s FROM StopSchedule s " +
            "WHERE s.schedule.scheduleId = :schedule " +
            "AND ((s.DepartureStation.stationName = :departureStation AND s.ArrivalStation.stationName = :arrivalStation) " +
            "     OR (s.DepartureStation.stationName = :departureStation) " +
            "     OR (s.ArrivalStation.stationName = :arrivalStation) " +
            "     OR (s.TimeToRun >= " +
            "         (SELECT s2.TimeToRun FROM StopSchedule s2 WHERE s2.stopStation.stationName = :departureStation AND s2.schedule.scheduleId = :schedule) " +
            "         AND s.TimeToRun <= " +
            "         (SELECT s3.TimeToRun FROM StopSchedule s3 WHERE s3.stopStation.stationName = :arrivalStation AND s3.schedule.scheduleId = :schedule))) " +
            "ORDER BY s.TimeToRun")
    List<StopSchedule> findStopScheduleByArrivalAndDeparture(
            @Param("schedule") String scheduleID,
            @Param("departureStation") String departureStation,
            @Param("arrivalStation") String arrivalStation
    );

    @Query("SELECT s FROM StopSchedule s WHERE s.ArrivalStation.stationId = :arrivalStationId")
    List<StopSchedule> findByArrivalStation_StationId(@Param("arrivalStationId") String arrivalStationId);

    @Query("SELECT s FROM StopSchedule s WHERE s.DepartureStation.stationId = :departureStationId")
    List<StopSchedule> findByDepartureStation_StationId(@Param("departureStationId") String departureStationId);

    @Query("SELECT s FROM StopSchedule s WHERE s.ArrivalStation.stationId = :arrivalStationId AND s.DepartureStation.stationId = :departureStationId")
    List<StopSchedule> findByArrivalStation_StationIdAndDepartureStation_StationId(
            @Param("arrivalStationId") String arrivalStationId,
            @Param("departureStationId") String departureStationId
    );

    @Query("SELECT s FROM StopSchedule s " +
            "WHERE s.TimeToRun > :currentTime")
    List<StopSchedule> findByTimeToRunAfter(LocalDateTime currentTime);
}