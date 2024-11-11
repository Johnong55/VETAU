package com.PBL4.test.Controller;

import com.PBL4.test.DTO.response.ApiResponse;
import com.PBL4.test.DTO.request.Station_Request;
import com.PBL4.test.Service.Station_Service;
import com.PBL4.test.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Stations")
public class Station_Controller {
    @Autowired
    private Station_Service station_service;
    @PostMapping
    public ApiResponse<Station> CreateRequest(@RequestBody Station_Request station) {
        ApiResponse<Station> apiResponse = new ApiResponse<>();
        apiResponse.setResult(station_service.CreateRequest(station));
        return apiResponse;

    }
    @GetMapping
    public List<Station> getAllStation() {
        return station_service.GetAllStation();
    }
}
