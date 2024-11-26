package com.PBL4.test.controller;

import com.PBL4.test.DTO.response.Api_Response;
import com.PBL4.test.DTO.request.StopSchedule_Request;
import com.PBL4.test.DTO.response.Stop_Schedule_Response;
import com.PBL4.test.Service.Stop_Schedule_Service;
import org.springframework.beans.factory.annotation.Autowired;
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

}
