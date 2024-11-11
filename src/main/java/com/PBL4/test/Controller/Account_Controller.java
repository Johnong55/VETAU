package com.PBL4.test.Controller;

import java.util.List;

import com.PBL4.test.DTO.request.Account_UpdateRequest;
import com.PBL4.test.DTO.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.PBL4.test.Service.Account_Service;
import com.PBL4.test.entity.Account;

import com.PBL4.test.DTO.request.Account_Request;

@RestController
@RequestMapping("/accounts")  // Fixed typo: "/ccounts" to "/accounts"
public class Account_Controller {

    private static final Logger log = LoggerFactory.getLogger(Account_Controller.class);
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
    
    @GetMapping()
    public List<Account> FindAllAccount()
    {

       var authenticate =  SecurityContextHolder.getContext().getAuthentication();
        log.info("username:{}",authenticate.getName());
        authenticate.getAuthorities().forEach(grantedAuthority -> log.info("grantedAuthority:{}",grantedAuthority) );
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
