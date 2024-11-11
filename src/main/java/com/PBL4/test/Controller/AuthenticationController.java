package com.PBL4.test.Controller;

import com.PBL4.test.DTO.response.ApiResponse;
import com.PBL4.test.DTO.request.Authentication_Request;
import com.PBL4.test.DTO.request.IntrospectRequest;
import com.PBL4.test.DTO.response.Authentication_response;
import com.PBL4.test.DTO.response.IntrospectResponse;
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
    ApiResponse<Authentication_response> authenticate(@RequestBody Authentication_Request rq)
    {

        ApiResponse<Authentication_response> apiResponse = new ApiResponse<>();

    var result=  authentication_service.authentication(rq);
        System.out.println(result);
        apiResponse.setResult(result);
        return apiResponse;
    }
    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest rq)
    {

        ApiResponse<IntrospectResponse> apiResponse = new ApiResponse<>();

        var result=  authentication_service.introspect(rq);
        System.out.println(result);
        apiResponse.setResult(result);
        return apiResponse;
    }
}
