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

import com.xsis.batch197.model.XRiwayatPelatihanModel;
import com.xsis.batch197.repository.XRiwayatPelatihanRepo;

@Controller
@RequestMapping(value = "/pelatihan")
public class PelatihanController {
	private static final Logger logger = LoggerFactory.getLogger(PelatihanController.class);
	// untuk mengambil data dari database
	@Autowired
	private XRiwayatPelatihanRepo repoPela;

	@GetMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("pelatihan/index");
		return view;
	}

	@GetMapping(value = "list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("pelatihan/list");
		// load data pelatihan via repo, disimpan kedalam list
		List<XRiwayatPelatihanModel> listpelatihan = repoPela.findAll();
		// lemparkan data ke view, list objek baru, datanya listpelatihan
		view.addObject("list", listpelatihan);

		return view;
	}

	@GetMapping(value = "/add")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("pelatihan/create");
		// membuat objek pelatihan yang akan dikirim ke view
		// objeck pelatihan adalah new objek dari pelatihanmodel
		XRiwayatPelatihanModel pelatihan = new XRiwayatPelatihanModel();

		view.addObject("pelatihan", pelatihan);
		return view;
	}
	@PostMapping(value="/save")
	public ModelAndView save(@Valid @ModelAttribute("pelatihan") XRiwayatPelatihanModel pelatihan, BindingResult result) {
		logger.error("--"+pelatihan.getIsDelete());
		if (result.hasErrors()) {
			logger.info("save pelatihan error");
		} else {
			repoPela.save(pelatihan);
		}
		
		ModelAndView view = new ModelAndView("pelatihan/create");
		view.addObject("pelatihan", pelatihan);
		return view;
	}
	
	@GetMapping(value="/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		// buat objetc view
		ModelAndView view = new ModelAndView("pelatihan/update");
		// mengambil data dahulu dari database via repo
		XRiwayatPelatihanModel pelatihan = repoPela.findById(id).orElse(new XRiwayatPelatihanModel());
		// membuat object pelatihan yang akan dikirim ke view
		// object pelatihan adalah new object dari pelatihanmodel
		view.addObject("pelatihan", pelatihan);
		return view;
	}
	
	@PostMapping(value="/update")
	public ModelAndView update(@Valid @ModelAttribute("pelatihan") XRiwayatPelatihanModel pelatihan, BindingResult result) {
		if(result.hasErrors()) {
			logger.info("save pelatihan error");
		} else {
			repoPela.save(pelatihan);
		}
		
		ModelAndView view = new ModelAndView("pelatihan/update");
		view.addObject("pelatihan", pelatihan);
		return view;
	}
	
	public ModelAndView delete(@PathVariable("id") Long id) {
		//buat object view
		ModelAndView view = new ModelAndView("pelatihan/delete");
		//mengambil data dahulu dari database via rep
		XRiwayatPelatihanModel pelatihan = repoPela.findById(id).orElse(new XRiwayatPelatihanModel());
		// membuat onjek pelatihan yang akan dikiri, ke view
		// objeck pelatihan adalah new object dari pelatihanmodel
		view.addObject("pelatihan", pelatihan);
		return view;
		
	}
	@PostMapping(value = "/remove")
	public ModelAndView remove(@ModelAttribute("pelatihan") XRiwayatPelatihanModel pelatihan) {
		// remove data dari database via repo
		repoPela.delete(pelatihan);
		// membuat object view
		ModelAndView view = new ModelAndView("pelatihan/delete");
		view.addObject("pelatihan", pelatihan);
		// redirect to index
		return view;
	}
}
