package com.PBL4.test.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Book_Controller {
    @PostMapping("/confirmbook")
    public String responseConfirmBook(@RequestBody Map<String, String> payload)
    {


        return "ok";
    }
    @PostMapping("/booknow")
    public String responseBookNow(@RequestBody Map<String, String> payload)
    {



        return "ok";
    }
}
