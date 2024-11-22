package com.PBL4.test.controller;

import com.PBL4.test.DTO.request.Api_Response;
import com.PBL4.test.DTO.request.PriceList_PriceBetween_Request;
import com.PBL4.test.DTO.request.PriceList_Request;
import com.PBL4.test.DTO.response.PriceList_Response;
import com.PBL4.test.Service.PriceList_Service;
import com.PBL4.test.enums.CarriageClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/price-lists")
public class PriceList_Controller {
    @Autowired
    private PriceList_Service priceListService;

    @PostMapping
    public Api_Response<PriceList_Response> createPriceList(@RequestBody PriceList_Request request) {
        return Api_Response.<PriceList_Response>builder()
                .result(priceListService.createPriceList(request))
                .build();
    }
    @GetMapping
    public List<PriceList_Response> getAllPriceLists() {
        return priceListService.findAll();
    }

//    @PutMapping("/{priceID}")
//    public PriceList_Response updateCity(@PathVariable String carriageID, @RequestBody Carriage_Request request) {
//        return carriage_service.updateCarriage(carriageID, request);
//    }

    @DeleteMapping("/{priceListID}")
    Api_Response<String> deletePriceList(@PathVariable String priceListID) {
        priceListService.deletePriceList(priceListID);
        return Api_Response.<String>builder()
                .result("PriceList has been deleted")
                .build();
    }

    @GetMapping("/departure/{departureStationID}")
    public List<PriceList_Response> findByDepartureStationID(@PathVariable String departureStationID) {
        return priceListService.findByDepartureStationID(departureStationID);
    }
    @GetMapping("/arrival/{arrivalStationID}")
    public List<PriceList_Response> findByArrivalStationID(@PathVariable String arrivalStationID) {
        return priceListService.findByArrivalStationID(arrivalStationID);
    }

    @GetMapping("/id/{priceListID}")
    public PriceList_Response findByID(@PathVariable String priceListID) {
        return priceListService.findByID(priceListID);
    }
    @GetMapping("/class/{carriageClass}")
    public List<PriceList_Response> findByID(@PathVariable CarriageClass carriageClass) {
        return priceListService.findByCarriageClass(carriageClass);
    }

    @GetMapping("/price")
    public List<PriceList_Response> findByPriceBetween(@RequestBody PriceList_PriceBetween_Request request) {
        return priceListService.findByPriceBetween(request);
    }
}
