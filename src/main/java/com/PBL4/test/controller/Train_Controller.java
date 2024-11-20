package com.PBL4.test.controller;


import com.PBL4.test.DTO.request.Api_Response;
import com.PBL4.test.DTO.request.City_Request;
import com.PBL4.test.DTO.request.Train_Request;
import com.PBL4.test.DTO.response.City_Response;
import com.PBL4.test.DTO.response.Train_Response;
import com.PBL4.test.Service.Train_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class Train_Controller {
    @Autowired
    private Train_Service train_service;

//    public ApiResponse<Train> createTrain( @RequestBody Train_Request trainRequest)
//    {
//        ApiResponse<Train> apiResponse = new ApiResponse<>();
//        apiResponse.setResult(train_service.CreateRequest(trainRequest));
//        return apiResponse;
//    }

    @PostMapping
    public Api_Response<Train_Response> createTrain(@RequestBody Train_Request request) {
        System.out.println(request.getTrainName());
        return Api_Response.<Train_Response>builder()
                .result(train_service.createTrain(request))
                .build();
    }

    @GetMapping
    public List<Train_Response> getAll(){
        return train_service.getAll();
    }

    @GetMapping("/getAllName")
    public List<String> getAllName() {
        return train_service.getAllName();
    }
    @PutMapping("/{trainId}")
    public Train_Response updateTrain(@PathVariable String trainId, @RequestBody Train_Request request) {
        return train_service.updateTrain(trainId, request);
    }

    @DeleteMapping("/{trainId}")
    Api_Response<String> deleteTrain(@PathVariable String trainId) {
        train_service.deleteTrain(trainId);
        return Api_Response.<String>builder()
                .result("Station has been deleted")
                .build();
    }

    @GetMapping("/name/{trainName}")
    public Train_Response findByName(@PathVariable String trainName) {
        return train_service.findByName(trainName);
    }
    @GetMapping("/id/{trainId}")
    public Train_Response findByID(@PathVariable String trainId) {
        return train_service.findByID(trainId);
    }
}

