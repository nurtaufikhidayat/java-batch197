package com.xsis.batch197.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {	
	@GetMapping(value="/login")
	public String login() {
		return "auth/login";
	}
	
	@GetMapping(value = "/register")
	public String register() {
		return "auth/register";
	}
}
