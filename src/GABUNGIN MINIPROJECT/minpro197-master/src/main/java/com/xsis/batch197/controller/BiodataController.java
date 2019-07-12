package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XKeahlianModel;
import com.xsis.batch197.repository.XBiodataRepo;

@Controller
public class BiodataController extends BaseController {

	@Autowired
	private XBiodataRepo bioRepo;

	@GetMapping(value = "/pelamar/biodata/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view biodata
		ModelAndView view = new ModelAndView("biodata/index");
		// get biodata Id
		XBiodataModel biodata = bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);
		return view;
	}

}
