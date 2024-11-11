package com.PBL4.test.controller;

import com.PBL4.test.DTO.request.Api_Response;
import com.PBL4.test.DTO.request.Station_Request;
import com.PBL4.test.DTO.request.Train_Request;
import com.PBL4.test.DTO.response.Station_Response;
import com.PBL4.test.DTO.response.Train_Response;
import com.PBL4.test.Service.Station_Service;
import com.PBL4.test.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")
public class Station_Controller {
    @Autowired
    private Station_Service station_service;

    @PostMapping
    public Api_Response<Station_Response> createStation(@RequestBody Station_Request request) {
        return Api_Response.<Station_Response>builder()
                .result(station_service.createStation(request))
                .build();
    }

    @GetMapping
    public List<Station_Response> getAll() {
        return station_service.getAll();
    }

    @PutMapping("/{stationID}")
    public Station_Response updateStation(@PathVariable String stationID, @RequestBody Station_Request request) {
        return station_service.updateStation(stationID, request);
    }

    @DeleteMapping("/{stationID}")
    Api_Response<String> deleteStation(@PathVariable String stationID) {
        station_service.deleteStation(stationID);
        return Api_Response.<String>builder()
                .result("Station has been deleted")
                .build();
    }

    @GetMapping("/name/{stationName}")
    public Station_Response findByName(@PathVariable String stationName) {
        return station_service.findByName(stationName);
    }

    @GetMapping("/id/{stationID}")
    public Station_Response findByID(@PathVariable String stationID) {
        return station_service.findByID(stationID);
    }
}
