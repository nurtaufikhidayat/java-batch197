package com.xsis.batch197.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XBiodataAttachmentModel;
import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.repository.XBiodataAttachmentRepo;
import com.xsis.batch197.repository.XBiodataRepo;

@Controller
public class DokumenController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(DokumenController.class);
	
	@Autowired
	private XBiodataRepo bioRepo;
	
	@Autowired
	private XBiodataAttachmentRepo dokumenRepo;
	
	@GetMapping(value="/pelamar/dokumen/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		//view dokumen
		ModelAndView view = new ModelAndView("dokumen/index");
		//get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);
		//get dokumen
		List<XBiodataAttachmentModel> listDokumen = this.dokumenRepo.findByBiodataId(biodataId);
		view.addObject("listDokumen", listDokumen);
		
		return view;
	}
	
	// Method Button Add
	@GetMapping(value="/dokumen/add/{bid}") // bid ini sebagai variable dari biodataId
	public ModelAndView create(@PathVariable("bid") Long biodataId) {
		//menampilkan view dari folder dokumen file _create.html
		ModelAndView view = new ModelAndView("dokumen/_create");
		//membuat object biodataAttachment model
		XBiodataAttachmentModel dokumen = new XBiodataAttachmentModel();
		//set biodata id
		dokumen.setBiodataId(biodataId);
		//add object dokumen
		view.addObject("dokumen", dokumen);
		
		return view;
	}
	
	//Method simpan data
	@PostMapping(value="dokumen/save")
	public ModelAndView save(@Valid @ModelAttribute("dokumen") XBiodataAttachmentModel dokumen, BindingResult result) {
		//menampilkan view dari folder dokumen _create.html
		ModelAndView view = new ModelAndView("dokumen/_create");
		
		if (result.hasErrors()) {
			logger.info("Save Dokumen Error");
			//add object dokumen beserta errornya ke view
			view.addObject("dokumen", dokumen);
		} else {
			//set UserId
			dokumen.setCreatedBy(this.getAbuid());
			dokumen.setCreatedOn(new Date());
			//simpan ke repo
			dokumenRepo.save(dokumen);
			//add object baru tanpa error
			view.addObject("dokumen", new XBiodataAttachmentModel());
		}
		return view;
	}
	
	//menampilkan list data dokumen
	@GetMapping(value="/dokumen/list/{bid}")
	private ModelAndView list(@PathVariable("bid") Long biodataId) {
		//view dokumen
		ModelAndView view = new ModelAndView("dokumen/list");
		//get biodataId
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);
		//get dokumen
		List<XBiodataAttachmentModel> listDokumen = this.dokumenRepo.findByBiodataId(biodataId);
		view.addObject("listDokumen", listDokumen);
		
		return view;
	}
	
	//edit keahlian
	@GetMapping(value="/dokumen/edit/{kid}")
	private ModelAndView edit(@PathVariable("did") Long did) {
		//view edit
		ModelAndView view = new ModelAndView("dokumen/_edit");
		//mengambil data dari database via repo
		XBiodataAttachmentModel dokumen = this.dokumenRepo.findById(did).orElse(null);
		view.addObject("dokumen", dokumen);
		
		return view;
	}
	
	// Method simpan data
	@PostMapping(value="/dokumen/update")
	public ModelAndView update(@Valid @ModelAttribute("dokumen") XBiodataAttachmentModel dokumen, BindingResult result) {
		//menampilkan view dari folder dokumen _edit.html
		ModelAndView view = new ModelAndView("dokumen/_edit");
		
		if (result.hasErrors()) {
			logger.info("Update Dokumen Error");
			//add object dokumen beserta errornya ke view
			view.addObject("dokumen", dokumen);
		} else {
			//set UserId
			dokumen.setCreatedBy(this.getAbuid());
			dokumen.setCreatedOn(new Date());
			//simpan ke repo
			dokumenRepo.save(dokumen);
			//add object baru tanpa error
			view.addObject("dokumen", new XBiodataAttachmentModel());
		}
		return view;
	}
	
	//hapus data dokumen
	@GetMapping(value="/dokumen/hapus/{did}")
	private ModelAndView hapus(@PathVariable("did") Long did) {
		//view dokumen
		ModelAndView view = new ModelAndView("/dokumen/_hapus");
		//get keahlian
		XBiodataAttachmentModel dokumen = this.dokumenRepo.findById(did).orElse(null);
		view.addObject("dokumen", dokumen);
		return view;
	}
	
	@PostMapping(value="/dokumen/remove")
	private ModelAndView remove(@ModelAttribute("dokumen") XBiodataAttachmentModel dokumen) {
		//get dokumen
		XBiodataAttachmentModel item = this.dokumenRepo.findById(dokumen.getId()).orElse(null);
		dokumen.setIsDelete(1);
		this.dokumenRepo.save(dokumen);
		//view dokumen
		ModelAndView view = new ModelAndView("dokumen/_hapus");
		view.addObject("dokumen", dokumen);
		return view;
	}
	
}
