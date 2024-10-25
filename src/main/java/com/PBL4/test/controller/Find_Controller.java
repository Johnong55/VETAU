package com.PBL4.test.controller;

import com.PBL4.test.DTO.request.ApiResponse;
import com.PBL4.test.DTO.request.ListTrip_Request;
import com.PBL4.test.DTO.response.ListTrip_Response;
//import com.PBL4.test.Service.ListTrip_Service;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Find_Controller {
  //  ListTrip_Service listTripService;
    @PostMapping("/findtrain")
    public String responseFindTrain(@RequestBody Map<String, String> payload) {

        String startCity = payload.get("startCity");
        String endCity = payload.get("endCity");
        String startDate = payload.get("date");

        System.out.println(startCity);
        System.out.println(endCity);
        System.out.println(startDate);
        // xử lí dữ liệu, trả về danh sách chuyến tàu


        return "ok";
    }
//    @PostMapping("/findtrain")
//    public ApiResponse<ListTrip_Response> getListTrip(@RequestBody ListTrip_Request request) {
//        ApiResponse<ListTrip_Response> response = new ApiResponse<>();
//        response.setCode(200);
//        response.setMessage("ok");
//        response.setResult(listTripService.getListTrip(request));
//
//        return response;
//    }
}
