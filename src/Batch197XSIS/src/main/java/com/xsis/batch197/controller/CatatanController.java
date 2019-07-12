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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XCatatanModel;
import com.xsis.batch197.model.XNoteTypeModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XCatatanRepo;
import com.xsis.batch197.repository.XNoteTypeRepo;

@Controller
public class CatatanController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(CatatanController.class);

	@Autowired
	private XBiodataRepo bioRepo;

	@Autowired
	private XCatatanRepo catRepo;

	@Autowired
	private XNoteTypeRepo noteTypeRepo;

	@GetMapping(value = "/pelamar/catatan/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("catatan/index");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);

		// get catatan
		List<XCatatanModel> listcatatan = this.catRepo.findByBiodataId(biodataId);
		view.addObject("listcatatan", listcatatan);
		return view;
	}

	@GetMapping(value = "/catatan/add/{bid}") // bid sebagai vailable biodataId
	public ModelAndView create(@PathVariable("bid") Long biodataId) {
		// menampilkan view dari folder catatan file _form.html
		ModelAndView view = new ModelAndView("catatan/_form");
		// membuat object catatan model
		XCatatanModel catatan = new XCatatanModel();
		// set biodata id
		catatan.setBiodataId(biodataId);

		List<XNoteTypeModel> listType = this.noteTypeRepo.findAll();
		// add object catatan
		view.addObject("catatan", catatan);
		// add object list type
		view.addObject("listType", listType);
		return view;
	}

	@PostMapping(value = "/catatan/save")
	public ModelAndView save(@Valid @ModelAttribute("catatan") XCatatanModel catatan, BindingResult result) {
		// menampilkan view dari folder catatan file _form.html
		ModelAndView view = new ModelAndView("catatan/_form");

		if (result.hasErrors()) {
			logger.info("save biodata error");

			// add object catatan dengan error nya ke view
			view.addObject("catatan", catatan);
		} else {
			// set user id
			catatan.setCreatedBy(this.getAbuid());
			catatan.setCreatedOn(new Date());
			// simpan ke repo
			catRepo.save(catatan);
			// add object baru tanpa error
			//view.addObject("catatan", new XCatatanModel());
			view = new ModelAndView("redirect:/catatan/add/"+ catatan.getBiodataId());
		}
		return view;
	}

	@GetMapping(value = "/catatan/list/{bid}")
	private ModelAndView list(@PathVariable("bid") Long biodataId) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("catatan/_list");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);

		// get catatan
		List<XCatatanModel> listcatatan = this.catRepo.findByBiodataId(biodataId);
		view.addObject("listcatatan", listcatatan);
		return view;
	}

	@GetMapping(value = "/catatan/hapus/{cid}")
	private ModelAndView hapus(@PathVariable("cid") Long cid) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("catatan/_hapus");
		// get catatan
		XCatatanModel catatan = this.catRepo.findById(cid).orElse(null);
		view.addObject("catatan", catatan);
		return view;
	}

	@PostMapping(value = "/catatan/remove")
	private ModelAndView remove(@ModelAttribute("catatan") XCatatanModel catatan) {
		// get catatan
		XCatatanModel item = this.catRepo.findById(catatan.getId()).orElse(null);

		// set delete
		item.setDeletedOn(new Date());
		item.setDeletedBy(this.getAbuid());
		item.setIsDelete(1);
		this.catRepo.save(item);

		// view sertifkasi
		ModelAndView view = new ModelAndView("catatan/_hapus");
		view.addObject("catatan", item);
		return view;
	}

	@GetMapping(value = "/catatan/ubah/{cid}") // bid sebagai vaiable biodataId
	public ModelAndView edit(@PathVariable("cid") Long cid) {
		// menampilkan view dari folder catatan file _form.html
		ModelAndView view = new ModelAndView("catatan/_form");
		// membuat object catatan model
		XCatatanModel catatan = this.catRepo.findById(cid).orElse(null);

		List<XNoteTypeModel> listType = this.noteTypeRepo.findAll();
		// add object catatan
		view.addObject("catatan", catatan);
		// add object list type
		view.addObject("listType", listType);
		return view;
	}
}
