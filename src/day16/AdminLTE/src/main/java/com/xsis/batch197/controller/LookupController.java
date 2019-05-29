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

import com.xsis.batch197.model.LookupModel;
import com.xsis.batch197.repository.LookupRepo;

@Controller
@RequestMapping(value="/lookup")
public class LookupController {
	private static final Logger logger = LoggerFactory.getLogger(LookupController.class);

	@Autowired
	private LookupRepo repo;

	// #1. index => list data
	@GetMapping(value = "/index")
	public ModelAndView index() {
		// buat object view
		ModelAndView view = new ModelAndView("lookup/index");
		// load data lookup via repo, disimpan kedalam list
		List<LookupModel> listLookup = repo.findAll();
		// lemparkan data ke view, list object baru, datanya listLookup
		view.addObject("list", listLookup);
		return view;
	}

	// #2. Membuat Form Add lookup
	@GetMapping(value = "/add")
	public ModelAndView create() {
		// buat object view
		ModelAndView view = new ModelAndView("lookup/create");
		// membuat object lookup yg akan dikirim ke view
		// object lookup adalah new object dari LookupModel
		view.addObject("lookup", new LookupModel());
		return view;
	}

	// #3. Menangkap data dari form
	@PostMapping(value = "/save")
	public ModelAndView save(@Valid @ModelAttribute("lookup") LookupModel lookup, BindingResult result) {
		// buat object view
		ModelAndView view = new ModelAndView();
		if (result.hasErrors()) {
			logger.info("save lookup error");
			view.setViewName("lookup/create");
			view.addObject("lookup", lookup);
			return view;
		}
		// jika tidak ada error
		repo.save(lookup);
		view.setViewName("lookup/index");
		// redirect to index
		return new ModelAndView("redirect:/lookup/index");
	}

	// #2. Membuat Form Add lookup
	@GetMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		// buat object view
		ModelAndView view = new ModelAndView("lookup/update");
		// mengambil data dahulu dari database via repository
		LookupModel lookup = repo.findById(id).orElse(new LookupModel());
		// membuat object lookup yg akan dikirim ke view
		// object lookup adalah new object dari LookupModel
		view.addObject("lookup", lookup);
		return view;
	}

	// #3. Menangkap data dari form
	@PostMapping(value = "/update")
	public ModelAndView update(@Valid @ModelAttribute("lookup") LookupModel lookup, BindingResult result) {
		// buat object view
		ModelAndView view = new ModelAndView();
		if (result.hasErrors()) {
			logger.info("save lookup error");
			view.setViewName("lookup/update");
			view.addObject("lookup", lookup);
			return view;
		}
		// jika tidak ada error
		repo.save(lookup);
		view.setViewName("lookup/index");
		// redirect to index
		return new ModelAndView("redirect:/lookup/index");
	}

	// #4. Membuat Form Add lookup
	@GetMapping(value = "/detail/{id}")
	public ModelAndView detail(@PathVariable("id") Long id) {
		// buat object view
		ModelAndView view = new ModelAndView("lookup/detail");
		// mengambil data dahulu dari database via repository
		LookupModel lookup = repo.findById(id).orElse(new LookupModel());
		// membuat object lookup yg akan dikirim ke view
		// object lookup adalah new object dari LookupModel
		view.addObject("lookup", lookup);
		return view;
	}

	// #4. Membuat Form Add lookup
	@GetMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		// buat object view
		ModelAndView view = new ModelAndView("lookup/delete");
		// mengambil data dahulu dari database via repository
		LookupModel lookup = repo.findById(id).orElse(new LookupModel());
		// membuat object lookup yg akan dikirim ke view
		// object lookup adalah new object dari LookupModel
		view.addObject("lookup", lookup);
		return view;
	}

	// #3. Menangkap data dari form
	@PostMapping(value = "/remove")
	public ModelAndView remove(@ModelAttribute("lookup") LookupModel lookup) {
		// buat object view
		ModelAndView view = new ModelAndView();
		// jika tidak ada error
		repo.delete(lookup);
		view.setViewName("lookup/index");
		// redirect to index
		return new ModelAndView("redirect:/lookup/index");
	}
}