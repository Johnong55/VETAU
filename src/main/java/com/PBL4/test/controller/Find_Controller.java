package com.PBL4.test.controller;

import com.PBL4.test.DTO.request.FindSchedule_Request;
import com.PBL4.test.DTO.response.FindSchedule_Response;
import com.PBL4.test.Service.Schedule_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Find_Controller {
    @Autowired
    Schedule_Service schedule_service;

    @PostMapping("/findtrain")
    public List<FindSchedule_Response> findByClientRequest(@RequestBody FindSchedule_Request request) {
        return schedule_service.findScheduleForClient(request.getDepartureCity(),request.getArrivalCity(),request.getDepartureDate());
    }
}
