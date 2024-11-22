package com.PBL4.test.repository;

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
public interface Schedule_Repository extends JpaRepository<Schedule, String > {
    Boolean existsByTrainAndArrivalStationAndDepartureStation(Train train, Station arrivalStation, Station departureStation);

    @EntityGraph(attributePaths = "train")
    Optional<Schedule> findByScheduleId(String scheduleId);

    List<Schedule> findByArrivalStation_StationId(String arrivalStationId);
    List<Schedule> findByDepartureStation_StationId(String departureStationId);

    List<Schedule> findByArrivalStation_StationIdAndDepartureStation_StationId(String arrivalStationId, String departureStationId);

    @EntityGraph(attributePaths = "train")
    Optional<Schedule> findByTrain_TrainId(String trainId);

    @Query("SELECT c FROM Schedule c ORDER BY c.scheduleId DESC LIMIT 1")
    Schedule findLastSchedule();
    @Query("SELECT S FROM Schedule S " +
            "JOIN StopSchedule D ON S.scheduleId = D.schedule.scheduleId " +
            "JOIN StopSchedule A ON S.scheduleId = A.schedule.scheduleId " +
            "WHERE D.DepartureStation.city.cityID = :DC " +
            "AND A.ArrivalStation.city.cityID = :AC " +
            "AND S.departureTime> :DT " +
            "ORDER BY S.departureTime ASC")
    Optional<Schedule> findScheduleByArrivalCityAndDepartureCity(
            @Param("DC") String departureStation,
            @Param("AC") String arrivalStation,
            @Param("DT") LocalDateTime departureTime);

    List<StopSchedule> getListStopScheduleByScheduleId(@Param("scheduleId") String scheduleId);
}
