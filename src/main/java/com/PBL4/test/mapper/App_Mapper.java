//package com.PBL4.test.mapper;
//
//import com.PBL4.test.DTO.request.Account_UpdateRequest;
//import com.PBL4.test.DTO.request.CityRequest;
//import com.PBL4.test.DTO.request.Train_Request;
//import com.PBL4.test.Exception.AppException;
//import com.PBL4.test.Exception.ErrorCode;
//import com.PBL4.test.entity.*;
//
//import com.PBL4.test.DTO.request.Account_Request;
//import com.PBL4.test.repository.Schedule_Repository;
//import com.PBL4.test.repository.Station_Repository;
//import com.PBL4.test.repository.TrainTrip_Repository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//
//public class App_Mapper {
//
//    @Autowired
//    private Schedule_Repository scheduleRepository;
//    @Autowired
//    private TrainTrip_Repository trainTripRepository;
//    @Autowired
//    private Station_Repository stationRepository;
//
//    public Account CreationtoAccount(Account_Request rq) {
//
//        Account ac = new Account();
//        System.out.println(rq);
//        ac.setAddress(rq.getAddress());
//        ac.setCid(rq.getCid());
//        ac.setDob(rq.getDob());
//        ac.setEmail(rq.getEmail());
//        ac.setFirstName(rq.getFirstName());
//        ac.setLastName(rq.getLastName());
//        ac.setPassword(rq.getPassword());
//        ac.setPhoneNumber(rq.getPhoneNumber());
//        ac.setUsername(rq.getUsername());
//        System.out.println(ac);
//        return ac;
//
//    }
//
//    public Account UpdateToAccount(Account_UpdateRequest rq, Account ac) {
//
//        ac.setAddress(rq.getAddress());
//
//        ac.setDob(rq.getDob());
//
//        ac.setFirstName(rq.getFirstName());
//        ac.setLastName(rq.getLastName());
//        ac.setPassword(rq.getPassword());
//        ac.setPhoneNumber(rq.getPhoneNumber());
//
//        System.out.println("hehehe");
//        System.out.println(ac);
//        return ac;
//    }
//
////    public Train CreationtoTrain(Train_Request rq) {
////        Train train = new Train();
////        train.setTrainName(rq.getTrainName());
////        List<Schedule> schedules = rq.getScheduleIds().stream().map(id -> scheduleRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.SCHEDULE_NOTEXISTED))).collect(Collectors.toList());
////        schedules.forEach(train::addSchedule);
////        List<TrainTrip> trainTrips = rq.getTrainTripIds().stream().map(id -> trainTripRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.TrainTrip_NOTEXISTED))).collect(Collectors.toList());
////        return train;
////    }
//
////    public City CreationtoCity(CityRequest rq) {
////        City city = new City();
////        city.setCityName(rq.getCityName());
////
////        // Fetch and add each station associated with the city
////        List<Station> stations = rq.getStationIds().stream()
////                .map(id -> stationRepository.findById(id)
////                        .orElseThrow(() -> new AppException(ErrorCode.STATION_NOT_EXISTED)))
////                .collect(Collectors.toList());
////
////        stations.forEach(city::addStation); // Assuming City has an addStation method to add each Station
////
////        return city;
////    }
//
//
//}
