package com.PBL4.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PBL4.test.Service.Account_Service;
import com.PBL4.test.entity.Account;

import com.PBL4.test.DTO.Account_Request;

@RestController
@RequestMapping("/accounts")  // Fixed typo: "/ccounts" to "/accounts"
public class Account_Controller {

    @Autowired
    private Account_Service service;
    
    @PostMapping(produces = {"application/json", "application/xml"}, consumes = "application/json")
    public Account CreateAccount(@RequestBody Account_Request rq) {
        return service.CreateRequest(rq);
    }
    
    @GetMapping("/account")
    public List<Account> FindAllAccount()
    {
    	return service.findall();
    }
    
    @GetMapping("/account/{accountEmail}")
    public Account FindByEmail(@PathVariable("accountEmail") String email)
    {
    	return service.FindByEmail(email);
    }
    
}
