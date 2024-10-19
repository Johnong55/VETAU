package com.PBL4.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class home_controller {

		@GetMapping("/")
		public String index()
		{
			return "index";
		}
}
