package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XRiwayatPekerjaanModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XRiwayatPekerjaanRepo;

@Controller
public class PengalamanController extends BaseController {
	@Autowired
	private XBiodataRepo bioRepo;
	
	@Autowired
	private XRiwayatPekerjaanRepo kelRepo;
	
	@GetMapping(value="/pelamar/pengalaman/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("pengalaman/index");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);
		
		// get RiwayatPekerjaan
		List<XRiwayatPekerjaanModel> listPengalaman = this.kelRepo.findByBiodataId(biodataId);
		view.addObject("listPengalaman", listPengalaman);
		return view;
	}
}
