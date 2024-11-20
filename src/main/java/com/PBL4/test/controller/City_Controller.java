package com.PBL4.test.controller;

import com.PBL4.test.DTO.request.Api_Response;
import com.PBL4.test.DTO.request.City_Request;
import com.PBL4.test.DTO.response.City_Response;
import com.PBL4.test.Service.City_Service;
import com.PBL4.test.entity.City;
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

    @PostMapping
    public Api_Response<City_Response> CreateCity(@RequestBody City_Request city) {
        return Api_Response.<City_Response>builder()
                .result(city_service.createCity(city))
                .build();
    }
    @GetMapping
    public List<City_Response> getAllCities() {
        return city_service.findAll();
    }

    @GetMapping("/getNames")
    public List<String> gettAllNameCities() {
        return city_service.findAllName();
    }

    @PutMapping("/{cityID}")
    public City_Response updateCity(@PathVariable String cityID, @RequestBody City_Request request) {
        return city_service.updateCity(cityID, request);
    }

    @DeleteMapping("/{cityId}")
    Api_Response<String> deleteCity(@PathVariable String cityId) {
        city_service.deleteCity(cityId);
        return Api_Response.<String>builder()
                .result("Station has been deleted")
                .build();
    }

    @GetMapping("/name/{cityName}")
    public City_Response findByName(@PathVariable String cityName) {
        return city_service.findByName(cityName);
    }

    @GetMapping("/id/{cityId}")
    public City_Response findByID(@PathVariable String cityId) {
        return city_service.findByID(cityId);
    }

}
