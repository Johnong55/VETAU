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

		@PostMapping("/findtrain")
		@ResponseBody
		public String responseFindTrain(@RequestBody Map<String, String> payload) {

			String startCity = payload.get("startCity");
			String endCity = payload.get("endCity");
			String startDate = payload.get("date");

			// In dữ liệu ra console để kiểm tra
			System.out.println("Start City: " + startCity);
			System.out.println("End City: " + endCity);
			System.out.println("End City: " + startDate);


			return "ok";
		}
		@GetMapping("/processbooking")
		public String processbooking() {
			return "processbooking";
		}

		@PostMapping("/confirmbook")
		@ResponseBody
		public String responseConfirmBook(@RequestBody Map<String, String> payload) {




			return "ok";
		}

		@GetMapping("/reviewbooking")
		public String reviewbooking() {
		return "reviewbooking";
		}
}
