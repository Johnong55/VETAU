package com.PBL4.test.controller;

import com.PBL4.test.DTO.request.Ticket_Request;
import com.PBL4.test.DTO.response.Api_Response;
import com.PBL4.test.DTO.response.Ticket_Response;
import com.PBL4.test.Service.Ticket_Service;
import com.PBL4.test.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class Ticket_Controller {
    @Autowired
    private Ticket_Service ticket_service;

    @PostMapping
    public Api_Response<Ticket_Response> createTicket(@RequestBody Ticket_Request ticket_request) {
        return Api_Response.<Ticket_Response>builder()
                .result(ticket_service.createTicket(ticket_request))
                .build();
    }

    @GetMapping
    public List<Ticket_Response> findAll() {
        return ticket_service.findAll();
    }

    @DeleteMapping("/{ticketID}")
    Api_Response<String> deleteStation(@PathVariable String ticketID) {
        ticket_service.deleteTicket(ticketID);
        return Api_Response.<String>builder()
                .result("Station has been deleted")
                .build();
    }
}