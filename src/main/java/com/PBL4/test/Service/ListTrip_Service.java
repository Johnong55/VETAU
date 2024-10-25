//package com.PBL4.test.Service;
//
//import com.PBL4.test.DTO.request.ListTrip_Request;
//import com.PBL4.test.DTO.response.ListTrip_Response;
//import com.PBL4.test.DTO.response.TrainTrip_Response;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//
//@Service
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//public class ListTrip_Service {
//    public ListTrip_Response getListTrip(ListTrip_Request request) {
//        return ListTrip_Response.builder()
//                .StartDate(request.getStartDate())
//                .listTrip(getListTrainTrip(request))
//                .build();
//    }
//    public Set<TrainTrip_Response> getListTrainTrip(ListTrip_Request request) {
//
//    }
//}
