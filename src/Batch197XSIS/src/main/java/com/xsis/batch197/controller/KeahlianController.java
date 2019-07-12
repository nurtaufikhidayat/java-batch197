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
import com.xsis.batch197.model.XKeahlianModel;
import com.xsis.batch197.model.XSkillLevelModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XKeahlianRepo;
import com.xsis.batch197.repository.XSkillLevelRepo;

@Controller
public class KeahlianController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(KeahlianController.class);

	@Autowired
	private XBiodataRepo bioRepo;

	@Autowired
	private XKeahlianRepo keahlianRepo;

	@Autowired
	private XSkillLevelRepo skillRepo;

	@GetMapping(value = "/pelamar/keahlian/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view keahlian
		ModelAndView view = new ModelAndView("keahlian/index");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);
		// get keahlian
		List<XKeahlianModel> listKeahlian = this.keahlianRepo.findActiveByBiodataId(biodataId);
		view.addObject("listKeahlian", listKeahlian);

		return view;
	}

	// Method Button Add
	@GetMapping(value = "/keahlian/add/{bid}") // bid ini sebagai variable dari biodataId
	public ModelAndView create(@PathVariable("bid") Long biodataId) {
		// menampilkan view dari folder keahlian file _create.html
		ModelAndView view = new ModelAndView("keahlian/_create");
		// membuat object keahlian yang akan dikirim ke view
		// object "keahlian" adalah new object dari XKeahlianModel
		XKeahlianModel keahlian = new XKeahlianModel();
		// set biodata id nya
		keahlian.setBiodataId(biodataId);
		// add object keahlian
		view.addObject("keahlian", keahlian);

		// mengambil data level skill yang sudah ada
		List<XSkillLevelModel> listSkill = skillRepo.findAll();
		// object dari listSKill akan dikirim ke view, agar pilihan SkillLevelId bisa
		// terisi datanya
		view.addObject("listSkill", listSkill);

		return view;
	}

	// Method simpan data
	@PostMapping(value = "/keahlian/save")
	public ModelAndView save(@Valid @ModelAttribute("keahlian") XKeahlianModel keahlian, BindingResult result) {
		// menampilkan view dari folder keahlian _create.html
		ModelAndView view = new ModelAndView("keahlian/_create");

		if (result.hasErrors()) {
			logger.info("Save Keahlian Error!");
			// add object keahlian beserta errornya ke view
			view.addObject("keahlian", keahlian);
		} else {
			// set userId
			keahlian.setCreatedBy(this.getAbuid());
			keahlian.setCreatedOn(new Date());
			// simpan ke repo
			keahlianRepo.save(keahlian);
			// add object baru tanpa error
			view.addObject("keahlian", new XKeahlianModel());
		}
		return view;
	}

	// menampilkan list data keahlian
	@GetMapping(value = "/keahlian/list/{bid}")
	private ModelAndView list(@PathVariable("bid") Long biodataId) {
		// view keahlian
		ModelAndView view = new ModelAndView("keahlian/_list");
		// get biodataId
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);

		// get keahlian
		List<XKeahlianModel> listKeahlian = this.keahlianRepo.findActiveByBiodataId(biodataId);
		view.addObject("listKeahlian", listKeahlian);
		return view;
	}

	// hapus data keahlian
	@GetMapping(value = "/keahlian/hapus/{kid}")
	private ModelAndView hapus(@PathVariable("kid") Long kid) {
		// buat object view
		ModelAndView view = new ModelAndView("keahlian/_hapus");
		// mengambil data keahlian dari database via repository
		XKeahlianModel keahlian = this.keahlianRepo.findById(kid).orElse(null);
		view.addObject("keahlian", keahlian);
		return view;
	}

	@PostMapping(value = "/keahlian/remove")
	private ModelAndView remove(@ModelAttribute("keahlian") XKeahlianModel keahlian) {
		// get keahlian
		XKeahlianModel item = this.keahlianRepo.findById(keahlian.getId()).orElse(null);
		item.setIsDelete(1);
		this.keahlianRepo.save(item);

		// view keahlian
		ModelAndView view = new ModelAndView("keahlian/_hapus");
		view.addObject("keahlian", item);
		return view;
	}

	// edit keahlian
	@GetMapping(value = "/keahlian/ubah/{kid}")
	public ModelAndView edit(@PathVariable("kid") Long kid) {
		// view edit
		ModelAndView view = new ModelAndView("keahlian/_create");
		// mengambil data dahulu dari database via repository
		XKeahlianModel keahlian = this.keahlianRepo.findById(kid).orElse(null);
		view.addObject("keahlian", keahlian);

		// mengambil data level skill yang sudah dipilih
		List<XSkillLevelModel> listSkill = this.skillRepo.findAll();
		// object dari listSKill akan dikirim ke view, agar pilihan SkillLevelId bisa
		// terisi datanya
		view.addObject("listSkill", listSkill);

		return view;
	}

}
