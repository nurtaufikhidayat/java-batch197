package com.xsis.batch197.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import com.xsis.batch197.model.XOrganisasiModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XOrganisasiRepo;

@Controller
public class OrganisasiController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(OrganisasiController.class);

	@Autowired
	private XBiodataRepo bioRepo;

	@Autowired
	private XOrganisasiRepo sertRepo;

	@GetMapping(value = "/pelamar/organisasi/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("organisasi/index");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);

		// get organisasi
		List<XOrganisasiModel> listorganisasi = this.sertRepo.findActiveByBiodataId(biodataId);
		view.addObject("listorganisasi", listorganisasi);
		return view;
	}

	@GetMapping(value = "/organisasi/add/{bid}") // bid sebagai vaiable biodataId
	public ModelAndView create(@PathVariable("bid") Long biodataId) {
		// menampilkan view dari folder organisasi file _form.html
		ModelAndView view = new ModelAndView("organisasi/_form");
		// membuat object organisasi model
		XOrganisasiModel organisasi = new XOrganisasiModel();
		// set biodata id
		organisasi.setBiodataId(biodataId);

		Calendar date = new GregorianCalendar();
		Integer currentYear = date.get(Calendar.YEAR);

		List<Integer> listStartYear = new ArrayList<Integer>();
		for (int i = currentYear - 20; i <= currentYear; i++) {
			listStartYear.add(i);
		}
		// add object organisasi
		view.addObject("organisasi", organisasi);
		// add object tahun start
		view.addObject("listStartYear", listStartYear);
		return view;
	}

	@PostMapping(value = "/organisasi/save")
	public ModelAndView save(@Valid @ModelAttribute("organisasi") XOrganisasiModel organisasi, BindingResult result) {
		// menampilkan view dari folder organisasi file _form.html
		ModelAndView view = new ModelAndView("organisasi/_form");

		Calendar date = new GregorianCalendar();
		Integer currentYear = date.get(Calendar.YEAR);

		List<Integer> listStartYear = new ArrayList<Integer>();
		for (int i = currentYear - 20; i <= currentYear; i++) {
			listStartYear.add(i);
		}
		// add object tahun start
		view.addObject("listStartYear", listStartYear);
		if (result.hasErrors()) {
			logger.info("save biodata error");

			// add object organisasi dengan error nya ke view
			view.addObject("organisasi", organisasi);
		} else {
			// set user id
			organisasi.setCreatedBy(this.getAbuid());
			organisasi.setCreatedOn(new Date());
			// simpan ke repo
			sertRepo.save(organisasi);
			// add object baru tanpa error
			view.addObject("organisasi", new XOrganisasiModel());
		}
		return view;
	}

	@GetMapping(value = "/organisasi/list/{bid}")
	private ModelAndView list(@PathVariable("bid") Long biodataId) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("organisasi/_list");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);

		// get organisasi
		List<XOrganisasiModel> listorganisasi = this.sertRepo.findActiveByBiodataId(biodataId);
		view.addObject("listorganisasi", listorganisasi);
		return view;
	}

	@GetMapping(value = "/organisasi/hapus/{sid}")
	private ModelAndView hapus(@PathVariable("sid") Long sid) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("organisasi/_hapus");
		// get organisasi
		XOrganisasiModel organisasi = this.sertRepo.findById(sid).orElse(null);
		view.addObject("organisasi", organisasi);
		return view;
	}

	@PostMapping(value = "/organisasi/remove")
	private ModelAndView remove(@ModelAttribute("organisasi") XOrganisasiModel organisasi) {
		// get organisasi
		XOrganisasiModel item = this.sertRepo.findById(organisasi.getId()).orElse(null);
		
		// set delete
		item.setIsDelete(1);
		this.sertRepo.save(item);

		// view sertifkasi
		ModelAndView view = new ModelAndView("organisasi/_hapus");
		view.addObject("organisasi", item);
		return view;
	}

	@GetMapping(value = "/organisasi/ubah/{sid}") // bid sebagai vaiable biodataId
	public ModelAndView edit(@PathVariable("sid") Long sid) {
		// menampilkan view dari folder organisasi file _form.html
		ModelAndView view = new ModelAndView("organisasi/_form");
		// membuat object organisasi model
		XOrganisasiModel organisasi = this.sertRepo.findById(sid).orElse(null);

		Calendar date = new GregorianCalendar();
		Integer currentYear = date.get(Calendar.YEAR);
		List<Integer> listStartYear = new ArrayList<Integer>();
		for (int i = currentYear - 20 ; i <= currentYear; i++) {
		listStartYear.add(i);
		}
		// add object organisasi
		view.addObject("organisasi", organisasi);
		// add object tahun start
		view.addObject("listStartYear", listStartYear);
		return view;
	}
}