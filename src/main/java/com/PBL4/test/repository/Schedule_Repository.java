package com.PBL4.test.repository;

import com.PBL4.test.DTO.response.FindSchedule_Response;
import com.PBL4.test.entity.Station;
import com.PBL4.test.entity.StopSchedule;
import com.PBL4.test.entity.Train;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import com.PBL4.test.entity.Schedule;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface Schedule_Repository extends JpaRepository<Schedule, String> {
    Boolean existsByTrainAndArrivalStationAndDepartureStation(Train train, Station arrivalStation, Station departureStation);

    @EntityGraph(attributePaths = "train")
    Optional<Schedule> findByScheduleId(String scheduleId);

    Optional<Schedule> findByArrivalStation_StationId(String arrivalStationId);

    Optional<Schedule> findByDepartureStation_StationId(String departureStationId);

    Optional<Schedule> findByArrivalStation_StationIdAndDepartureStation_StationId(String arrivalStationId, String departureStationId);

    @EntityGraph(attributePaths = "train")
    Optional<Schedule> findByTrain_TrainId(String trainId);

    @Query("SELECT c FROM Schedule c ORDER BY c.scheduleId DESC LIMIT 1")
    Schedule findLastSchedule();
    @Query("SELECT new com.PBL4.test.DTO.response.FindSchedule_Response(" +
            "s.scheduleId, " +
            "(CASE " +
            "   WHEN s.departureStation.city.cityName = :departureCity THEN s.departureStation.stationName " +
            "   ELSE (SELECT ss1.stopStation.stationName FROM StopSchedule ss1 WHERE ss1.schedule = s AND ss1.stopStation.city.cityName = :departureCity AND ss1.TimeToRun = (" +
            "       SELECT MIN(ss_inner.TimeToRun) FROM StopSchedule ss_inner WHERE ss_inner.schedule = s AND ss_inner.stopStation.city.cityName = :departureCity" +
            "   ))" +
            "END), " +
            "(CASE " +
            "   WHEN s.arrivalStation.city.cityName = :arrivalCity THEN s.arrivalStation.stationName " +
            "   ELSE (SELECT ss2.stopStation.stationName FROM StopSchedule ss2 WHERE ss2.schedule = s AND ss2.stopStation.city.cityName = :arrivalCity AND ss2.TimeToRun = (" +
            "       SELECT MAX(ss_inner.TimeToRun) FROM StopSchedule ss_inner WHERE ss_inner.schedule = s AND ss_inner.stopStation.city.cityName = :arrivalCity" +
            "   ))" +
            "END), " +
            "CASE " +
            "   WHEN s.departureStation.city.cityName = :departureCity THEN s.departureTime " +
            "   ELSE (SELECT MIN(ss1.TimeToRun) FROM StopSchedule ss1 WHERE ss1.schedule = s AND ss1.stopStation.city.cityName = :departureCity) " +
            "END, " +
            "CASE " +
            "   WHEN s.arrivalStation.city.cityName = :arrivalCity THEN s.arrivalTime " +
            "   ELSE (SELECT MAX(ss2.TimeToRun) FROM StopSchedule ss2 WHERE ss2.schedule = s AND ss2.stopStation.city.cityName = :arrivalCity) " +
            "END, " +
            "s.train.trainName" +
            ") " +
            "FROM Schedule s " +
            "WHERE (" +
            "   (s.departureStation.city.cityName = :departureCity OR EXISTS (" +
            "       SELECT 1 FROM StopSchedule ss1 " +
            "       WHERE ss1.schedule = s " +
            "       AND ss1.stopStation.city.cityName = :departureCity" +
            "   ))" +
            "   AND " +
            "   (s.arrivalStation.city.cityName = :arrivalCity OR EXISTS (" +
            "       SELECT 1 FROM StopSchedule ss2 " +
            "       WHERE ss2.schedule = s " +
            "       AND ss2.stopStation.city.cityName = :arrivalCity " +
            "   ))" +
            ") " +
            "AND (" +
            "   (s.departureStation.city.cityName = :departureCity AND s.arrivalStation.city.cityName = :arrivalCity AND s.departureTime < s.arrivalTime) " +
            "   OR " +
            "   (s.departureStation.city.cityName = :departureCity AND EXISTS (" +
            "       SELECT 1 FROM StopSchedule ss3 " +
            "       WHERE ss3.schedule = s " +
            "       AND ss3.stopStation.city.cityName = :arrivalCity " +
            "       AND s.departureTime < ss3.TimeToRun" +
            "   )) " +
            "   OR " +
            "   (s.arrivalStation.city.cityName = :arrivalCity AND EXISTS (" +
            "       SELECT 1 FROM StopSchedule ss4 " +
            "       WHERE ss4.schedule = s " +
            "       AND ss4.stopStation.city.cityName = :departureCity " +
            "       AND ss4.TimeToRun < s.arrivalTime" +
            "   )) " +
            "   OR " +
            "   EXISTS (" +
            "       SELECT 1 FROM StopSchedule ss5 " +
            "       JOIN StopSchedule ss6 ON ss5.schedule = ss6.schedule " +
            "       WHERE ss5.schedule = s " +
            "       AND ss5.stopStation.city.cityName = :departureCity " +
            "       AND ss6.stopStation.city.cityName = :arrivalCity " +
            "       AND ss5.TimeToRun < ss6.TimeToRun" +
            "   )" +
            ") " +
            "AND s.departureTime > :departureTime " +
            "GROUP BY s.scheduleId, s.departureTime, s.arrivalTime, s.departureStation.city.cityName, s.arrivalStation.city.cityName, s.train.trainName, " +
            "s.departureStation.stationName, s.arrivalStation.stationName " +
            "ORDER BY CASE " +
            "   WHEN s.departureStation.city.cityName = :departureCity THEN s.departureTime " +
            "   ELSE (SELECT MIN(ss7.TimeToRun) FROM StopSchedule ss7 WHERE ss7.schedule = s AND ss7.stopStation.city.cityName = :departureCity) " +
            "END ASC")
    List<FindSchedule_Response> findSchedulesByClient(
            @Param("departureCity") String departureCity,
            @Param("arrivalCity") String arrivalCity,
            @Param("departureTime") LocalDateTime departureTime
    );

    List<StopSchedule> getListStopScheduleByScheduleId(@Param("scheduleId") String scheduleId);
}
