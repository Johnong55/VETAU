package com.PBL4.test.controller;

import com.PBL4.test.DTO.request.ApiResponse;
import com.PBL4.test.DTO.request.CityRequest;
import com.PBL4.test.DTO.response.CityResponse;
import com.PBL4.test.Service.City_Service;
import com.PBL4.test.entity.City;
import com.PBL4.test.entity.Station;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping("/cities")
public class City_Controller {
    @Autowired
    private City_Service city_service;
    @Autowired
    private City_Service city_Service;

    @PostMapping
    public ApiResponse<CityResponse> CreateCity(@RequestBody CityRequest city) {
        return ApiResponse.<CityResponse>builder()
                .result(city_service.createCity(city))
                .build();
    }
    @GetMapping
    public List<CityResponse> getAllCities() {
        return city_service.findAll();
    }

    @PostMapping("/{CityID}/stations/{StationID}")
    public ApiResponse<City> AddStations(@PathVariable String CityID, @PathVariable String StationID)
    {
        ApiResponse<City> response =  new ApiResponse<>();
        response.setResult(city_service.addAStation(CityID, StationID));
        return response;
    }

    @PutMapping("/{cityID}")
    public CityResponse updateCity(@PathVariable String cityID, @RequestBody CityRequest request) {
        return city_service.updateCity(cityID, request);
    }

    @DeleteMapping("/{cityId}")
    void deleteCity(@PathVariable String cityId) {
        city_Service.deleteCity(cityId);
    }
}
