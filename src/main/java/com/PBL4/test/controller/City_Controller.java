package com.PBL4.test.controller;

import com.PBL4.test.DTO.request.ApiResponse;
import com.PBL4.test.DTO.request.City_Request;
import com.PBL4.test.Service.City_Service;
import com.PBL4.test.entity.City;
import com.PBL4.test.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cities")
public class City_Controller {

    @Autowired
    private City_Service city_service;
    @PostMapping
    public ApiResponse<City> CreateCity(@RequestBody City_Request city) {
        ApiResponse<City> response =  new ApiResponse<>();
        response.setResult(city_service.CreateRequest(city));
        return  response;
    }
    @GetMapping
    public List<City> getAllCities() {
        return city_service.findAll();
    }
    @PostMapping("/{CityID}/stations/{StationID}")
    public ApiResponse<City> AddStations(@PathVariable String CityID, @PathVariable String StationID)
    {
        ApiResponse<City> response =  new ApiResponse<>();
        response.setResult(city_service.addAStation(CityID, StationID));
        return response;
    }
}
