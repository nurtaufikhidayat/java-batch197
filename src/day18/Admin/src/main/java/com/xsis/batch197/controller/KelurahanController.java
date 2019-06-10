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

import com.xsis.batch197.model.KecamatanModel;
import com.xsis.batch197.model.KelurahanModel;
import com.xsis.batch197.repository.KecamatanRepo;
import com.xsis.batch197.repository.KelurahanRepo;

@Controller
@RequestMapping(value="/kelurahan")
public class KelurahanController {
	private static final Logger logger = LoggerFactory.getLogger(KelurahanController.class);
	
	@Autowired
	private KelurahanRepo repo;
	
	@Autowired
	private KecamatanRepo repoKec;
	
	// method untuk generate kode kelurahan otomatis
	private String getKode() {
		String result="";
		if(repo.getMaxKode() != null) {
			result = repo.getMaxKode().split("-")[1];
			result = "PR-" + String.format("%03d",(Integer.parseInt(result))+1);
		} else {
			result = "PR-001";
		}
		return result;
	}
	
	// #1. index => list data
	@GetMapping(value ="/index")
	public ModelAndView index() {
		// buat object view
		ModelAndView view = new ModelAndView("kelurahan/index");
		return view;
	}
	
	// #1. index => list data
	@GetMapping(value="/list")
	public ModelAndView list() {
		// buat object view
		ModelAndView view = new ModelAndView("kelurahan/list");
		// load data kelurahan via repo, disimpan kedalam list
		List<KelurahanModel> listKelurahan = repo.findAll();
		// lemparkan data view, list object baru, datanua listKelurahan
		view.addObject("list", listKelurahan);
		return view;
	}
	
	// #2. membuat form add kelurahan
	@GetMapping(value="/add")
	public ModelAndView create() {
		// buat object view
		ModelAndView view = new ModelAndView("kelurahan/create");
		// membuat object kelurahan yang akan dikirim ke view
		// object kelurahan adalah new object dari KelurahanModel
		KelurahanModel kelurahan = new KelurahanModel();
		// isi kdKelurahan dengan method getKode()
		kelurahan.setKdKelurahan(getKode());
		view.addObject("kelurahan", kelurahan);
		
		// mengambil data kecamatan yang sudah ada
		List<KecamatanModel> listKec = repoKec.findAll();
		// object listKec akan kita kirim ke view, agar pilihan kecamatanId bisa terisi
		// datanya
		view.addObject("listKec", listKec);
		return view;
	}
	
	// #3. menangkap data dari form
	@PostMapping(value="/save")
	public ModelAndView save(@Valid @ModelAttribute("kelurahan") KelurahanModel kelurahan, BindingResult result) {
		if(result.hasErrors()) {
			logger.info("save kelurahan error");
		} else {
			repo.save(kelurahan);
		}
		
		ModelAndView view = new ModelAndView("kelurahan/create");
		view.addObject("kelurahan", kelurahan);
		return view;
	}
	
	//#2. membuat form add kelurahan
	@GetMapping(value="/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		// buat object view
		ModelAndView view = new ModelAndView("kelurahan/update");
		// mengambil data dahulu dari database via repository
		KelurahanModel kelurahan = repo.findById(id).orElse(new KelurahanModel());
		// membuat object kelurahan yang akan dikirim ke view
		// object kelurahan adalah new object dari KelurahanModel
		view.addObject("kelurahan", kelurahan);
		
		// mengambil data kecamatan yang sudah ada
		List<KecamatanModel> listKec = repoKec.findAll();
		// object listKec akan kita kirim ke view, agar pilihan kecamatanId bisa terisi
		// datanya
		view.addObject("listKec", listKec);
		return view;
	}
	
	//#3. menangkap data dari form
	@PostMapping(value="/update")
	public ModelAndView update(@Valid @ModelAttribute("kelurahan") KelurahanModel kelurahan, BindingResult result) {
		if(result.hasErrors()) {
			logger.info("save kelurahan error");
		} else {
			repo.save(kelurahan);
		}
		
		ModelAndView view = new ModelAndView("kelurahan/update");
		view.addObject("kelurahan", kelurahan);
		return view;
	}
	
	// #4. membuat form add kelurahan
	@GetMapping(value="/detail/{id}")
	public ModelAndView detail(@PathVariable("id") Long id) {
		// buat object view
		ModelAndView view = new ModelAndView("kelurahan/detail");
		// mengambil data dahulu dari database via repository
		KelurahanModel kelurahan = repo.findById(id).orElse(new KelurahanModel());
		// membuat object kelurahan yang akan dikirim ke  view
		// object kelurahan adalah new object dari KelurahanModel
		view.addObject("kelurahan", kelurahan);
		return view;
	}
	
	// #4. menangkap data dari dari form 
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		// buat object view
		ModelAndView view = new ModelAndView("kelurahan/delete");
		// mengambil data dahulu dari database via repository
		KelurahanModel kelurahan = repo.findById(id).orElse(new KelurahanModel());
		// membuat object kelurahan yang akan dikirim ke  view
		// object kelurahan adalah new object dari KelurahanModel
		view.addObject("kelurahan", kelurahan);
		return view;
	}
	
	// #3. menangkap data dari form
	@PostMapping(value="/remove")
	public ModelAndView remove(@ModelAttribute("kelurahan") KelurahanModel kelurahan) {
		// remove data dari database via repo
		repo.delete(kelurahan);
		// membuat object view
		ModelAndView view = new ModelAndView("kelurahan/delete");
		view.addObject("kelurahan", kelurahan);
		// redirect to index
		return view;
	}
}
