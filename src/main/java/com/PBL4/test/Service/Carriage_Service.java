package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.Carriage_Request;
import com.PBL4.test.DTO.request.City_Request;
import com.PBL4.test.DTO.response.Carriage_Response;
import com.PBL4.test.DTO.response.City_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.*;
import com.PBL4.test.mapper.CarriageMapper;
import com.PBL4.test.mapper.CityMapper;
import com.PBL4.test.mapper.Station_Mapper;
import com.PBL4.test.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
public class Carriage_Service {
    @Autowired
    Carriage_Repository carriageRepository;
    @Autowired
    CarriageMapper carriageMapper;
    @Autowired
    private Seat_Service seat_Service;
    @Autowired
    private Seat_Repository seatRepository;
    @Autowired
    private Train_Repository trainRepository;

    private String generateCarriageID() {
        Carriage lastCarriage = carriageRepository.findLastCarriage();
        if ( lastCarriage == null) {
            return "CR001";
        }
        String lastID = lastCarriage.getCarriageId();
        int lastNumber = Integer.parseInt(lastID.substring(2));
        int newNumber = lastNumber + 1;
        return String.format("CR%03d", newNumber);
    }
    @Transactional
    public Carriage_Response createCarriage(Carriage_Request request) {
        if (carriageRepository.existsByCarriageName(request.getCarriageName())) {
            throw new AppException(ErrorCode.CARRIAGE_EXISTED);
        }

        Train train = trainRepository.findByTrainId(request.getTrainID())
                .orElseThrow(()->new AppException(ErrorCode.TRAIN_NOT_EXISTED));
        Carriage carriage = carriageMapper.toCarriage(request);
        carriage.setCarriageId(generateCarriageID());
        carriage.setTrain(train);
        Carriage_Response response = carriageMapper.toCarriageResponse(carriageRepository.save(carriage));
        response.setSeatType(carriage.getCarriageClass().getSeatType());
        return response;
    }


    public List<Carriage_Response> findAll() {
        return carriageRepository.findAll().stream()
                .map(carriage -> {
                    Carriage_Response carriageResponse = carriageMapper.toCarriageResponse(carriage);
                    carriageResponse.setSeatType(carriage.getCarriageClass().getSeatType());
                    return carriageResponse;
                })
                .collect(Collectors.toList());
    }


    public Carriage_Response findByName(String carriageName) {
        Carriage carriage = carriageRepository.findByCarriageName(carriageName)
                .orElseThrow(() -> new AppException(ErrorCode.CARRIAGE_NOT_EXISTED));
        Carriage_Response carriageResponse = carriageMapper.toCarriageResponse(carriage);
        carriageResponse.setSeatType(carriage.getCarriageClass().getSeatType());
        return carriageResponse;
    }

    public Carriage_Response findByID(String carriageID) {
        Carriage carriage = carriageRepository.findByCarriageId(carriageID)
                .orElseThrow(() -> new AppException(ErrorCode.CARRIAGE_NOT_EXISTED));
        Carriage_Response carriageResponse = carriageMapper.toCarriageResponse(carriage);
        carriageResponse.setSeatType(carriage.getCarriageClass().getSeatType());
        return carriageResponse;
    }

    public List<Carriage_Response> findByTrainID(String trainId) {
        List<Carriage> carriages = carriageRepository.findByTrain_TrainId(trainId);

        if (carriages.isEmpty()) {
            throw new AppException(ErrorCode.CARRIAGE_NOT_EXISTED);
        }
        
        return carriages.stream()
                .map(carriage -> {
                    Carriage_Response carriageResponse = carriageMapper.toCarriageResponse(carriage);
                    carriageResponse.setSeatType(carriage.getCarriageClass().getSeatType());
                    return carriageResponse;
                })
                .collect(Collectors.toList());
    }

    public Carriage_Response updateCarriage(String carriageID, Carriage_Request request) {
        Carriage carriage = carriageRepository.findByCarriageId(carriageID)
                .orElseThrow(() -> new AppException(ErrorCode.CARRIAGE_NOT_EXISTED));
        carriageMapper.updateCarriage(carriage, request);
        Carriage_Response response = carriageMapper.toCarriageResponse(carriageRepository.save(carriage));
        response.setSeatType(carriage.getCarriageClass().getSeatType());
        return response;
    }

    public void deleteCarriage(String carriageID) {
        carriageRepository.deleteById(carriageID);
    }
}
