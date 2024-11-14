package com.PBL4.test.controller;

import com.PBL4.test.DTO.request.Api_Response;
import com.PBL4.test.DTO.request.Seat_Request;
import com.PBL4.test.DTO.request.Seat_UpdateRequest;
import com.PBL4.test.DTO.request.Station_Request;
import com.PBL4.test.DTO.response.Seat_Response;
import com.PBL4.test.DTO.response.Station_Response;
import com.PBL4.test.Service.Seat_Service;
import com.PBL4.test.Service.Station_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class Seat_Controller {
    @Autowired
    private Seat_Service seat_service;

    @PostMapping
    public Api_Response<List<Seat_Response>> createSeat(@RequestBody Seat_Request request) {
        return Api_Response.<List<Seat_Response>>builder()
                .result(seat_service.createSeats(request))
                .build();
    }

    @GetMapping
    public List<Seat_Response> getAll() {
        return seat_service.getAll();
    }

    @PutMapping("/{seatID}")
    public Seat_Response updateStation(@PathVariable String seatID, @RequestBody Seat_UpdateRequest request) {
        return seat_service.updateSituation(seatID, request);
    }

    @DeleteMapping("/{seatID}")
    Api_Response<String> deleteBySeatID(@PathVariable String seatID) {
        seat_service.deleteSeat(seatID);
        return Api_Response.<String>builder()
                .result("Seat has been deleted")
                .build();
    }
    @DeleteMapping("/carriageID/{carriageID}")
    Api_Response<String> deleteByCarriageID(@PathVariable String carriageID) {
        seat_service.deleteByCarriageID(carriageID);
        return Api_Response.<String>builder()
                .result("Seats has been deleted")
                .build();
    }

    @GetMapping("/sku/{seatSku}")
    public Seat_Response findBySku(@PathVariable String seatSku) {
        return seat_service.findBySku(seatSku);
    }

    @GetMapping("/id/{seatID}")
    public Seat_Response findByID(@PathVariable String seatID) {
        return seat_service.findByID(seatID);
    }
    @GetMapping("/carriageID/{carriageID}")
    public List<Seat_Response> findByCarriageID(@PathVariable String carriageID) {
        return seat_service.findByCarriageID(carriageID);
    }
}
