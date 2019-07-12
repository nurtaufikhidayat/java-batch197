package com.xsis.batch197.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/pengguna")
public class PenggunaController {
	
	private static final Logger logger = LoggerFactory.getLogger(PenggunaController.class);
	
	@GetMapping(value="/add")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("pengguna/_create");
		return view;
	}

}
