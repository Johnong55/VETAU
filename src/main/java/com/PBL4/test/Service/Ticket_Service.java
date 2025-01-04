package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.Ticket_Request;
import com.PBL4.test.DTO.response.Account_Response;
import com.PBL4.test.DTO.response.Ticket_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.Ticket;
import com.PBL4.test.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
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
   @Autowired
   Carriage_Repository carriage_repository;
   @Autowired
   Stop_Schedule_Service stop_schedule_service;
   private Ticket generateTicket(Ticket_Request ticket_request) {
      String sku_TK = ticket_request.generateSkuTicket();
      log.info("sku_TK: {}", sku_TK);
      Ticket ticket = new Ticket().builder()
              .account(account_repository.findById(ticket_request.getAccountId()).orElseThrow(()->new AppException(ErrorCode.ACCOUNT_NOT_EXISTED)))
              .purchaseMethod(ticket_request.getPurchaseMethod())
              .schedule(schedule_repository.findByScheduleId(ticket_request.getScheduleId()).orElseThrow(()-> new AppException(ErrorCode.SCHEDULE_NOT_EXISTED)))
              .purchaseDate(LocalDateTime.now())
              .status(ticket_request.getStatus())
              .seat(seat_repository.findBySeatId(ticket_request.getSeatId()).orElseThrow(()-> new AppException(ErrorCode.SEAT_NOT_EXISTED)))
              .sku_TK(sku_TK)
              .departureTime(ticket_request.getDepartureTime())
              .arrivalTime(ticket_request.getArrivalTime())
              .build();

      log.info(ticket.getSeat().getCarriage().getCarriageClass().name()+" "+ticket_request.getDepartureStationName()+" "+ticket_request.getArrivalStationName()+" "+ticket_request.getScheduleId());
      ticket.setPriceList(price_list_repository.findPriceByClient(ticket_request.getDepartureStationName(),ticket_request.getArrivalStationName(), ticket_request.getScheduleId(),ticket.getSeat().getCarriage().getCarriageClass()).orElseThrow(()-> new AppException(ErrorCode.PRICE_NOT_EXISTED)));

      ticket.setTotal((long) ticket.getPriceList().getPrice());
      stop_schedule_service.synchronousInsertOrderedSeat(ticket_request);

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
              .sku(ticket.getSku_TK())
              .purchaseMethod(ticket.getPurchaseMethod())
              .departureTime(ticket.getDepartureTime())
              .arrivalTime(ticket.getArrivalTime())
              .total(ticket.getTotal())
              .build();
      ticket_repository.save(ticket);
      return ticket_response;

   }
   public List<Ticket_Response> findAll() {
      List<Ticket> tickets = ticket_repository.findAll();
      List<Ticket_Response> ticket_responses = new ArrayList<>();
      for(Ticket ticket : tickets) {
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
                 .sku(ticket.getSku_TK())
                 .purchaseMethod(ticket.getPurchaseMethod())
                 .departureTime(ticket.getDepartureTime())
                 .arrivalTime(ticket.getArrivalTime())
                 .total(ticket.getTotal())
                 .build();

         ticket_responses.add(ticket_response);
      }
      return  ticket_responses;
   }
   public void deleteTicket(String ticket_id) {
      ticket_repository.deleteById(ticket_id);

   }
}
