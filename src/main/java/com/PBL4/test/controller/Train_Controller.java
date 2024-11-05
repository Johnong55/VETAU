package com.PBL4.test.controller;


import com.PBL4.test.DTO.request.ApiResponse;
import com.PBL4.test.DTO.request.Train_Request;
import com.PBL4.test.Service.Train_Service;
import com.PBL4.test.entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Trains")
public class Train_Controller {
    @Autowired
    private Train_Service train_service;

    public ApiResponse<Train> createTrain( @RequestBody Train_Request trainRequest)
    {
        ApiResponse<Train> apiResponse = new ApiResponse<>();
        apiResponse.setResult(train_service.CreateRequest(trainRequest));
        return apiResponse;
    }
}

