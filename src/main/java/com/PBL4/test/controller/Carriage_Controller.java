package com.PBL4.test.controller;

import com.PBL4.test.DTO.response.Api_Response;
import com.PBL4.test.DTO.request.Carriage_Request;
import com.PBL4.test.DTO.response.Carriage_Response;
import com.PBL4.test.Service.Carriage_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carriages")
public class Carriage_Controller {
    @Autowired
    private Carriage_Service carriage_service;

    @PostMapping
    public Api_Response<Carriage_Response> CreateCarriage(@RequestBody Carriage_Request request) {
        return Api_Response.<Carriage_Response>builder()
                .result(carriage_service.createCarriage(request))
                .build();
    }
    @GetMapping
    public List<Carriage_Response> getAllCarriages() {
        return carriage_service.findAll();
    }

    @PutMapping("/{carriageID}")
    public Carriage_Response updateCity(@PathVariable String carriageID, @RequestBody Carriage_Request request) {
        return carriage_service.updateCarriage(carriageID, request);
    }

    @DeleteMapping("/{carriageID}")
    Api_Response<String> deleteCarriage(@PathVariable String carriageID) {
        carriage_service.deleteCarriage(carriageID);
        return Api_Response.<String>builder()
                .result("Carriage has been deleted")
                .build();
    }

    @GetMapping("/name/{carriageName}")
    public Carriage_Response findByName(@PathVariable String carriageName) {
        return carriage_service.findByName(carriageName);
    }

    @GetMapping("/id/{carriageID}")
    public Carriage_Response findByID(@PathVariable String carriageID) {
        return carriage_service.findByID(carriageID);
    }

    @GetMapping("/trainID/{trainID}")
    public List<Carriage_Response> findByTrainID(@PathVariable String trainID) {
        return carriage_service.findByTrainID(trainID);
    }
}
