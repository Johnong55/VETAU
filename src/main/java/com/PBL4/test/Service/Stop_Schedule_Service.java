package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.StopSchedule_Request;
import com.PBL4.test.DTO.response.Stop_Schedule_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.Schedule;
import com.PBL4.test.entity.StopSchedule;
import com.PBL4.test.mapper.StopScheduleMapper;
import com.PBL4.test.repository.Schedule_Repository;
import com.PBL4.test.repository.Station_Repository;
import com.PBL4.test.repository.StopSchedule_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

@Service
public class Stop_Schedule_Service {
    @Autowired
    Station_Repository station_Repository;
    @Autowired
    Schedule_Repository schedule_Repository;
    @Autowired
    StopSchedule_Repository stopSchedule_Repository;

    private List<StopSchedule> generateStopStation(List<StopSchedule_Request> requests) {
        Schedule schedule = schedule_Repository.findById(requests.get(0).getScheduleId()).orElseThrow(() -> new AppException(ErrorCode.SCHEDULE_NOT_EXISTED));

        Collections.sort(requests);
        List<StopSchedule> stopSchedules = new ArrayList<StopSchedule>();

        for (int i = 0; i < requests.size(); i++) {
            StopSchedule stopSchedule = new StopSchedule().builder()
                    .stopStation(station_Repository.findById(requests.get(i).getStopScheduleId()).orElseThrow(() -> new AppException(ErrorCode.STATION_NOT_EXISTED)))
                    .schedule(schedule)
                    .DepartureStation(i == 0 ? schedule.getDepartureStation() : station_Repository.findById(requests.get(i - 1).getStopScheduleId()).orElseThrow(() -> new AppException(ErrorCode.STATION_NOT_EXISTED)))
                    .ArrivalStation(i == requests.size() - 1 ? schedule.getArrivalStation() : station_Repository.findById(requests.get(i + 1).getStopScheduleId()).orElseThrow(() -> new AppException(ErrorCode.STATION_NOT_EXISTED)))
                    .build();
            stopSchedules.add(stopSchedule);
        }
        return stopSchedules;
    }

    private StopSchedule generateStopStation(StopSchedule_Request request) {
        System.out.println(request.getStopScheduleId());
        List<StopSchedule> stopSchedules = stopSchedule_Repository.findByScheduleId(request.getScheduleId());
        StopSchedule stopSchedule = new StopSchedule().builder()
                .ArrivalTime(request.getTime())
                .stopStation(station_Repository.findById(request.getStopScheduleId()).orElseThrow(() -> new AppException(ErrorCode.STATION_NOT_EXISTED)))

                .build();
        Schedule schedule = schedule_Repository.findByScheduleId(request.getScheduleId()).orElseThrow(() -> new AppException(ErrorCode.STATION_NOT_EXISTED));
        stopSchedule.setSchedule(schedule);
        stopSchedule.setTrain(schedule.getTrain());
        if (stopSchedules.size() == 0) {

            stopSchedule.setSchedule(schedule);
            stopSchedule.setArrivalStation(schedule.getArrivalStation());
            stopSchedule.setDepartureStation(schedule.getDepartureStation());
            stopSchedule.setTrain(schedule.getTrain());
            stopSchedule.setStopStation(station_Repository.findByStationId(request.getStopScheduleId()).orElseThrow(() -> new AppException(ErrorCode.STATION_NOT_EXISTED)));
            return stopSchedule_Repository.save(stopSchedule);
        }
        for (int i = 0; i < stopSchedules.size(); i++) {

            if (stopSchedules.get(i).getArrivalTime() > stopSchedule.getArrivalTime()) {
                System.out.println(stopSchedules.get(i));
                stopSchedule.setArrivalStation(stopSchedules.get(i).getStopStation());
                stopSchedule.setDepartureStation(stopSchedules.get(i).getDepartureStation());
                stopSchedules.get(i).setDepartureStation(stopSchedule.getStopStation());
                System.out.println(stopSchedule);
                if (i > 0) {
                    stopSchedules.get(i - 1).setArrivalStation(stopSchedule.getStopStation());
                    stopSchedule_Repository.save(stopSchedules.get(i - 1));
                }

                stopSchedule_Repository.save(stopSchedules.get(i));
                return stopSchedule_Repository.save(stopSchedule);
            }
        }
        stopSchedule.setArrivalStation(schedule.getArrivalStation());
        stopSchedule.setDepartureStation(stopSchedules.get(stopSchedules.size() - 1).getDepartureStation());
        stopSchedules.get(stopSchedules.size() - 1).setArrivalStation(stopSchedule.getStopStation());
        stopSchedule_Repository.save(stopSchedules.get(stopSchedules.size() - 1));
        return stopSchedule_Repository.save(stopSchedule);

    }

    public Stop_Schedule_Response CreateRequest(StopSchedule_Request stopSchedule_Request) {

        if (!station_Repository.existsByStationId(stopSchedule_Request.getStopScheduleId())) {
            throw new AppException(ErrorCode.STATION_NOT_EXISTED);
        }
        Schedule schedule = schedule_Repository.findByScheduleId(stopSchedule_Request.getScheduleId()).orElseThrow(() -> new AppException(ErrorCode.SCHEDULE_NOT_EXISTED));

        StopSchedule stopSchedule = generateStopStation(stopSchedule_Request);
        Stop_Schedule_Response response = new Stop_Schedule_Response().builder()
                .arrivalStationName(stopSchedule.getArrivalStation().getStationId())
                .departureStationName(stopSchedule.getDepartureStation().getStationId())
                .stopStationName(stopSchedule.getStopStation().getStationId())
                .timeToRun(stopSchedule.getTimeToRun())
                .arrivalTime(stopSchedule.getArrivalTime())
                .scheduleId(stopSchedule.getSchedule().getScheduleId())
                .build();
        return response;

    }


}
