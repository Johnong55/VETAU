package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.Ticket_Request;
import com.PBL4.test.DTO.response.Account_Response;
import com.PBL4.test.DTO.response.Ticket_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.Ticket;
import com.PBL4.test.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ticket_Service {
    @Autowired
    Ticket_Repository ticket_repository;
    @Autowired
    Account_Repository account_repository;
    @Autowired
    Schedule_Repository schedule_repository;
    @Autowired
    PriceList_Repository price_list_repository;
    @Autowired
    Seat_Repository seat_repository;

    private Ticket generateTicket(Ticket_Request ticket_request) {
        String sku_TK = ticket_request.generateSkuTicket();
        if(ticket_repository.findBySku_TK(sku_TK) != null) {
                throw new AppException(ErrorCode.TICKET_EXISTED);
        }
        Ticket ticket = new Ticket().builder()
                .account(account_repository.findById(ticket_request.getAccountId()).orElseThrow(()->new AppException(ErrorCode.ACCOUNT_NOT_EXISTED)))
                .priceList(price_list_repository.findByPriceListID(ticket_request.getPriceListId()).orElseThrow(()-> new AppException(ErrorCode.PRICE_NOT_EXISTED)))
                .purchaseMethod(ticket_request.getPurchaseMethod())
                .schedule(schedule_repository.findByScheduleId(ticket_request.getScheduleId()).orElseThrow(()-> new AppException(ErrorCode.SCHEDULE_NOT_EXISTED)))
                .purchaseDate(ticket_request.getPurchaseDate())
                .status(ticket_request.getStatus())
                .seat(seat_repository.findBySeatId(ticket_request.getSeatId()).orElseThrow(()-> new AppException(ErrorCode.SEAT_NOT_EXISTED)))
                .sku_TK(sku_TK)
                .build();
        ticket_repository.save(ticket);
        return ticket;
    }
    public Ticket_Response createTicket(Ticket_Request ticket_request) {
        Ticket ticket = generateTicket(ticket_request);
        Ticket_Response ticket_response = new Ticket_Response().builder()
                .account(ticket.getAccount().getEmail())
                .status(ticket.getStatus())
                .arrivalStation(ticket.getPriceList().getArrivalStation().getStationName())
                .departureStation(ticket.getPriceList().getDepartureStation().getStationName())
                .Train(ticket.getSchedule().getTrain().getTrainName())
                .scheduleId(ticket.getSchedule().getScheduleId())
                .purchaseDate(ticket.getPurchaseDate())
                .seat(ticket.getSeat().getSku())
                .Carriage(ticket.getSeat().getCarriage().getCarriageName())
                .build();
    return null;

    }
}
