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

import com.xsis.batch197.model.ProvinsiModel;
import com.xsis.batch197.repository.ProvinsiRepo;

@Controller
@RequestMapping(value="/provinsi")
public class ProvinsiController {
	private static final Logger logger = LoggerFactory.getLogger(ProvinsiController.class);

	@Autowired
	private ProvinsiRepo repo;

	// method untuk generate kode provinsi otomatis
	private  String getKode() {
		String result ="";
		if (repo.getMaxKode() !=null) {
			result = repo.getMaxKode().split("-")[1];
			result = "PR-" + String.format("%03d", (Integer.parseInt(result)+ 1));
		} else {
			result = "PR-001";
		}
		return result;
	}
	
	// #1. index => list data
	@GetMapping(value = "/index")
	public ModelAndView index() {
		// buat object view
		ModelAndView view = new ModelAndView("provinsi/index");
		return view;
	}

	// #1. index => list data
	@GetMapping(value = "/list")
	public ModelAndView list() {
		// buat object view
		ModelAndView view = new ModelAndView("provinsi/list");
		// load data provinsi via repo, disimpan kedalam list
		List<ProvinsiModel> listprovinsi = repo.findAll();
		// lemparkan data ke view, list object baru, datanya listprovinsi
		view.addObject("list", listprovinsi);
		return view;
	}

	// #2. Membuat Form Add provinsi
	@GetMapping(value = "/add")
	public ModelAndView create() {
		// buat object view
		ModelAndView view = new ModelAndView("provinsi/create");
		// membuat object provinsi yg akan dikirim ke view
		// object provinsi adalah new object dari ProvinsiModel
		ProvinsiModel provinsi = new ProvinsiModel();
		// isi kdProvinsi dengan method getKode()
		provinsi.setKdProvinsi(getKode());
		view.addObject("provinsi", provinsi);
		return view;
	}

	// #3. Menangkap data dari form
	@PostMapping(value = "/save")
	public ModelAndView save(@Valid @ModelAttribute("provinsi") ProvinsiModel provinsi, BindingResult result) {
		if (result.hasErrors()) {
			logger.info("save provinsi error");
		}else {
			repo.save(provinsi);
		}
		
		ModelAndView view = new ModelAndView("provinsi/create");
		view.addObject("provinsi", provinsi);
		return view;
	}

	// #2. Membuat Form Add provinsi
	@GetMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		// buat object view
		ModelAndView view = new ModelAndView("provinsi/update");
		// mengambil data dahulu dari database via repository
		ProvinsiModel provinsi = repo.findById(id).orElse(new ProvinsiModel());
		// membuat object provinsi yg akan dikirim ke view
		// object provinsi adalah new object dari ProvinsiModel
		view.addObject("provinsi", provinsi);
		return view;
	}

	// #3. Menangkap data dari form
	@PostMapping(value = "/update")
	public ModelAndView update(@Valid @ModelAttribute("provinsi") ProvinsiModel provinsi, BindingResult result) {
		if (result.hasErrors()) {
			logger.info("save provinsi error");
		}else {
			repo.save(provinsi);
		}
		
		ModelAndView view = new ModelAndView("provinsi/update");
		view.addObject("provinsi", provinsi);
		return view;
	}

	// #4. Membuat Form Add provinsi
	@GetMapping(value = "/detail/{id}")
	public ModelAndView detail(@PathVariable("id") Long id) {
		// buat object view
		ModelAndView view = new ModelAndView("provinsi/detail");
		// mengambil data dahulu dari database via repository
		ProvinsiModel provinsi = repo.findById(id).orElse(new ProvinsiModel());
		// membuat object provinsi yg akan dikirim ke view
		// object provinsi adalah new object dari ProvinsiModel
		view.addObject("provinsi", provinsi);
		return view;
	}

	// #4. Membuat Form Add provinsi
	@GetMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		// buat object view
		ModelAndView view = new ModelAndView("provinsi/delete");
		// mengambil data dahulu dari database via repository
		ProvinsiModel provinsi = repo.findById(id).orElse(new ProvinsiModel());
		// membuat object provinsi yg akan dikirim ke view
		// object provinsi adalah new object dari ProvinsiModel
		view.addObject("provinsi", provinsi);
		return view;
	}

	// #3. Menangkap data dari form
	@PostMapping(value = "/remove")
	public ModelAndView remove(@ModelAttribute("provinsi") ProvinsiModel provinsi) {
		// remove data dari database via repo
		repo.delete(provinsi);
		// membuat object view
		ModelAndView view = new ModelAndView("provinsi/delete");
		view.addObject("provinsi", provinsi);
		// redirect to index
		return view;
	}
}
