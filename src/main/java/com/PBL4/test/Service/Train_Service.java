package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.Train_Request;
import com.PBL4.test.DTO.response.Train_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.*;

import com.PBL4.test.mapper.TrainMapper;
import com.PBL4.test.repository.Train_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Train_Service {
    @Autowired
    private TrainMapper trainMapper;
    @Autowired
    private Train_Repository trainRepository;

    public Train_Response createTrain(Train_Request request) {
        if (trainRepository.existsByTrainName(request.getTrainName())) {
            throw new AppException(ErrorCode.TRAIN_EXISTED);
        }
        Train result = trainMapper.toTrain(request);
        result.setTrainId(generateCityID());
        return trainMapper.toTrainResponse(trainRepository.save(result));
    }

    public List<Train_Response> getAll() {
        return trainRepository.findAll().stream()
                .map(trainMapper::toTrainResponse)
                .collect(Collectors.toList());

    }

    private String generateCityID() {
        Train lastTrain = trainRepository.findLastTrain();
        if (lastTrain == null) {
            return "T001";
        }
        String lastID = lastTrain.getTrainId();
        int lastNumber = Integer.parseInt(lastID.substring(2));
        int newNumber = lastNumber + 1;
        return String.format("T%03d", newNumber);
    }

    public Train_Response findByID(String trainID) {
        Train train = trainRepository.findByTrainId(trainID)
                .orElseThrow(() -> new AppException(ErrorCode.TRAIN_NOT_EXISTED));
        return trainMapper.toTrainResponse(train);
    }

    public Train_Response findByName(String trainName) {
        Train train = trainRepository.findByTrainName(trainName)
                .orElseThrow(() -> new AppException(ErrorCode.TRAIN_NOT_EXISTED));
        return trainMapper.toTrainResponse(train);
    }

    public Train_Response updateTrain(String trainID, Train_Request request) {
        Train train = trainRepository.findByTrainId(trainID)
                .orElseThrow(() -> new RuntimeException("City not found"));
        trainMapper.updateTrain(train, request);
        return trainMapper.toTrainResponse(trainRepository.save(train));
    }

    public void deleteTrain(String trainId) {
        trainRepository.deleteById(trainId);
    }

}
