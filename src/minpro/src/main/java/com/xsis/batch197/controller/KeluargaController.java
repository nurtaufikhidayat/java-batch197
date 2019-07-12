package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XFamilyTreeTypeModel;
import com.xsis.batch197.model.XKeluargaModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XFamilyRelationRepo;
import com.xsis.batch197.repository.XFamilyTreeTypeRepo;
import com.xsis.batch197.repository.XKeluargaRepo;

@Controller
public class KeluargaController extends BaseController {
	@Autowired
	private XBiodataRepo bioRepo;

	@Autowired
	private XKeluargaRepo kelRepo;

	@Autowired
	private XFamilyTreeTypeRepo susunanRepo;

	@Autowired
	private XFamilyRelationRepo hubunganRepo;

	@GetMapping(value = "/pelamar/keluarga/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view keluarga
		ModelAndView view = new ModelAndView("keluarga/index");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);

		// get Keluarga
		List<XKeluargaModel> listKeluarga = this.kelRepo.findByBiodataId(biodataId);
		view.addObject("listKeluarga", listKeluarga);
		return view;
	}

	// Method Button Add
	@GetMapping(value = "/keluarga/add/{bid}") // bid ini sbg variable dari biodataId
	public ModelAndView create(@PathVariable("bid") Long biodataId) {
		// menampilkan view dari folder keluarga file _create.html
		ModelAndView view = new ModelAndView("keluarga/_create");
		// membuat object keluarga model
		XKeluargaModel keluarga = new XKeluargaModel();
		// set biodata id nya
		keluarga.setBiodataId(biodataId);
		// add object keluarga
		view.addObject("keluarga", keluarga);

		// mengambil data susunan keluarga yang sudah ada
		//List<XFamilyTreeTypeModel> listSusunan = susunanRepo.findAll();
		// object dari listSusunan akan dikirim ke view, agar pilihan FamilyTreeTypeId
		// bisa terisi datanya
		//view.addObject("listSusunan", listSusunan);

		// mengambil data hubungan keluarga yang sudah ada
		//<XFamilyRelationRepo> listHubungan = hubunganRepo.findAll();
		// object dari listHubungan akan dikirim ke view, agar pilihan FamilyTreeRelationId
		// bisa terisi datanya
		//view.addObject("listHubungan", listHubungan);

		return view;
	}
}
