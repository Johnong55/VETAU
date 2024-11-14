package com.PBL4.test.repository;

import com.PBL4.test.entity.Station;
import com.PBL4.test.entity.Train;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.PBL4.test.entity.Schedule;

import java.util.Optional;

@Repository
public interface Schedule_Repository extends JpaRepository<Schedule, String > {
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
}
