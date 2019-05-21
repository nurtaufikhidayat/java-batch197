package com.xsis.batch197.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value = "/")//value tidak boleh sama meskipun beda controller
	public String index() {
		return "home/index";
	}
	@RequestMapping(value ="home/contact-us")
	public String contackUs() {
		return "home/contact-us";
	}

}
