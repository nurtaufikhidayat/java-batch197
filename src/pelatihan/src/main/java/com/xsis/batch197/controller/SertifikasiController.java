package com.xsis.batch197.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XSertifikasiModel;
import com.xsis.batch197.repository.XSertifikasiRepo;

@Controller
@RequestMapping(value = "/sertifikasi")
public class SertifikasiController {
	private static final Logger Logger = LoggerFactory.getLogger(SertifikasiController.class);
	//untuk mengambil data dr database
	@Autowired
	private XSertifikasiRepo repo;

	@GetMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("sertifikasi/index");
		return view;
	}


	@GetMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("sertifikasi/list");
		// load data sertifikasi via repo, disimpan kedalam list
		List<XSertifikasiModel> listsertifikasi = repo.findAll();
		// lemparkan data ke view, list object baru, datanya listsertifikasi
		view.addObject("list", listsertifikasi);

		return view;
	}
	
	@GetMapping(value = "/add")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("sertifikasi/create");
		// membuat object sertifikasi yg akan dikirim ke view
		// object sertifikasi adalah new object dari sertifikasiModel
		XSertifikasiModel sertifikasi = new XSertifikasiModel();
		
		view.addObject("sertifikasi", sertifikasi);
		return view;

	}

	@GetMapping(value = "/testing")
	public ModelAndView testing() {
		ModelAndView view = new ModelAndView("sertifikasi/testing");
		return view;

	}

	
	// #3. Menangkap data dari form
		@PostMapping(value = "/save")
		public ModelAndView save(@Valid @ModelAttribute("sertifikasi") 	XSertifikasiModel sertifikasi, BindingResult result) {
			Logger.error("--"+sertifikasi.getIsDelete());
			if (result.hasErrors()) {
				Logger.info("save sertifikasi error");
			}else {
				repo.save(sertifikasi);
			}
			
			ModelAndView view = new ModelAndView("sertifikasi/create");
			view.addObject("sertifikasi", sertifikasi);
			return view;
		}
		
		// #2. Membuat Form Add sertifikasi
		@GetMapping(value = "/edit/{id}")
		public ModelAndView edit(@PathVariable("id") Long id) {
			// buat object view
			ModelAndView view = new ModelAndView("sertifikasi/update");
			// mengambil data dahulu dari database via repository
			XSertifikasiModel sertifikasi = repo.findById(id).orElse(new XSertifikasiModel());
			// membuat object sertifikasi yg akan dikirim ke view
			// object sertifikasi adalah new object dari sertifikasiModel
			view.addObject("sertifikasi", sertifikasi);
			return view;
		}
		// #3. Menangkap data dari form
		@PostMapping(value = "/update")
		public ModelAndView update(@Valid @ModelAttribute("sertifikasi") XSertifikasiModel sertifikasi, BindingResult result) {
			if (result.hasErrors()) {
				Logger.info("save sertifikasi error");
			}else {
				repo.save(sertifikasi);
			}
			
			ModelAndView view = new ModelAndView("sertifikasi/update");
			view.addObject("sertifikasi", sertifikasi);
			return view;
		}
		
		// #4. Membuat Form Add provinsi
		@GetMapping(value = "/delete/{id}")
		public ModelAndView delete(@PathVariable("id") Long id) {
			// buat object view
			ModelAndView view = new ModelAndView("sertifikasi/delete");
			// mengambil data dahulu dari database via repository
			XSertifikasiModel sertifikasi = repo.findById(id).orElse(new XSertifikasiModel());
			// membuat object sertifikasi yg akan dikirim ke view
			// object sertifikasi adalah new object dari sertifikasiModel
			view.addObject("sertifikasi", sertifikasi);
			return view;
		}
		
		// #3. Menangkap data dari form
		@PostMapping(value = "/remove")
		public ModelAndView remove(@ModelAttribute("sertifikasi") XSertifikasiModel sertifikasi) {
			// remove data dari database via repo
			repo.delete(sertifikasi);
			// membuat object view
			ModelAndView view = new ModelAndView("sertifikasi/delete");
			view.addObject("sertifikasi", sertifikasi);
			// redirect to index
			return view;
		}
}
