package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XRiwayatPendidikanModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XPelamarPagingRepo;
import com.xsis.batch197.repository.XRiwayatPendidikanRepo;

@Controller
@RequestMapping(value = "/pelamar")
public class PelamarController {

	@Autowired
	private XBiodataRepo repoBio;

	@Autowired
	private XPelamarPagingRepo repoPaging;
	
	@Autowired
	private XRiwayatPendidikanRepo repoRiwpend;

	@GetMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("pelamar/index");
		return view;
	}

	// Method Button Add
	@GetMapping(value = "/add")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("pelamar/_create");
		XBiodataModel pelamar = new XBiodataModel();
		view.addObject("pelamar", pelamar);
		return view;
	}

	// Method untuk button search
	@GetMapping(value = "/list/{key}")
	public ModelAndView list(@PathVariable("key") String key, @PageableDefault(size = 10) Pageable pageable) {
		ModelAndView view = new ModelAndView("pelamar/_item");

		List<XRiwayatPendidikanModel> listPend = repoRiwpend.findAll();
		view.addObject("listPend", listPend);

		Page<XBiodataModel> listPelamar = repoPaging.search(key, pageable);
		view.addObject("list", listPelamar);
		return view;
	}

	// Method Search with Pagination
	@GetMapping(value = "/search")
	public ModelAndView search(@RequestParam("key") String key, Pageable pageable) {
		ModelAndView view = new ModelAndView("pelamar/_item");

		List<XRiwayatPendidikanModel> listPend = repoRiwpend.findAll();
		view.addObject("listPend", listPend);

		Page<XBiodataModel> listPelamar = repoPaging.search(key, pageable);
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
