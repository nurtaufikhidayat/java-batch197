package com.xsis.batch197.controller;

import java.util.Date;
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
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XEducationLevelModel;
import com.xsis.batch197.model.XFamilyRelationModel;
import com.xsis.batch197.model.XFamilyTreeTypeModel;
import com.xsis.batch197.model.XKeluargaModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XEducationLevelRepo;
import com.xsis.batch197.repository.XFamilyRelationRepo;
import com.xsis.batch197.repository.XFamilyTreeTypeRepo;
import com.xsis.batch197.repository.XKeluargaRepo;

@Controller
public class KeluargaController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(KeluargaController.class);

	@Autowired
	private XBiodataRepo bioRepo;

	@Autowired
	private XKeluargaRepo kelRepo;

	@Autowired
	private XFamilyTreeTypeRepo familytreetypeRepo;

	@Autowired
	private XFamilyRelationRepo familyrelationRepo;

	@Autowired
	private XEducationLevelRepo pendRepo;

	@GetMapping(value = "/pelamar/keluarga/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view keluarga
		ModelAndView view = new ModelAndView("keluarga/index");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);
		// get Keluarga
		List<XKeluargaModel> listKeluarga = this.kelRepo.findActiveByBiodataId(biodataId);
		view.addObject("listKeluarga", listKeluarga);
		return view;
	}

	// Method Button Add
	@GetMapping(value = "/keluarga/add/{bid}") // bid ini sebagai variable dari biodataId
	public ModelAndView create(@PathVariable("bid") Long biodataId) {
		// menampilkan view dari folder keahlian file _form.html
		ModelAndView view = new ModelAndView("keluarga/_form");
		// membuat object keahlian yang akan dikirim ke view
		// object "keluarga" adalah new object dari XKeluargaModel
		XKeluargaModel keluarga = new XKeluargaModel();
		// set biodata id nya
		keluarga.setBiodataId(biodataId);
		// add object keahlian
		view.addObject("keluarga", keluarga);

		// mengambil data susunan keluarga yang sudah ada
		List<XFamilyTreeTypeModel> listSusunan = familytreetypeRepo.findAll();
		// object dari listSusunan akan dikirim ke view, agar pilihan familyTreeTyeId
		// bisa terisi datanya
		view.addObject("listSusunan", listSusunan);

		// mengambil data hubungan keluarga yang sudah ada
		List<XFamilyRelationModel> listHubungan = familyrelationRepo.findAll();
		// object dari listHubungan akan dikirim ke view, agar pilihan familyRelationId
		// bisa terisi datanya
		view.addObject("listHubungan", listHubungan);

		// mengambil data hubungan level pendidikan yang sudah ada
		List<XEducationLevelModel> listPend = pendRepo.findAll();
		// object dari listPend akan dikirim ke view, agar pilihan educationLevelId
		// bisa terisi datanya
		view.addObject("listPend", listPend);

		return view;
	}

	// simpan data keluarga
	// Method simpan data
	@PostMapping(value = "/keluarga/save")
	public ModelAndView save(@Valid @ModelAttribute("keluarga") XKeluargaModel keluarga, BindingResult result) {
		// menampilkan view dari folder keahlian _form.html
		ModelAndView view = new ModelAndView("keluarga/_form");

		if (result.hasErrors()) {
			logger.info("Save Keluarga Error!");
			// add object keluarga beserta errornya ke view
			view.addObject("keluarga", keluarga);
		} else {
			// set userId
			keluarga.setCreatedBy(this.getAbuid());
			keluarga.setCreatedOn(new Date());
			// simpan ke repo
			kelRepo.save(keluarga);
			// add object baru tanpa error
			view.addObject("keluarga", new XKeluargaModel());
		}
		return view;
	}

	// menampilkan list data keluarga
	@GetMapping(value = "/keluarga/list/{bid}")
	private ModelAndView list(@PathVariable("bid") Long biodataId) {
		// view data keluarga
		ModelAndView view = new ModelAndView("keluarga/_list");
		// get biodataId
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);

		// get data keluarga
		List<XKeluargaModel> listKeluarga = this.kelRepo.findActiveByBiodataId(biodataId);
		view.addObject("listKeluarga", listKeluarga);

		return view;
	}

	// hapus data Keluarga
	@GetMapping(value = "/keluarga/hapus/{kid}")
	private ModelAndView hapus(@PathVariable("kid") Long kid) {
		// view data keluarga
		ModelAndView view = new ModelAndView("keluarga/_hapus");
		// get data keluarga
		XKeluargaModel keluarga = this.kelRepo.findById(kid).orElse(null);
		view.addObject("keluarga", keluarga);
		return view;
	}

	@PostMapping(value = "/keluarga/remove")
	private ModelAndView remove(@ModelAttribute("keluarga") XKeluargaModel keluarga) {
		// get data keluarga
		XKeluargaModel item = this.kelRepo.findById(keluarga.getId()).orElse(null);
		item.setIsDelete(1);
		this.kelRepo.save(item);
		// view data keahlian
		ModelAndView view = new ModelAndView("keluarga/_hapus");
		view.addObject("keluarga", item);
		return view;
	}

	// ubah data keluarga
	@GetMapping(value = "/keluarga/ubah/{kid}")
	public ModelAndView edit(@PathVariable("kid") Long kid) {
		// view edit
		ModelAndView view = new ModelAndView("keluarga/_form");
		// mengambil data dahulu dari database via repository
		XKeluargaModel keluarga = this.kelRepo.findById(kid).orElse(null);
		view.addObject("keluarga", keluarga);

		// mengambil data susunan keluarga yang sudah ada
		List<XFamilyTreeTypeModel> listSusunan = familytreetypeRepo.findAll();
		// object dari listSusunan akan dikirim ke view, agar pilihan familyTreeTyeId
		// bisa terisi datanya
		view.addObject("listSusunan", listSusunan);

		// mengambil data hubungan keluarga yang sudah ada
		List<XFamilyRelationModel> listHubungan = familyrelationRepo.findAll();
		// object dari listHubungan akan dikirim ke view, agar pilihan familyRelationId
		// bisa terisi datanya
		view.addObject("listHubungan", listHubungan);

		// mengambil data hubungan level pendidikan yang sudah ada
		List<XEducationLevelModel> listPend = pendRepo.findAll();
		// object dari listPend akan dikirim ke view, agar pilihan educationLevelId
		// bisa terisi datanya
		view.addObject("listPend", listPend);

		return view;
	}
}
