package com.xsis.batch197.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XPelamarPagingRepo;

@Controller
@RequestMapping(value = "/pelamar")
public class PelamarController {

	@Autowired
	private XBiodataRepo repoBio;

	@Autowired
	private XPelamarPagingRepo repoPaging;

	@GetMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("pelamar/index");
		return view;
	}

	// Method Button Add
	@GetMapping(value = "/add")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("pelamar/create");
		XBiodataModel pelamar = new XBiodataModel();
		view.addObject("pelamar", pelamar);
		return view;
	}

	// Method List data saat load pelamar/index
	@GetMapping(value = "/list")
	public ModelAndView list(@PageableDefault(size = 10) Pageable pageable) {
		ModelAndView view = new ModelAndView("pelamar/list");
		Page<XBiodataModel> listPelamar = repoPaging.findAll(pageable);
		view.addObject("list", listPelamar);
		return view;
	}

	// Method untuk button paging
//	@GetMapping(value = "/list/{urlVal}")
//	public ModelAndView paging(@PageableDefault(size = 10) Pageable pageable) {
//		ModelAndView view = new ModelAndView("pelamar/list");
//		// load data pelamar via repo, disimpan kedalam list
//		Page<XBiodataModel> listPelamar = repoPaging.findAll(pageable);
//		// lemparkan data ke view, list object baru
//		view.addObject("list", listPelamar);
//		return view;
//	}

	// Method untuk button search
	@GetMapping(value = "/list/{key}")
	public ModelAndView list(@PathVariable("key") String key, @PageableDefault(size=10) Pageable pageable) {
		ModelAndView view = new ModelAndView("pelamar/list");
		// load data pelamar via repo, disimpan kedalam list
		Page<XBiodataModel> listPelamar = repoPaging.search(key,pageable);
		// lemparkan data ke view, list object baru
		view.addObject("list", listPelamar);
		return view;
	}

	// Method untuk menampilkan isi modal pelamar
	@GetMapping(value = "/detail/{id}")
	public ModelAndView detail(@PathVariable("id") Long id) {
		// buat object view
		ModelAndView view = new ModelAndView("pelamar/detail");
		// mengambil data dahulu dari database via repository
		XBiodataModel pelamar = repoBio.findById(id).orElse(new XBiodataModel());
		view.addObject("pelamar", pelamar);
		return view;
	}

}
