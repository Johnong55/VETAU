package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.Schedule_Request;
import com.PBL4.test.DTO.request.Seasonal_Rate_Request;
import com.PBL4.test.DTO.request.StopSchedule_Request;
import com.PBL4.test.DTO.response.FindSchedule_Response;
import com.PBL4.test.DTO.response.Schedule_Response;
import com.PBL4.test.DTO.response.Seasonal_Rate_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.*;
import com.PBL4.test.mapper.ScheduleMapper;
import com.PBL4.test.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
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
    @Autowired
    private Carriage_Repository Carriage_Repository;
    @Autowired
    private Carriage_Service carriage_Service;
    @Autowired
    private StopSchedule_Repository stopSchedule_Repository;

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

        result.setDepartureTime(request.getTimeToRun());
        result.setArrivalTime(request.getArrivalTime());
        System.out.println(request.getTimeToRun());
        System.out.println(result.getDepartureTime());

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
    public List<FindSchedule_Response> findScheduleForClient(String departureCity, String arrivalCity, LocalDate date)
    {
        LocalDateTime time = date.atStartOfDay();
        List<FindSchedule_Response> result = scheduleRepository.findSchedulesByClient(departureCity, arrivalCity, time);
        for(int i =0;i<result.size();i++)
        {
            Train train = trainRepository.findByTrainName(result.get(i).getTrainName()).get();
            result.get(i).setCarriages(carriage_Service.findByTrainID(train.getTrainId()));

        }
        return result;
    }
    public Set<String> getReservedSeats(String scheduleId, String startStation, String endStation) {

        List<StopSchedule> stopSchedules = stopSchedule_Repository.findByScheduleId(scheduleId);


        Set<String> reservedSeats = new HashSet<>();

        boolean isBetweenStations = false;

        for (StopSchedule stopSchedule : stopSchedules) {

            if (stopSchedule.getStopStation().getStationName().equals(startStation) || stopSchedule.getSchedule().getDepartureStation().getStationName().equals(startStation)) {
                isBetweenStations = true;
            }


            if (isBetweenStations) {

                List<String> orderedSeat = stopSchedule.getOrderedSeat();


                if (orderedSeat != null) {
                    reservedSeats.addAll(orderedSeat);
                }
            }


            if (stopSchedule.getStopStation().getStationName().equals(endStation)) {
                break;
            }
        }

        return reservedSeats;
    }
}