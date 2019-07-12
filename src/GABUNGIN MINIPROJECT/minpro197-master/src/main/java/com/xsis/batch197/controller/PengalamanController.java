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
import com.xsis.batch197.model.XRiwayatPekerjaanModel;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XRiwayatPekerjaanRepo;

@Controller
public class PengalamanController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(PengalamanController.class);

	@Autowired
	private XBiodataRepo bioRepo;

	@Autowired
	private XRiwayatPekerjaanRepo pekRepo;

	@GetMapping(value = "/pelamar/pengalaman/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view pengalaman
		ModelAndView view = new ModelAndView("pengalaman/index");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);

		// get pengalaman
		//List<XpengalamanModel> listpengalaman = this.sertRepo.findByBiodataId(biodataId);
		List<XRiwayatPekerjaanModel> listpengalaman = this.pekRepo.findActiveByBiodataId(biodataId);
		view.addObject("listpengalaman", listpengalaman);
		return view;
	}

	@GetMapping(value = "/pengalaman/add/{bid}") // bid sebagai vaiable biodataId
	public ModelAndView create(@PathVariable("bid") Long biodataId) {
		// menampilkan view dari folder pengalaman file _form.html
		ModelAndView view = new ModelAndView("pengalaman/_form");
		// membuat object pengalaman model
		XRiwayatPekerjaanModel pengalaman = new XRiwayatPekerjaanModel();
		// set biodata id
		pengalaman.setBiodataId(biodataId);

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

		List<Integer> listValidYear = new ArrayList<Integer>();
		for (int i = currentYear; i <= currentYear + 10; i++) {
			listValidYear.add(i);
		}
		// add object pengalaman
		view.addObject("pengalaman", pengalaman);
		// add object list mothn
		view.addObject("listBulan", listBulan);
		// add object tahun start
		view.addObject("listStartYear", listStartYear);
		// add object tahun valid
		view.addObject("listValidYear", listValidYear);
		return view;
	}

	@PostMapping(value = "/pengalaman/save")
	public ModelAndView save(@Valid @ModelAttribute("pengalaman") XRiwayatPekerjaanModel pengalaman,
			BindingResult result) {
		// menampilkan view dari folder pengalaman file _form.html
		ModelAndView view = new ModelAndView("pengalaman/_form");

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

		List<Integer> listValidYear = new ArrayList<Integer>();
		for (int i = currentYear; i <= currentYear + 10; i++) {
			listValidYear.add(i);
		}
		// add object list mothn
		view.addObject("listBulan", listBulan);
		// add object tahun start
		view.addObject("listStartYear", listStartYear);
		// add object tahun valid
		view.addObject("listValidYear", listValidYear);
		if (result.hasErrors()) {
			logger.info("save biodata error");

			// add object pengalaman dengan error nya ke view
			view.addObject("pengalaman", pengalaman);
		} else {
			// set user id
			pengalaman.setCreatedBy(this.getAbuid());
			pengalaman.setCreatedOn(new Date());
			// simpan ke repo
			pekRepo.save(pengalaman);
			// add object baru tanpa error
			//view.addObject("pengalaman", new XpengalamanModel());
			view = new ModelAndView("redirect:/pengalaman/add/"+ pengalaman.getBiodataId());
		}
		return view;
	}

	@GetMapping(value = "/pengalaman/list/{bid}")
	private ModelAndView list(@PathVariable("bid") Long biodataId) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("pengalaman/_list");
		// get biodata Id
		XBiodataModel biodata = this.bioRepo.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);

		// get pengalaman
		//List<XpengalamanModel> listpengalaman = this.sertRepo.findByBiodataId(biodataId);
		List<XRiwayatPekerjaanModel> listpengalaman = this.pekRepo.findActiveByBiodataId(biodataId);
		view.addObject("listpengalaman", listpengalaman);
		return view;
	}

	@GetMapping(value = "/pengalaman/hapus/{sid}")
	private ModelAndView hapus(@PathVariable("sid") Long sid) {
		// view sertifkasi
		ModelAndView view = new ModelAndView("pengalaman/_hapus");
		// get pengalaman
		XRiwayatPekerjaanModel pengalaman = this.pekRepo.findById(sid).orElse(null);
		view.addObject("pengalaman", pengalaman);
		return view;
	}

	@PostMapping(value = "/pengalaman/remove")
	private ModelAndView remove(@ModelAttribute("pengalaman") XRiwayatPekerjaanModel pengalaman) {
		// get pengalaman
		XRiwayatPekerjaanModel item = this.pekRepo.findById(pengalaman.getId()).orElse(null);

		// set delete
		item.setDeletedOn(new Date());
		item.setDeletedBy(this.getAbuid());
		item.setIsDelete(1);
		this.pekRepo.save(item);

		// view sertifkasi
		ModelAndView view = new ModelAndView("pengalaman/_hapus");
		view.addObject("pengalaman", item);
		return view;
	}

	@GetMapping(value = "/pengalaman/ubah/{sid}") // bid sebagai vaiable biodataId
	public ModelAndView edit(@PathVariable("sid") Long sid) {
		// menampilkan view dari folder pengalaman file _form.html
		ModelAndView view = new ModelAndView("pengalaman/_form");
		// membuat object pengalaman model
		XRiwayatPekerjaanModel pengalaman = this.pekRepo.findById(sid).orElse(null);

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

		List<Integer> listValidYear = new ArrayList<Integer>();
		for (int i = currentYear; i <= currentYear + 10; i++) {
			listValidYear.add(i);
		}
		// add object pengalaman
		view.addObject("pengalaman", pengalaman);
		// add object list mothn
		view.addObject("listBulan", listBulan);
		// add object tahun start
		view.addObject("listStartYear", listStartYear);
		// add object tahun valid
		view.addObject("listValidYear", listValidYear);
		return view;
	}
}