package com.PBL4.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

@Controller
public class home_controller {
		@GetMapping(value = {"/", "/index"})
		public String index()
		{
			return "index";
		}
		@GetMapping("/processbooking")
		public String processbooking()
		{
			return "processbooking";
		}
		@GetMapping("/reviewbooking")
		public String reviewbooking()
		{
			return "reviewbooking";
		}
		@GetMapping("/payment")
		public String payment()
		{
			return "payment";
		}
		@GetMapping("/processingOrder")
		public String processingOrder()
	{
		return "processingOrder";
	}
		@GetMapping("/test")
		public String test()
		{
			return "test";
		}
		@GetMapping("/bookingsuccess")
		public String bookingsuccess() {return "bookingsuccess";}
		@GetMapping("/admin")
		public String admin() {return "admin";}
		@GetMapping("/myTicket")
		public String myTicket() {return "myTicket";}
		@GetMapping("/informationalUser")
		public String informationalUser() {return "informationalUser";}
}
