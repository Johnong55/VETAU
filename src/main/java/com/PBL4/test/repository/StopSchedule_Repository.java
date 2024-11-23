package com.PBL4.test.repository;

import com.PBL4.test.entity.StopSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopSchedule_Repository extends JpaRepository<StopSchedule, String> {
        @Query("select s from StopSchedule s where s.schedule.scheduleId= :schedule " +
                "order by s.ArrivalTime")
        List<StopSchedule> findByScheduleId(@Param("schedule") String schedule);
        //@Query("select s from StopSchedule s1")
        //List<StopSchedule> findStopScheduleBetweenDepartureAndArrivalStation()
}
