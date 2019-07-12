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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XSertifikasiModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XSertifikasiRepo;

@Controller
public class SertifikasiController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(SertifikasiController.class);

	@Autowired
	private XBiodataRepo bioRepo;

	@Autowired
	private XSertifikasiRepo sertRepo;

	@GetMapping(value = "/pelamar/sertifikasi/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("sertifikasi/index");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);

		// get sertifikasi
		List<XSertifikasiModel> listSertifikasi = this.sertRepo.findByBiodataId(biodataId);
		view.addObject("listSertifikasi", listSertifikasi);
		return view;
	}

	@GetMapping(value = "/sertifikasi/add/{bid}") // bid sebagai vaiable biodataId
	public ModelAndView create(@PathVariable("bid") Long biodataId) {
		// menampilkan view dari folder sertifikasi file _create.html
		ModelAndView view = new ModelAndView("sertifikasi/_create");
		// membuat object sertifikasi model
		XSertifikasiModel sertifikasi = new XSertifikasiModel();
		// set biodata id
		sertifikasi.setBiodataId(biodataId);

		view.addObject("sertifikasi", sertifikasi);
		return view;
	}

	@PostMapping(value = "/sertifikasi/save")
	public ModelAndView save(@Valid @ModelAttribute("sertifikasi") XSertifikasiModel sertifikasi,
			BindingResult result) {
		// menampilkan view dari folder sertifikasi file _create.html
		ModelAndView view = new ModelAndView("sertifikasi/_create");

		if (result.hasErrors()) {
			logger.info("save biodata error");

			// add object sertifikasi dengan error nya ke view
			view.addObject("sertifikasi", sertifikasi);
		} else {
			// set user id
			sertifikasi.setCreatedBy(this.getAbuid());
			sertifikasi.setCreatedOn(new Date());
			// simpan ke repo
			sertRepo.save(sertifikasi);
			// add object baru tanpa error
			view.addObject("sertifikasi", new XSertifikasiModel());
		}
		return view;
	}

	@GetMapping(value = "/sertifikasi/list/{bid}")
	private ModelAndView list(@PathVariable("bid") Long biodataId) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("sertifikasi/_list");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);

		view.addObject("biodata", biodata);

		// get sertifikasi
		List<XSertifikasiModel> listSertifikasi = this.sertRepo.findByBiodataId(biodataId);

		view.addObject("listSertifikasi", listSertifikasi);
		return view;
	}

	@GetMapping(value = "/sertifikasi/hapus/{sid}")
	private ModelAndView hapus(@PathVariable("sid") Long sid) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("sertifikasi/_hapus");
		// get sertifikasi
		XSertifikasiModel sertifikasi = this.sertRepo.findById(sid).orElse(null);
		view.addObject("sertifikasi", sertifikasi);
		return view;
	}

	@PostMapping(value = "/sertifikasi/remove")
	private ModelAndView remove(@ModelAttribute("sertifikasi") XSertifikasiModel sertifikasi) {
		// get sertifikasi
		XSertifikasiModel item = this.sertRepo.findById(sertifikasi.getId()).orElse(null);
		sertifikasi.setIsDelete(1);
		this.sertRepo.save(sertifikasi);

		// view sertifkasi
		ModelAndView view = new ModelAndView("sertifikasi/_hapus");
		view.addObject("sertifikasi", sertifikasi);
		return view;
	}

	@RequestMapping(value = "/sertifikasi/ubah/{sid}")
	public String edit(Model model, @PathVariable(name = "sid") Long sid) {
		XSertifikasiModel item = sertRepo.findById(sid).orElse(null);
		model.addAttribute("sertifikasi", item);
		return "sertifikasi/edit";
	}

	// #3. Menangkap data dari form
	@PostMapping(value = "/sertifikasi/update{sid}")
	public ModelAndView update(@Valid @ModelAttribute("sertifikasi") XSertifikasiModel item, BindingResult result) {
		if (result.hasErrors()) {
			logger.info("save sertifikasi error");
		} else {
			sertRepo.save(item);
		}

		ModelAndView view = new ModelAndView("sertifikasi/edit");
		view.addObject("sertifikasi", item);
		return view;
	}
}