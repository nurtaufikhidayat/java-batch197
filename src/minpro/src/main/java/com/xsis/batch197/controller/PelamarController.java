package com.xsis.batch197.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XAddressModel;
import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XIdentityTypeModel;
import com.xsis.batch197.model.XMaritalStatusModel;
import com.xsis.batch197.model.XReligionModel;
import com.xsis.batch197.modelview.FormBiodataModel;
import com.xsis.batch197.repository.XAddressRepo;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XIdentityTypeRepo;
import com.xsis.batch197.repository.XMaritalStatusRepo;
import com.xsis.batch197.repository.XPelamarPagingRepo;
import com.xsis.batch197.repository.XReligionRepo;

@Controller
@RequestMapping(value = "/pelamar")
public class PelamarController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(PelamarController.class);

	@Autowired
	private XBiodataRepo biodataRepo;

	@Autowired
	private XAddressRepo addrRepo;

	@Autowired
	private XIdentityTypeRepo identityRepo;

	@Autowired
	private XMaritalStatusRepo maritalRepo;

	@Autowired
	private XReligionRepo religionRepo;

	@Autowired
	private XPelamarPagingRepo repoPaging;

	@GetMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("pelamar/index");
		return view;
	}

	// Method Button Add
	@GetMapping(value = "/add")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("pelamar/_create");
		FormBiodataModel pelamar = new FormBiodataModel();
		view.addObject("pelamar", pelamar);

		List<XReligionModel> listReligion = this.religionRepo.findAll();
		view.addObject("listReligion", listReligion);

		List<XIdentityTypeModel> listIdentity = identityRepo.findAll();
		view.addObject("listIdentity", listIdentity);

		List<XMaritalStatusModel> listMarital = maritalRepo.findAll();
		view.addObject("listMarital", listMarital);
		return view;
	}
	
	@PostMapping(value = "/save")
	public ModelAndView save(@Valid @ModelAttribute("pelamar") FormBiodataModel pelamar, BindingResult result) {
		ModelAndView view = new ModelAndView("pelamar/_create");
		List<XReligionModel> listReligion = this.religionRepo.findAll();
		view.addObject("listReligion", listReligion);

		List<XIdentityTypeModel> listIdentity = identityRepo.findAll();
		view.addObject("listIdentity", listIdentity);

		List<XMaritalStatusModel> listMarital = maritalRepo.findAll();
		view.addObject("listMarital", listMarital);

		if (result.hasErrors()) {
			logger.info("save biodata error");
			view.addObject("pelamar", pelamar);
		} else {
			if(this.biodataRepo.findByEmail(pelamar.getEmail())!=null) {
				// jika email sudah digunakan
				result.addError(new FieldError("pelamar", "email",pelamar.getEmail(), false, null, null, "Email sudah digunakan"));
				view.addObject("pelamar", pelamar);
			}else if(this.biodataRepo.findByIdentityNo(pelamar.getIdentityNo())!=null) {
				// jika email sudah digunakan
				result.addError(new FieldError("pelamar", "identityNo",pelamar.getIdentityNo(), false, null, null, "Nomor Identity sudah ada"));
				view.addObject("pelamar", pelamar);
			}else if(this.biodataRepo.findByParentPhoneNumber(pelamar.getParentPhoneNumber())!=null) {
				// jika email sudah digunakan
				result.addError(new FieldError("pelamar", "parentPhoneNumber",pelamar.getParentPhoneNumber(), false, null, null, "Nomor Telp Orang Tua sudah ada"));
				view.addObject("pelamar", pelamar);
			}else if(this.biodataRepo.findByPhoneNumber1(pelamar.getPhoneNumber1())!=null) {
				// jika email sudah digunakan
				result.addError(new FieldError("pelamar", "phoneNumber1",pelamar.getPhoneNumber1(), false, null, null, "Nomor Telp sudah ada"));
				view.addObject("pelamar", pelamar);
			}else if(this.biodataRepo.findByPhoneNumber2(pelamar.getPhoneNumber2())!=null) {
				// jika email sudah digunakan
				result.addError(new FieldError("pelamar", "phoneNumber2",pelamar.getPhoneNumber2(), false, null, null, "Nomor Telp sudah ada"));
				view.addObject("pelamar", pelamar);
			}else {
				// simpan kebiodata
				XBiodataModel biodata = new XBiodataModel(pelamar, this.getAbuid());
				this.biodataRepo.save(biodata);
	
				// simpan ke address
				XAddressModel address = new XAddressModel(pelamar, biodata.getId(), this.getAbuid());
				this.addrRepo.save(address);
	
				view.addObject("pelamar", new FormBiodataModel());
			}
		}
		return view;
	}

	@GetMapping(value = "/edit/{bid}")
	public ModelAndView edit(@PathVariable("bid") Long biodataId) {
		ModelAndView view = new ModelAndView("pelamar/_edit");
		// ambil dulu dari database
		XBiodataModel biodata = biodataRepo.findById(biodataId).orElse(null);

		XAddressModel address = new XAddressModel();
		address = this.addrRepo.findByBiodataId(biodataId);

		// buat object form dengan constructor baru
		FormBiodataModel pelamar = new FormBiodataModel(biodata);
		if (address != null) {
			pelamar.setAddressData(address);
		}
		view.addObject("pelamar", pelamar);

		List<XReligionModel> listReligion = this.religionRepo.findAll();
		view.addObject("listReligion", listReligion);

		List<XIdentityTypeModel> listIdentity = identityRepo.findAll();
		view.addObject("listIdentity", listIdentity);

		List<XMaritalStatusModel> listMarital = maritalRepo.findAll();
		view.addObject("listMarital", listMarital);

		return view;
	}

	@PostMapping(value = "/update")
	public ModelAndView update(@Valid @ModelAttribute("pelamar") FormBiodataModel pelamar, BindingResult result) {
		ModelAndView view = new ModelAndView("pelamar/_edit");
		List<XReligionModel> listReligion = this.religionRepo.findAll();
		view.addObject("listReligion", listReligion);

		List<XIdentityTypeModel> listIdentity = identityRepo.findAll();
		view.addObject("listIdentity", listIdentity);

		List<XMaritalStatusModel> listMarital = maritalRepo.findAll();
		view.addObject("listMarital", listMarital);

		if (result.hasErrors()) {
			view.addObject("pelamar", pelamar);
		} else {
			// simpan kebiodata
			XBiodataModel biodata = new XBiodataModel(pelamar, this.getAbuid());
			this.biodataRepo.save(biodata);

			// simpan ke address
			XAddressModel address = new XAddressModel(pelamar, biodata.getId(), this.getAbuid());
			this.addrRepo.save(address);

			view.addObject("pelamar", new FormBiodataModel());
		}
		return view;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	// Method List data saat load pelamar/index STATUS FIX
	@GetMapping(value = "/list")
	public ModelAndView list(@PageableDefault(size = 10) Pageable pageable) {
		ModelAndView view = new ModelAndView("pelamar/_item");

		Page<XBiodataModel> listPelamar = repoPaging.findAll(pageable);
		view.addObject("list", listPelamar);

		return view;
	}

	// Method untuk button search STATUS FIX
	@GetMapping(value = "/list/{key}")
	public ModelAndView list(@PathVariable("key") String key, @PageableDefault(size = 10) Pageable pageable) {
		ModelAndView view = new ModelAndView("pelamar/_item");

		// load data pelamar via repo, disimpan kedalam list
		Page<XBiodataModel> listPelamar = repoPaging.search(key, pageable);
		// lemparkan data ke view, list object baru
		view.addObject("list", listPelamar);
		return view;
	}

	// Method Search with Pagination STATUS FIX
	@GetMapping(value = "/search")
	public ModelAndView search(@RequestParam("key") String key, Pageable pageable) {
		ModelAndView view = new ModelAndView("pelamar/list");

		// load data pelamar via repo, disimpan kedalam list
		Page<XBiodataModel> listPelamar = repoPaging.search(key, pageable);
		// lemparkan data ke view, list object baru
		view.addObject("list", listPelamar);
		return view;
	}

	// Search with Pagination set by sort STATUS PROGRES
	@GetMapping(value = "/search/{sort}")
	public ModelAndView sort(@RequestParam("key") String key, @PageableDefault(size = 10) Pageable pageable,
			@RequestParam("sort") String sort) {
		ModelAndView view = new ModelAndView("pelamar/list");

		// load data pelamar via repo, disimpan kedalam list
		Page<XBiodataModel> listPelamar = repoPaging.search(key, pageable);
		// lemparkan data ke view, list object baru
		view.addObject("list", listPelamar);
		return view;
	}

	// Method untuk menampilkan isi modal pelamar
	@GetMapping(value = "/detail/{id}")
	public ModelAndView detail(@PathVariable("id") Long id) {
		// buat object view
		ModelAndView view = new ModelAndView("pelamar/detail");
		// mengambil data dahulu dari database via repository
		XBiodataModel pelamar = biodataRepo.findById(id).orElse(new XBiodataModel());
		view.addObject("pelamar", pelamar);
		return view;
	}

}