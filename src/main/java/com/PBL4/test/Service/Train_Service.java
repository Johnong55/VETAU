//package com.PBL4.test.Service;
//
//import com.PBL4.test.DTO.request.Train_Request;
//import com.PBL4.test.entity.Train;
//import com.PBL4.test.entity.TrainTrip;
//import com.PBL4.test.entity.Carriage;
//import com.PBL4.test.entity.Schedule;
//
//import com.PBL4.test.mapper.App_Mapper;
//import com.PBL4.test.repository.Train_Repository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.Optional;
//
//@Service
//public class Train_Service {
//
//    @Autowired
//    private Train_Repository trainRepository;
//
//    public void addTrainTripToTrain(String trainId, TrainTrip trainTrip) {
//        Optional<Train> optionalTrain = trainRepository.findById(trainId);
//        if (optionalTrain.isPresent()) {
//            Train train = optionalTrain.get();
//            train.addTrainTrip(trainTrip);
//            trainRepository.save(train); // Lưu lại train với TrainTrip mới
//        }
//    }
//
//    public void addCarriageToTrain(String trainId, Carriage carriage) {
//        Optional<Train> optionalTrain = trainRepository.findById(trainId);
//        if (optionalTrain.isPresent()) {
//            Train train = optionalTrain.get();
//            train.addcarriage(carriage);
//            trainRepository.save(train);
//        }
//    }
//
//    public void addScheduleToTrain(String trainId, Schedule schedule) {
//        Optional<Train> optionalTrain = trainRepository.findById(trainId);
//        if (optionalTrain.isPresent()) {
//            Train train = optionalTrain.get();
//            train.addSchedule(schedule);
//            trainRepository.save(train);
//        }
//    }
//    public Train CreateRequest(Train_Request rq)
//    {
//        Train train =  new Train();
//        App_Mapper mapper =  new App_Mapper();
//        train = mapper.CreationtoTrain(rq);
//        return trainRepository.save(train);
//    }
//}
