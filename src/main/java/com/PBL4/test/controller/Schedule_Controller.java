package com.PBL4.test.controller;

import com.PBL4.test.DTO.request.Api_Response;
import com.PBL4.test.DTO.request.Carriage_Request;
import com.PBL4.test.DTO.request.Schedule_Request;
import com.PBL4.test.DTO.request.Seasonal_Rate_Request;
import com.PBL4.test.DTO.response.Carriage_Response;
import com.PBL4.test.DTO.response.Schedule_Response;
import com.PBL4.test.DTO.response.Seasonal_Rate_Response;
import com.PBL4.test.Service.Schedule_Service;
import com.PBL4.test.Service.Seasonal_Rate_Service;
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

    @DeleteMapping("/{scheduleID}")
    Api_Response<String> deleteSchedule(@PathVariable String scheduleID) {
        scheduleService.deleteSchedule(scheduleID);
        return Api_Response.<String>builder()
                .result("Schedule has been deleted")
                .build();
    }
    @PutMapping("/{scheduleID}")
    public Schedule_Response updateSchedule(@PathVariable String scheduleID, @RequestBody Schedule_Request request) {
        return scheduleService.updateSchedule(scheduleID, request);
    }

    @GetMapping("/id/{scheduleID}")
    public Schedule_Response findByID(@PathVariable String scheduleID) {
        return scheduleService.findByID(scheduleID);
    }
    @GetMapping("/arrival-station-id/{arrivalID}")
    public List<Schedule_Response> findByArrivalStationID(@PathVariable String arrivalID) {
        return scheduleService.findByArrivalStation(arrivalID);
    }

    @GetMapping("/departure-station-id/{departureID}")
    public List<Schedule_Response> findByDepartureStationID(@PathVariable String departureID) {
        return scheduleService.findByDepartureStation(departureID);
    }

    @GetMapping("/departure-arrival/{departureID}/{arrivalID}")
    public List<Schedule_Response> findByDeparture_ArrivalStationID(@PathVariable String departureID, @PathVariable String arrivalID) {
        return scheduleService.findByDepartureStation(departureID);
    }
}
