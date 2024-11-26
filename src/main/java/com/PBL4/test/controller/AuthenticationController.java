package com.PBL4.test.controller;

import com.PBL4.test.DTO.response.Api_Response;
import com.PBL4.test.DTO.request.Authentication_Request;
import com.PBL4.test.DTO.request.Introspect_Request;
import com.PBL4.test.DTO.response.Authentication_response;
import com.PBL4.test.DTO.response.Introspect_Response;
import com.PBL4.test.Service.Authentication_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    Authentication_Service authentication_service;

    @PostMapping("/token")
    Api_Response<Authentication_response> authenticate(@RequestBody Authentication_Request rq)
    {

        Api_Response<Authentication_response> apiResponse = new Api_Response<>();

    var result=  authentication_service.authentication(rq);
        System.out.println(result);
        apiResponse.setResult(result);
        return apiResponse;
    }
    @PostMapping("/introspect")
    Api_Response<Introspect_Response> authenticate(@RequestBody Introspect_Request rq)
    {

        Api_Response<Introspect_Response> apiResponse = new Api_Response<>();

        var result=  authentication_service.introspect(rq);
        System.out.println(result);
        apiResponse.setResult(result);
        return apiResponse;
    }
}
