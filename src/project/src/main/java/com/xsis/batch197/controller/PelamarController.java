package com.xsis.batch197.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.repository.XBiodataRepo;

@Controller
@RequestMapping(value="/pelamar")
public class PelamarController {
	private static final Logger logger = LoggerFactory.getLogger(PelamarController.class);
	
	private XBiodataRepo biodataRepo;
	
	// #1. index => list data
		@GetMapping(value = "/index")
		public ModelAndView index() {
			// buat object view
			ModelAndView view = new ModelAndView("pelamar/index");
			return view;
		}

		// #2. Membuat Form Add pelamar
		@GetMapping(value = "/add")
		public ModelAndView create() {
			// buat object view
			ModelAndView view = new ModelAndView("pelamar/create");
			// membuat object pelamar yg akan dikirim ke view
			// object pelamar adalah new object dari PelamarModel
			XBiodataModel pelamar = new XBiodataModel();
			// isi kdProvinsi dengan method getKode()
			view.addObject("pelamar", pelamar);
			return view;
		}
}
