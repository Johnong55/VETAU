package com.PBL4.test.controller;

import com.PBL4.test.DTO.request.ApiResponse;
import com.PBL4.test.Service.Station_Service;
import com.PBL4.test.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Stations")
public class Station_Controller {
    @Autowired
    private Station_Service station_service;
    @PostMapping
    public ApiResponse<Station> CreateRequest(@RequestBody Station station) {
        ApiResponse<Station> apiResponse = new ApiResponse<>();
        apiResponse.setResult(station_service.CreateRequest(station));
        return apiResponse;

    }
}
