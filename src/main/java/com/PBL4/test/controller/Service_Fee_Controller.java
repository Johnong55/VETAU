package com.PBL4.test.controller;

import com.PBL4.test.DTO.request.Api_Response;
import com.PBL4.test.DTO.request.Service_Fee_Request;
import com.PBL4.test.DTO.response.Service_Fee_Response;
import com.PBL4.test.Service.Service_Fee_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-fee")
public class Service_Fee_Controller {
    @Autowired
    private Service_Fee_Service serviceFeeService;

    @PostMapping
    public Api_Response<Service_Fee_Response> CreateServiceFee(@RequestBody Service_Fee_Request serviceFeeRequest) {
        return Api_Response.<Service_Fee_Response>builder()
                .result(serviceFeeService.createServiceFee(serviceFeeRequest))
                .build();
    }
    @GetMapping
    public List<Service_Fee_Response> getAllServiceFees() {
        return serviceFeeService.findAll();
    }

    @PutMapping("/{serviceFeeID}")
    public Service_Fee_Response updateServiceFee(@PathVariable String serviceFeeID, @RequestBody Service_Fee_Request request) {
        return serviceFeeService.updateServiceFee(serviceFeeID, request);
    }

    @DeleteMapping("/{serviceFeeID}")
    Api_Response<String> deleteServiceFee(@PathVariable String serviceFeeID) {
        serviceFeeService.deleteServiceFee(serviceFeeID);
        return Api_Response.<String>builder()
                .result("Service Fee has been deleted")
                .build();
    }

    @GetMapping("/name/{serviceFeeName}")
    public Service_Fee_Response findByName(@PathVariable String serviceFeeName) {
        return serviceFeeService.findByName(serviceFeeName);
    }

    @GetMapping("/id/{serviceFeeID}")
    public Service_Fee_Response findByID(@PathVariable String serviceFeeID) {
        return serviceFeeService.findByID(serviceFeeID);
    }

}
