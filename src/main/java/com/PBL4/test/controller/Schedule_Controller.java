package com.PBL4.test.controller;

import com.PBL4.test.DTO.response.Api_Response;
import com.PBL4.test.DTO.request.Schedule_Request;
import com.PBL4.test.DTO.response.Schedule_Response;
import com.PBL4.test.Service.Schedule_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping("/schedules")
public class Schedule_Controller {
    @Autowired
    private Schedule_Service scheduleService;

    @PostMapping
    public Api_Response<Schedule_Response> CreateSchedule(@RequestBody Schedule_Request request) {
        return Api_Response.<Schedule_Response>builder()
                .result(scheduleService.createSchedule(request))
                .build();
    }
    @GetMapping
    public List<Schedule_Response> getAllSchedule() {
        return scheduleService.findAll();
    }
//
//    @PutMapping("/{seasonalRateID}")
//    public Seasonal_Rate_Response updateSeasonalRate(@PathVariable String seasonalRateID, @RequestBody Seasonal_Rate_Request request) {
//        return seasonalRateService.updateSeasonalRate(seasonalRateID, request);
//    }
//
    @DeleteMapping("/{scheduleID}")
    Api_Response<String> deleteSchedule(@PathVariable String scheduleID) {
        scheduleService.deteteSchedule(scheduleID);
        return Api_Response.<String>builder()
                .result("Schedule has been deleted")
                .build();
    }
//
//    @GetMapping("/name/{seasonalRateName}")
//    public Seasonal_Rate_Response findByName(@PathVariable String seasonalRateName) {
//        return seasonalRateService.findByName(seasonalRateName);
//    }
//
    @GetMapping("/id/{scheduleID}")
    public Schedule_Response findByID(@PathVariable String seasonalRateID) {
        return scheduleService.findByID(seasonalRateID);
    }
    @GetMapping("/arrival-station-id/{arrivalID}")
    public Schedule_Response findByArrivalStationID(@PathVariable String arrivalID) {
        return scheduleService.findByArrivalStation(arrivalID);
    }

    @GetMapping("/departure-station-id/{departureID}")
    public Schedule_Response findByDepartureStationID(@PathVariable String departureID) {
        return scheduleService.findByDepartureStation(departureID);
    }

    @GetMapping("/departure-arrival/{departureID}")
    public Schedule_Response findByDeparture_ArrivalStationID(@PathVariable String departureID) {
        return scheduleService.findByDepartureStation(departureID);
    }
}
