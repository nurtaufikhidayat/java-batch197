package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XKeluargaModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XKeluargaRepo;

@Controller
public class KeluargaController extends BaseController {
	@Autowired
	private XBiodataRepo bioRepo;
	
	@Autowired
	private XKeluargaRepo kelRepo;
	
	@GetMapping(value="/pelamar/keluarga/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("keluarga/index");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);
		
		// get Keluarga
		List<XKeluargaModel> listKeluarga = this.kelRepo.findByBiodataId(biodataId);
		view.addObject("listKeluarga", listKeluarga);
		return view;
	}
}
