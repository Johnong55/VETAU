package com.PBL4.test.controller;

import java.util.List;

import com.PBL4.test.DTO.request.Account_UpdateRequest;
import com.PBL4.test.DTO.request.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.PBL4.test.Service.Account_Service;
import com.PBL4.test.entity.Account;

import com.PBL4.test.DTO.request.Account_Request;

@RestController
@RequestMapping("/accounts")  // Fixed typo: "/ccounts" to "/accounts"
public class Account_Controller {

    @Autowired
    private Account_Service service;
    @Autowired
    private Account_Service account_Service;

    @PostMapping(produces = {"application/json", "application/xml"}, consumes = "application/json")
    public ApiResponse<Account> CreateAccount(@RequestBody @Validated Account_Request rq) {
            ApiResponse<Account> apiResponse = new ApiResponse<>();
            apiResponse.setResult(account_Service.CreateRequest(rq));
            return apiResponse ;
    }
    
    @GetMapping("/account")
    public List<Account> FindAllAccount()
    {
    	return service.findall();
    }
    
     @PutMapping("/account/{accountID}")
    public ApiResponse<Account> updateAccount(@RequestBody Account_UpdateRequest rq, @PathVariable("accountID") String accountID)
    {
        ApiResponse<Account> apiResponse = new ApiResponse<>();
        apiResponse.setResult(account_Service.UpdateRequest(rq,accountID));
        return apiResponse ;
    }
    @GetMapping("/account/{accountID}")
    public Account FindById(@PathVariable("accountID") String accountID)
    {
        return account_Service.getAccount(accountID);
    }
}
