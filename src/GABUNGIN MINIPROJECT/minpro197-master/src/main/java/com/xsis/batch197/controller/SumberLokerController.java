package com.xsis.batch197.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XSumberLokerModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XSumberLokerRepo;

@Controller
public class SumberLokerController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(SumberLokerController.class);
	@Autowired
	private XBiodataRepo bioRepo;
	
	@Autowired
	private XSumberLokerRepo lokerRepo;
	
	@GetMapping(value="/pelamar/sumber-low-kerja/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view loker
		ModelAndView view = new ModelAndView("sumber-low-kerja/index");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);
		
		// get sumber loker
		List<XSumberLokerModel> listLoker = this.lokerRepo.findByBiodataId(biodataId);
		view.addObject("listLoker", listLoker);
		return view;
	}
	
	@PostMapping(value="/sumber-low-kerja/save")
	public ModelAndView save(@Valid @ModelAttribute("sumber-low-kerja") XSumberLokerModel sumberLoker, BindingResult result) {
		// menampilkan view dari folder sertifikasi file _create.html
		ModelAndView view = new ModelAndView("sumber-low-kerja/index");
		
		if (result.hasErrors()) {
			logger.info("save biodata error");
			
			// add object sertifikasi dengan error nya ke view
			view.addObject("sumberLoker", sumberLoker);
		} else {
			//set user id
			sumberLoker.setCreatedBy(this.getAbuid());
			sumberLoker.setCreatedOn(new Date());
			// simpan ke repo
			lokerRepo.save(sumberLoker);
			// add object baru tanpa error
			view.addObject("sumberLoker", new XSumberLokerModel());
		}
		return view;
	}
	
}