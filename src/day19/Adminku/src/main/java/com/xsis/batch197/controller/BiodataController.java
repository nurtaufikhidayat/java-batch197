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

import com.xsis.batch197.model.BiodataModel;
import com.xsis.batch197.repository.BiodataRepo;

@Controller
@RequestMapping(value="/biodata")
public class BiodataController {
	private static final Logger logger = LoggerFactory.getLogger(BiodataController.class);

	@Autowired
	private BiodataRepo repo;

	// #1. index => list data
	@GetMapping(value = "/index")
	public ModelAndView index() {
		// buat object view
		ModelAndView view = new ModelAndView("biodata/index");
		return view;
	}

	// #1. index => list data
	@GetMapping(value = "/list")
	public ModelAndView list() {
		// buat object view
		ModelAndView view = new ModelAndView("biodata/list");
		// load data biodata via repo, disimpan kedalam list
		List<BiodataModel> listbiodata = repo.findAll();
				// lemparkan data ke view, list object baru, datanya listbiodata
		view.addObject("list", listbiodata);
		return view;
	}

	@GetMapping(value = "/list/{key}")
	public ModelAndView list(@PathVariable("key") String key) {
		// buat object view
		ModelAndView view = new ModelAndView("biodata/list");
		// load data biodata via repo, disimpan kedalam list
		List<BiodataModel> listbiodata = repo.search(key);
		// lemparkan data ke view, list object baru, datanya listbiodata
		view.addObject("list", listbiodata);
		return view;
	}

	// #2. Membuat Form Add biodata
	@GetMapping(value = "/add")
	public ModelAndView create() {
		// buat object view
		ModelAndView view = new ModelAndView("biodata/create");
		// membuat object biodata yg akan dikirim ke view
		// object biodata adalah new object dari BiodataModel
		BiodataModel biodata = new BiodataModel();
		view.addObject("biodata", biodata);
		return view;
	}

	// #3. Menangkap data dari form
	@PostMapping(value = "/save")
	public ModelAndView save(@Valid @ModelAttribute("biodata") BiodataModel biodata, BindingResult result) {
		if (result.hasErrors()) {
			logger.info("save biodata error");
		} else {
			repo.save(biodata);
		}

		ModelAndView view = new ModelAndView("biodata/create");
		view.addObject("biodata", biodata);
		return view;
	}

	// #2. Membuat Form Add biodata
	@GetMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		// buat object view
		ModelAndView view = new ModelAndView("biodata/update");
		// mengambil data dahulu dari database via repository
		BiodataModel biodata = repo.findById(id).orElse(new BiodataModel());
		// membuat object biodata yg akan dikirim ke view
		// object biodata adalah new object dari BiodataModel
		view.addObject("biodata", biodata);
		return view;
	}

	// #3. Menangkap data dari form
	@PostMapping(value = "/update")
	public ModelAndView update(@Valid @ModelAttribute("biodata") BiodataModel biodata, BindingResult result) {
		if (result.hasErrors()) {
			logger.info("save biodata error");
		} else {
			repo.save(biodata);
		}

		ModelAndView view = new ModelAndView("biodata/update");
		view.addObject("biodata", biodata);
		return view;
	}

	// #4. Membuat Form Add biodata
	@GetMapping(value = "/detail/{id}")
	public ModelAndView detail(@PathVariable("id") Long id) {
		// buat object view
		ModelAndView view = new ModelAndView("biodata/detail");
		// mengambil data dahulu dari database via repository
		BiodataModel biodata = repo.findById(id).orElse(new BiodataModel());
		// membuat object biodata yg akan dikirim ke view
		// object biodata adalah new object dari BiodataModel
		view.addObject("biodata", biodata);
		return view;
	}

	// #4. Membuat Form Add biodata
	@GetMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		// buat object view
		ModelAndView view = new ModelAndView("biodata/delete");
		// mengambil data dahulu dari database via repository
		BiodataModel biodata = repo.findById(id).orElse(new BiodataModel());
		// membuat object biodata yg akan dikirim ke view
		// object biodata adalah new object dari BiodataModel
		view.addObject("biodata", biodata);
		return view;
	}

	// #3. Menangkap data dari form
	@PostMapping(value = "/remove")
	public ModelAndView remove(@ModelAttribute("biodata") BiodataModel biodata) {
		// remove data dari database via repo
		repo.delete(biodata);
		// membuat object view
		ModelAndView view = new ModelAndView("biodata/delete");
		view.addObject("biodata", biodata);
		// redirect to index
		return view;
	}
}
