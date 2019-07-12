package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XSertifikasiModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XSertifikasiRepo;

@Controller
public class SertifikasiController extends BaseController {
	@Autowired
	private XBiodataRepo bioRepo;
	
	@Autowired
	private XSertifikasiRepo sertRepo;
	
	@GetMapping(value="/pelamar/sertifikasi/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("sertifikasi/index");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);
		
		// get sertifikasi
		List<XSertifikasiModel> listSertifikasi = this.sertRepo.findByBiodataId(biodataId);
		view.addObject("listSertifikasi", listSertifikasi);
		return view;
	}
}
