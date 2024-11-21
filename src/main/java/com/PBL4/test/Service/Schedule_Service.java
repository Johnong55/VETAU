package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.Schedule_Request;
import com.PBL4.test.DTO.request.Seasonal_Rate_Request;
import com.PBL4.test.DTO.request.StopSchedule_Request;
import com.PBL4.test.DTO.response.Schedule_Response;
import com.PBL4.test.DTO.response.Seasonal_Rate_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.*;
import com.PBL4.test.mapper.ScheduleMapper;
import com.PBL4.test.repository.Schedule_Repository;
import com.PBL4.test.repository.Station_Repository;
import com.PBL4.test.repository.Train_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Schedule_Service {
    @Autowired
    Schedule_Repository scheduleRepository;
    @Autowired
    ScheduleMapper scheduleMapper;
    @Autowired
    Station_Repository stationRepository;
    @Autowired
    Train_Repository trainRepository;
    @Autowired
    private Schedule_Repository schedule_Repository;
    @Autowired
    private Station_Repository station_Repository;

    private String generateScheduleID() {
        Schedule lastSchedule = scheduleRepository.findLastSchedule();
        if (lastSchedule == null) {
            return "SCD000001";
        }
        String lastID = lastSchedule.getScheduleId();
        int lastNumber = Integer.parseInt(lastID.substring(3));
        int newNumber = lastNumber + 1;
        return String.format("SCD%06d", newNumber);
    }
    public Schedule_Response createSchedule(Schedule_Request request) {
        Train train = trainRepository.findByTrainId(request.getTrainId())
                .orElseThrow(()->new AppException(ErrorCode.TRAIN_NOT_EXISTED));
        Station arrivalStation = stationRepository.findByStationId(request.getArrivalStationId())
                .orElseThrow(()->new AppException(ErrorCode.STATION_NOT_EXISTED));
        Station departureStation = stationRepository.findByStationId(request.getDepartureStationId())
                .orElseThrow(()->new AppException(ErrorCode.STATION_NOT_EXISTED));

        if (scheduleRepository.existsByTrainAndArrivalStationAndDepartureStation(train, arrivalStation, departureStation)) {
            throw new AppException(ErrorCode.SCHEDULE_EXISTED);
        }
        Schedule result = scheduleMapper.toSchedule(request);
        result.setScheduleId(generateScheduleID());

        return scheduleMapper.toScheduleResponse(scheduleRepository.save(result));
    }


    public List<Schedule_Response> findAll() {
        return scheduleRepository.findAll().stream()
                .map(scheduleMapper::toScheduleResponse)
                .collect(Collectors.toList());
    }

    public Schedule_Response findByArrivalStation(String arrivalStationId) {
        Schedule schedule = scheduleRepository.findByArrivalStation_StationId(arrivalStationId)
                .orElseThrow(() -> new AppException(ErrorCode.SCHEDULE_NOT_EXISTED));
        return scheduleMapper.toScheduleResponse(schedule);
    }

    public Schedule_Response findByDepartureStation(String departureStationId) {
        Schedule schedule = scheduleRepository.findByDepartureStation_StationId(departureStationId)
                .orElseThrow(() -> new AppException(ErrorCode.SCHEDULE_NOT_EXISTED));
        return scheduleMapper.toScheduleResponse(schedule);
    }
    public Schedule_Response findByArrivalStationAndDepartureStatio(String arrivalStationId, String departureStatioId) {
        Schedule schedule = scheduleRepository.findByArrivalStation_StationIdAndDepartureStation_StationId(arrivalStationId, departureStatioId)
                .orElseThrow(() -> new AppException(ErrorCode.SCHEDULE_NOT_EXISTED));
        return scheduleMapper.toScheduleResponse(schedule);
    }


    public Schedule_Response findByID(String scheduleID) {
        Schedule schedule = scheduleRepository.findByScheduleId(scheduleID)
                .orElseThrow(() -> new AppException(ErrorCode.SCHEDULE_NOT_EXISTED));
        return scheduleMapper.toScheduleResponse(schedule);
    }


//
//    public Seasonal_Rate_Response updateSeasonalRate(String seasonalRateID, Seasonal_Rate_Request request) {
//        SeasonalRate seasonalRate = seasonRateRepository.findBySeasonalRateId(seasonalRateID)
//                .orElseThrow(() -> new AppException(ErrorCode.SEASONAL_RATE_NOT_EXISTED));
//        seasonalRateMapper.updateSeasonalRate(seasonalRate, request);
//        return seasonalRateMapper.toSeasonalRateResponse(seasonRateRepository.save(seasonalRate));
//    }
    public void deteteSchedule(String scheduleID) {
        scheduleRepository.deleteById(scheduleID);
    }

}
