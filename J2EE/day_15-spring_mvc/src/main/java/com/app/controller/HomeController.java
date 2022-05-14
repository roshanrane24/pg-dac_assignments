package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	public HomeController() {
	}
	
//	@PostConstruct
//	public void init() {
//		
//	}
	
	@RequestMapping("/")
	public String homePage() {
		return "/index";
	}
	
}
