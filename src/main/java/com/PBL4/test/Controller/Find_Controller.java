package com.PBL4.test.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Find_Controller {
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
}
