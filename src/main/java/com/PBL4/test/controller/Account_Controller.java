package com.PBL4.test.controller;

import java.util.List;

import com.PBL4.test.DTO.request.Account_UpdateRequest;
import com.PBL4.test.DTO.request.Api_Response;
import com.PBL4.test.DTO.response.Account_Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.PBL4.test.Service.Account_Service;
import com.PBL4.test.entity.Account;

import com.PBL4.test.DTO.request.Account_CreationRequest;

@RestController
@RequestMapping("/accounts")  // Fixed typo: "/ccounts" to "/accounts"
public class  Account_Controller {

    @Autowired
    private Account_Service accountService;

    @PostMapping(produces = {"application/json", "application/xml"}, consumes = "application/json")
    public Api_Response<Account_Response> createAccount(@RequestBody @Validated Account_CreationRequest request) {
        return Api_Response.<Account_Response>builder()
                .result(accountService.createAccount(request))
                .build();

    }

    @GetMapping
    public List<Account_Response> findAllAccount() {
        return accountService.findall();
    }

    @PutMapping("/{accountID}")
    public Api_Response<Account_Response> updateAccount(@RequestBody Account_UpdateRequest request, @PathVariable("accountID") String accountID) {
        return Api_Response.<Account_Response>builder()
                .result(accountService.updateAccount(accountID, request))
                .build();
    }

    @GetMapping("/id/{accountID}")
    public Api_Response<Account_Response> findById(@PathVariable("accountID") String accountID) {
        return Api_Response.<Account_Response>builder()
                .result(accountService.getByAccountID(accountID))
                .build();
    }

    @GetMapping("/username/{username}")
    public Api_Response<Account_Response> findByUsename(@PathVariable("username") String username) {
        return Api_Response.<Account_Response>builder()
                .result(accountService.getByUsername(username))
                .build();
    }

    @GetMapping("/email/{email}")
    public Api_Response<Account_Response> findByEmail(@PathVariable("email") String email) {
        return Api_Response.<Account_Response>builder()
                .result(accountService.getByEmail(email))
                .build();
    }

    @DeleteMapping("/{accountId}")
    Api_Response<String> deleteAccount(@PathVariable String accountId) {
        accountService.deleteAccount(accountId);
        return Api_Response.<String>builder()
                .result("Account has been deleted")
                .build();
    }
}