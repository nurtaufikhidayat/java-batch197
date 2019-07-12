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
import com.xsis.batch197.model.XPeReferensiModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XPeReferensiRepo;

@Controller
public class LainlainController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(LainlainController.class);

	@Autowired
	private XBiodataRepo bioRepo;

	@Autowired
	private XPeReferensiRepo refRepo;

	@GetMapping(value = "/pelamar/lain-lain/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view referensi
		ModelAndView view = new ModelAndView("lain-lain/index");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);
		
		// get referensi
		List<XPeReferensiModel> listReferensi = this.refRepo.findActiveByBiodataId(biodataId);
		view.addObject("listReferensi", listReferensi);

		return view;
	}

	// Method Button Add
	@GetMapping(value = "/lain-lain/addreferensi/{bid}") // bid ini sebagai variable dari biodataId
	public ModelAndView create(@PathVariable("bid") Long biodataId) {
		// menampilkan view dari folder lain-lain file _formreferensi.html
		ModelAndView view = new ModelAndView("lain-lain/_formreferensi");
		// membuat object referensi yang akan dikirim ke view
		// object "referensi" adalah new object dari XPereferensiModel
		XPeReferensiModel referensi = new XPeReferensiModel();
		// set biodata id nya
		referensi.setBiodataId(biodataId);
		// add object keahlian
		view.addObject("referensi", referensi);

		return view;
	}

	// simpan data Referensi
	@PostMapping(value = "/lain-lain/savereferensi")
	public ModelAndView save(@Valid @ModelAttribute("referensi") XPeReferensiModel referensi, BindingResult result) {
		// menampilkan view dari folder referensi _formreferensi.html
		ModelAndView view = new ModelAndView("lain-lain/_formreferensi");

		if (result.hasErrors()) {
			logger.info("Save Referensi Error!");
			// add object referensi beserta errornya ke view
			view.addObject("referensi", referensi);
		} else {
			// set userId
			referensi.setCreatedBy(this.getAbuid());
			referensi.setCreatedOn(new Date());
			// simpan ke repo
			refRepo.save(referensi);
			// add object baru tanpa error
			view.addObject("referensi", new XPeReferensiModel());
		}
		return view;
	}

	// menampilkan list data referensi
	@GetMapping(value = "/lain-lain/listreferensi/{bid}")
	private ModelAndView list(@PathVariable("bid") Long biodataId) {
		// view data referensi
		ModelAndView view = new ModelAndView("lain-lain/_listreferensi");
		// get biodataId
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);

		// get data referensi
		List<XPeReferensiModel> listReferensi = this.refRepo.findActiveByBiodataId(biodataId);
		view.addObject("listReferensi", listReferensi);

		return view;
	}

	// hapus data referensi
	@GetMapping(value = "/lain-lain/hapusreferensi/{rid}")
	private ModelAndView hapus(@PathVariable("rid") Long kid) {
		// view data referensi
		ModelAndView view = new ModelAndView("lain-lain/_hapusreferensi");
		// get data referensi
		XPeReferensiModel referensi = this.refRepo.findById(kid).orElse(null);
		view.addObject("referensi", referensi);
		return view;
	}

	@PostMapping(value = "/lain-lain/removereferensi")
	private ModelAndView remove(@ModelAttribute("referensi") XPeReferensiModel referensi) {
		// get data referensi
		XPeReferensiModel item = this.refRepo.findById(referensi.getId()).orElse(null);
		item.setIsDelete(1);
		this.refRepo.save(item);
		// view data referensi
		ModelAndView view = new ModelAndView("lain-lain/_hapusreferensi");
		view.addObject("referensi", item);
		return view;
	}

	// ubah data referensi
	@GetMapping(value = "/lain-lain/ubahreferensi/{rid}")
	public ModelAndView edit(@PathVariable("rid") Long rid) {
		// view edit
		ModelAndView view = new ModelAndView("lain-lain/_formreferensi");
		// mengambil data dahulu dari database via repository
		XPeReferensiModel referensi = this.refRepo.findById(rid).orElse(null);
		view.addObject("referensi", referensi);

		return view;
	}
}
