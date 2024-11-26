package com.PBL4.test.controller;

import com.PBL4.test.DTO.response.Api_Response;
import com.PBL4.test.DTO.request.Seasonal_Rate_Request;
import com.PBL4.test.DTO.response.Seasonal_Rate_Response;
import com.PBL4.test.Service.Seasonal_Rate_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping("/seasonal-rate")
public class Seasonal_Rate_Controller {
    @Autowired
    private Seasonal_Rate_Service seasonalRateService;

    @PostMapping
    public Api_Response<Seasonal_Rate_Response> CreateSeasonalRate(@RequestBody Seasonal_Rate_Request seasonalRateRequest) {
        return Api_Response.<Seasonal_Rate_Response>builder()
                .result(seasonalRateService.createSeasonalRate(seasonalRateRequest))
                .build();
    }
    @GetMapping
    public List<Seasonal_Rate_Response> getAllSeasonalRate() {
        return seasonalRateService.findAll();
    }

    @PutMapping("/{seasonalRateID}")
    public Seasonal_Rate_Response updateSeasonalRate(@PathVariable String seasonalRateID, @RequestBody Seasonal_Rate_Request request) {
        return seasonalRateService.updateSeasonalRate(seasonalRateID, request);
    }

    @DeleteMapping("/{seasonalRateID}")
    Api_Response<String> deleteSeasonalRate(@PathVariable String seasonalRateID) {
        seasonalRateService.deteteSeasonalRate(seasonalRateID);
        return Api_Response.<String>builder()
                .result("Seasonal Rate has been deleted")
                .build();
    }

    @GetMapping("/name/{seasonalRateName}")
    public Seasonal_Rate_Response findByName(@PathVariable String seasonalRateName) {
        return seasonalRateService.findByName(seasonalRateName);
    }

    @GetMapping("/id/{seasonalRateID}")
    public Seasonal_Rate_Response findByID(@PathVariable String seasonalRateID) {
        return seasonalRateService.findByID(seasonalRateID);
    }

}
