package com.PBL4.test.controller;

import com.PBL4.test.DTO.response.Api_Response;
import com.PBL4.test.DTO.request.PriceList_PriceBetween_Request;
import com.PBL4.test.DTO.request.StopSchedule_Request;
import com.PBL4.test.DTO.response.PriceList_Response;
import com.PBL4.test.DTO.response.Stop_Schedule_Response;
import com.PBL4.test.Service.Stop_Schedule_Service;
import com.PBL4.test.enums.CarriageClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stopSchedules")
public class StopSchedule_Controller {
    @Autowired
    private Stop_Schedule_Service stop_schedule_service;
    @PostMapping
    public Api_Response<Stop_Schedule_Response> createStopStation(@RequestBody StopSchedule_Request request)
    {
        return Api_Response.<Stop_Schedule_Response>builder()
                .result(stop_schedule_service.CreateRequest(request))
                .build();
    }
    @GetMapping
    public List<Stop_Schedule_Response> getAll()
    {
        return stop_schedule_service.findAll();
    }

    @DeleteMapping("/{stopScheduleId}")
    Api_Response<String> deletePriceList(@PathVariable String stopScheduleId) {
        stop_schedule_service.deleteStopSchedule(stopScheduleId);
        return Api_Response.<String>builder()
                .result("Stop schedule has been deleted")
                .build();
    }

    @GetMapping("/departure/{departureStationID}")
    public List<Stop_Schedule_Response> findByDepartureStationID(@PathVariable String departureStationID) {
        return stop_schedule_service.findByDepartureStation(departureStationID);
    }

    @GetMapping("/arrival/{arrivalStationID}")
    public List<Stop_Schedule_Response> findByArrivalStationID(@PathVariable String arrivalStationID) {
        return stop_schedule_service.findByArrivalStation(arrivalStationID);
    }

    @GetMapping("/id/{stopScheduleId}")
    public Stop_Schedule_Response findByID(@PathVariable String stopScheduleId) {
        return stop_schedule_service.findByID(stopScheduleId);
    }
}
