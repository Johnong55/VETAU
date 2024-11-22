package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.PriceList_PriceBetween_Request;
import com.PBL4.test.DTO.request.PriceList_Request;
import com.PBL4.test.DTO.response.PriceList_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.*;
import com.PBL4.test.enums.CarriageClass;
import com.PBL4.test.mapper.PriceListMapper;
import com.PBL4.test.repository.PriceList_Repository;
import com.PBL4.test.repository.Schedule_Repository;
import com.PBL4.test.repository.Season_Rate_Repository;
import com.PBL4.test.repository.Station_Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PriceList_Service {
    @Autowired
    PriceList_Repository priceListRepository;
    @Autowired
    Schedule_Repository scheduleRepository;
    @Autowired
    Station_Repository stationRepository;
    @Autowired
    Season_Rate_Repository seasonRateRepository;
    @Autowired
    PriceListMapper priceListMapper;

    private String generatePriceListID() {
        PriceList lastPriceList = priceListRepository.findLastPriceList();
        if (lastPriceList == null) {
            return "PRL000001";
        }
        String lastID = lastPriceList.getPriceListID();
        int lastNumber = Integer.parseInt(lastID.substring(3));
        int newNumber = lastNumber + 1;
        return String.format("PRL%06d", newNumber);
    }

    @Transactional
    public PriceList_Response createPriceList(PriceList_Request request) {
        if (priceListRepository.existsByDepartureStation_StationIdAndArrivalStation_StationIdAndSchedule_scheduleIdAndCarriageClass(
                request.getDepartureStationId(),
                request.getArrivalStationId(),
                request.getScheduleId(),
                request.getCarriageClass())) {
            throw new AppException(ErrorCode.PRICE_EXISTED);
        }

        Schedule schedule = scheduleRepository.findByScheduleId(request.getScheduleId())
                .orElseThrow(()->new AppException(ErrorCode.SCHEDULE_NOT_EXISTED));
        Station departureStation = stationRepository.findByStationId(request.getDepartureStationId())
                .orElseThrow(()->new AppException(ErrorCode.STATION_NOT_EXISTED));
        Station arrivalStation = stationRepository.findByStationId(request.getArrivalStationId())
                .orElseThrow(()->new AppException(ErrorCode.STATION_NOT_EXISTED));
        SeasonalRate seasonalRate = seasonRateRepository.findBySeasonalRateId(request.getSeasonalRateId())
                .orElseThrow(()->new AppException(ErrorCode.SEASONAL_RATE_NOT_EXISTED));
        PriceList priceList = priceListMapper.toPriceList(request);
        priceList.setPriceListID(generatePriceListID());
        priceList.setSchedule(schedule);
        priceList.setDepartureStation(departureStation);
        priceList.setArrivalStation(arrivalStation);
        double price = request.getPrice() * seasonalRate.getRateMultiplier();
        priceList.setPrice(price);
        priceList.setSeasonalRate(seasonalRate);
        return priceListMapper.toPriceListResponse(priceListRepository.save(priceList));
    }


    public List<PriceList_Response> findAll() {
        return priceListRepository.findAll().stream()
                .map(priceListMapper::toPriceListResponse)
                .collect(Collectors.toList());
    }


    public List<PriceList_Response> findByPriceBetween(PriceList_PriceBetween_Request request) {
        if (request.getMinPrice() < 0 || request.getMaxPrice() < 0 || request.getMinPrice() > request.getMaxPrice()) {
            throw new AppException(ErrorCode.INVALID_PRICE_RANGE);
        }
        List<PriceList> priceLists = priceListRepository.findByPriceBetween(request.getMinPrice(), request.getMaxPrice());
        return priceLists.stream()
                .map(priceListMapper::toPriceListResponse)
                .toList();
    }

    public PriceList_Response findByID(String priceListID) {
        PriceList priceList = priceListRepository.findById(priceListID)
                .orElseThrow(()->new AppException(ErrorCode.PRICE_NOT_EXISTED));
        return priceListMapper.toPriceListResponse(priceList);
    }

    public List<PriceList_Response> findByDepartureStationID(String departureStationID) {
        List<PriceList> priceLists = priceListRepository.findByDepartureStation_StationId(departureStationID);

        if (priceLists.isEmpty()) {
            throw new AppException(ErrorCode.PRICE_NOT_EXISTED);
        }

        return priceLists.stream()
                .map(priceListMapper::toPriceListResponse)
                .toList();
    }
    public List<PriceList_Response> findByArrivalStationID(String arrivalStationID) {
        List<PriceList> priceLists = priceListRepository.findByArrivalStation_StationId(arrivalStationID);

        if (priceLists.isEmpty()) {
            throw new AppException(ErrorCode.PRICE_NOT_EXISTED);
        }

        return priceLists.stream()
                .map(priceListMapper::toPriceListResponse)
                .toList();
    }
    public List<PriceList_Response> findByCarriageClass(CarriageClass carriageClass) {
        List<PriceList> priceLists = priceListRepository.findByCarriageClass(carriageClass);

        if (priceLists.isEmpty()) {
            throw new AppException(ErrorCode.PRICE_NOT_EXISTED);
        }

        return priceLists.stream()
                .map(priceListMapper::toPriceListResponse)
                .toList();
    }

//    public Carriage_Response updateCarriage(String carriageID, Carriage_Request request) {
//        Carriage carriage = carriageRepository.findByCarriageId(carriageID)
//                .orElseThrow(() -> new AppException(ErrorCode.CARRIAGE_NOT_EXISTED));
//        carriageMapper.updateCarriage(carriage, request);
//        Carriage_Response response = carriageMapper.toCarriageResponse(carriageRepository.save(carriage));
//        response.setSeatType(carriage.getCarriageClass().getSeatType());
//        return response;
//    }

    public void deletePriceList(String carriageID) {
        priceListRepository.deleteById(carriageID);
    }
}