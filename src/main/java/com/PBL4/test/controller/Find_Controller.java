package com.PBL4.test.controller;

import com.PBL4.test.DTO.request.FindSchedule_Request;
import com.PBL4.test.DTO.response.Api_Response;
import com.PBL4.test.DTO.response.FindSchedule_Response;
import com.PBL4.test.Service.Schedule_Service;
import com.PBL4.test.Service.Stop_Schedule_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class Find_Controller {
    @Autowired
    Schedule_Service schedule_service;
    @Autowired
    private Stop_Schedule_Service stop_Schedule_Service;
    @Autowired
    private Schedule_Service schedule_Service;

    @PostMapping("/findtrain")
    public List<FindSchedule_Response> findByClientRequest(@RequestBody FindSchedule_Request request) {
        return schedule_service.findScheduleForClient(request.getDepartureCity(),request.getArrivalCity(),request.getDepartureDate());
    }
    @GetMapping("/reserved")
    public Api_Response getReservedSeats(
            @RequestParam String startStation,
            @RequestParam String endStation,
            @RequestParam String scheduleId) {

        try {

            Set<String> reservedSeats = schedule_Service.getReservedSeats(scheduleId,startStation,endStation);



            return new Api_Response(200, "Success", reservedSeats);
        } catch (Exception e) {

            return new Api_Response(500, "Error: " + e.getMessage(), null);
        }
    }
}
