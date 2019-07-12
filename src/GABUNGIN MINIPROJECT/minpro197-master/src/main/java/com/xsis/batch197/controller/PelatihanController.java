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
import com.xsis.batch197.model.XRiwayatPelatihanModel;
import com.xsis.batch197.model.XTimePeriodeModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XRiwayatPelatihanRepo;
import com.xsis.batch197.repository.XTimePeriodeRepo;

@Controller
public class PelatihanController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(PelatihanController.class);

	@Autowired
	private XBiodataRepo bioRepo;
	
	@Autowired
	private XTimePeriodeRepo timeRepo;

	@Autowired
	private XRiwayatPelatihanRepo pelRepo;

	@GetMapping(value = "/pelamar/pelatihan/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("pelatihan/index");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);

		// get pelatihan
		List<XRiwayatPelatihanModel> listpelatihan = this.pelRepo.findActiveByBiodataId(biodataId);
		view.addObject("listpelatihan", listpelatihan);
		return view;
	}

	@GetMapping(value = "/pelatihan/add/{bid}") // bid sebagai vaiable biodataId
	public ModelAndView create(@PathVariable("bid") Long biodataId) {
		// menampilkan view dari folder pelatihan file _create.html
		ModelAndView view = new ModelAndView("pelatihan/_create");
		// membuat object pelatihan model
		XRiwayatPelatihanModel pelatihan = new XRiwayatPelatihanModel();
		// set biodata id
		pelatihan.setBiodataId(biodataId);

		Calendar date = new GregorianCalendar();
		Integer currentYear = date.get(Calendar.YEAR);
		List<Integer> listBulan = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			listBulan.add(i);
		}

		List<Integer> listStartYear = new ArrayList<Integer>();
		for (int i = currentYear - 20; i <= currentYear; i++) {
			listStartYear.add(i);
		}

		List<XTimePeriodeModel> listTime = this.timeRepo.findAll();
		// add object pelatihan
		view.addObject("pelatihan", pelatihan);
		// add object list mothn
		view.addObject("listBulan", listBulan);
		// add object tahun start
		view.addObject("listStartYear", listStartYear);
		// add object listTime
		view.addObject("listTime", listTime);
		return view;
	}

	@PostMapping(value = "/pelatihan/save")
	public ModelAndView save(@Valid @ModelAttribute("pelatihan") XRiwayatPelatihanModel pelatihan,
			BindingResult result) {
		// menampilkan view dari folder pelatihan file _create.html
		ModelAndView view = new ModelAndView("pelatihan/_create");

		if (result.hasErrors()) {
			logger.info("save biodata error");

			// add object pelatihan dengan error nya ke view
			view.addObject("pelatihan", pelatihan);
		} else {
			// set user id
			pelatihan.setCreatedBy(this.getAbuid());
			pelatihan.setCreatedOn(new Date());
			// simpan ke repo
			pelRepo.save(pelatihan);
			// add object baru tanpa error
			view.addObject("pelatihan", new XRiwayatPelatihanModel());
		}
		return view;
	}

	@GetMapping(value = "/pelatihan/list/{bid}")
	private ModelAndView list(@PathVariable("bid") Long biodataId) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("pelatihan/_list");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);

		// get pelatihan
		List<XRiwayatPelatihanModel> listpelatihan = this.pelRepo.findActiveByBiodataId(biodataId);
		view.addObject("listpelatihan", listpelatihan);
		return view;
	}

	@GetMapping(value = "/pelatihan/hapus/{pid}")
	private ModelAndView hapus(@PathVariable("pid") Long pid) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("pelatihan/_hapus");
		// get pelatihan
		XRiwayatPelatihanModel pelatihan = this.pelRepo.findById(pid).orElse(null);
		view.addObject("pelatihan", pelatihan);
		return view;
	}

	@PostMapping(value = "/pelatihan/remove")
	private ModelAndView remove(@ModelAttribute("pelatihan") XRiwayatPelatihanModel pelatihan) {
		// get pelatihan
		XRiwayatPelatihanModel item = this.pelRepo.findById(pelatihan.getId()).orElse(null);
		item.setIsDelete(1);
		this.pelRepo.save(item);

		// view sertifkasi
		ModelAndView view = new ModelAndView("pelatihan/_hapus");
		view.addObject("pelatihan", pelatihan);
		return view;
	}
	
	@GetMapping(value = "/pelatihan/ubah/{pid}") // bid sebagai vaiable biodataId
	public ModelAndView edit(@PathVariable("pid") Long pid) {
		// menampilkan view dari folder pelatihan file _create.html
		ModelAndView view = new ModelAndView("pelatihan/_create");
		// membuat object pelatihan model
		XRiwayatPelatihanModel pelatihan = this.pelRepo.findById(pid).orElse(null);

		Calendar date = new GregorianCalendar();
		Integer currentYear = date.get(Calendar.YEAR);
		List<Integer> listBulan = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			listBulan.add(i);
		}

		List<Integer> listStartYear = new ArrayList<Integer>();
		for (int i = currentYear - 20; i <= currentYear; i++) {
			listStartYear.add(i);
		}

		List<XTimePeriodeModel> listTime = this.timeRepo.findAll();
		// add object pelatihan
		view.addObject("pelatihan", pelatihan);
		// add object list mothn
		view.addObject("listBulan", listBulan);
		// add object tahun start
		view.addObject("listStartYear", listStartYear);
		// add object listTime
		view.addObject("listTime", listTime);
		return view;
	}
}