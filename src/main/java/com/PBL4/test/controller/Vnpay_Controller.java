package com.PBL4.test.controller;


import com.PBL4.test.DTO.request.VnpayRequest;
import com.PBL4.test.Service.VNPAYService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Vnpay_Controller {

    @Autowired
    private VNPAYService vnPayService;

    // Chuyển hướng người dùng đến cổng thanh toán VNPAY
    @PostMapping("/submitOrder")
    public String submidOrder(@RequestBody VnpayRequest request){
        String vnpayUrl = vnPayService.createOrder(request.getAmount(), "Thanh toan ve");
        System.out.println(vnpayUrl);
        return vnpayUrl;
    }

}
