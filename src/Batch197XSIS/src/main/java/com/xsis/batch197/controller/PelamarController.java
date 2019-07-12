package com.xsis.batch197.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.xsis.batch197.model.XRiwayatPendidikanModel;
import com.xsis.batch197.modelview.FormBiodataModel;
import com.xsis.batch197.repository.XAddressRepo;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XIdentityTypeRepo;
import com.xsis.batch197.repository.XMaritalStatusRepo;
import com.xsis.batch197.repository.XPelamarPagingRepo;
import com.xsis.batch197.repository.XReligionRepo;
import com.xsis.batch197.repository.XRiwayatPendidikanRepo;

@Controller
@RequestMapping(value = "/pelamar")
public class PelamarController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(PelamarController.class);
	
	@Autowired
	private XBiodataRepo repoBio;

	@Autowired
	private XPelamarPagingRepo repoPaging;
	
	@Autowired
	private XRiwayatPendidikanRepo repoRiwpend;
	
	@Autowired
	private XAddressRepo addrRepo;
	
	@Autowired
	private XReligionRepo religionRepo;
	
	@Autowired
	private XIdentityTypeRepo identityRepo;
	
	@Autowired
	private XMaritalStatusRepo maritalRepo;

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
			if(this.repoBio.findByEmail(pelamar.getEmail())!=null) {
				// jika email sudah digunakan
				result.addError(new FieldError("pelamar", "email",pelamar.getEmail(), false, null, null, "Email sudah digunakan"));
				view.addObject("pelamar", pelamar);
			}else if(this.repoBio.findByIdentityNo(pelamar.getIdentityNo())!=null) {
				// jika email sudah digunakan
				result.addError(new FieldError("pelamar", "identityNo",pelamar.getIdentityNo(), false, null, null, "Nomor Identity sudah ada"));
				view.addObject("pelamar", pelamar);
			}else if(this.repoBio.findByParentPhoneNumber(pelamar.getParentPhoneNumber())!=null) {
				// jika email sudah digunakan
				result.addError(new FieldError("pelamar", "parentPhoneNumber",pelamar.getParentPhoneNumber(), false, null, null, "Nomor Telp Orang Tua sudah ada"));
				view.addObject("pelamar", pelamar);
			}else if(this.repoBio.findByPhoneNumber1(pelamar.getPhoneNumber1())!=null) {
				// jika email sudah digunakan
				result.addError(new FieldError("pelamar", "phoneNumber1",pelamar.getPhoneNumber1(), false, null, null, "Nomor Telp sudah ada"));
				view.addObject("pelamar", pelamar);
			}else if(this.repoBio.findByPhoneNumber2(pelamar.getPhoneNumber2())!=null) {
				// jika email sudah digunakan
				result.addError(new FieldError("pelamar", "phoneNumber2",pelamar.getPhoneNumber2(), false, null, null, "Nomor Telp sudah ada"));
				view.addObject("pelamar", pelamar);
			}else {
				// simpan kebiodata
				XBiodataModel biodata = new XBiodataModel(pelamar, this.getAbuid());
				this.repoBio.save(biodata);
	
				// simpan ke address
				XAddressModel address = new XAddressModel(pelamar, biodata.getId(), this.getAbuid());
				this.addrRepo.save(address);
	
				view.addObject("pelamar", new FormBiodataModel());
			}
		}
		return view;
	}
	
	

	// Method untuk button search
	@GetMapping(value = "/list/{key}")
	public ModelAndView list(@PathVariable("key") String key, @PageableDefault(size = 10) Pageable pageable) {
		ModelAndView view = new ModelAndView("pelamar/_item");

		List<XRiwayatPendidikanModel> listPend = repoRiwpend.findAll();
		view.addObject("listPend", listPend);

		Page<XBiodataModel> listPelamar = repoPaging.search(key, pageable);
		view.addObject("list", listPelamar);
		return view;
	}

	// Method Search with Pagination
	@GetMapping(value = "/search")
	public ModelAndView search(@RequestParam("key") String key, Pageable pageable) {
		ModelAndView view = new ModelAndView("pelamar/_item");

		List<XRiwayatPendidikanModel> listPend = repoRiwpend.findAll();
		view.addObject("listPend", listPend);

		Page<XBiodataModel> listPelamar = repoPaging.search(key, pageable);
		view.addObject("list", listPelamar);

		return view;
	}

	// Method untuk menampilkan isi modal pelamar
	@GetMapping(value = "/detail/{id}")
	public ModelAndView detail(@PathVariable("id") Long id) {
		// buat object view
		ModelAndView view = new ModelAndView("pelamar/detail");
		// mengambil data dahulu dari database via repository
		XBiodataModel pelamar = repoBio.findById(id).orElse(new XBiodataModel());
		view.addObject("pelamar", pelamar);
		return view;
	}
	
	// method untuk form edit
	@GetMapping(value = "/edit/{bid}")
	public ModelAndView edit(@PathVariable("bid") Long biodataId) {
		ModelAndView view = new ModelAndView("pelamar/_edit");
		// ambil dulu dari database
		XBiodataModel biodata = repoBio.findById(biodataId).orElse(null);

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
	
	// method untuk save hasil edit
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
		}else if(this.repoBio.findByIdentityNo(pelamar.getIdentityNo())!=null) {
			// jika email sudah digunakan
			result.addError(new FieldError("pelamar", "identityNo",pelamar.getIdentityNo(), false, null, null, "Nomor Identity sudah ada"));
			view.addObject("pelamar", pelamar);
		}else if(this.repoBio.findByParentPhoneNumber(pelamar.getParentPhoneNumber())!=null) {
			// jika email sudah digunakan
			result.addError(new FieldError("pelamar", "parentPhoneNumber",pelamar.getParentPhoneNumber(), false, null, null, "Nomor Telp Orang Tua sudah ada"));
			view.addObject("pelamar", pelamar);
		}else if(this.repoBio.findByPhoneNumber1(pelamar.getPhoneNumber1())!=null) {
			// jika email sudah digunakan
			result.addError(new FieldError("pelamar", "phoneNumber1",pelamar.getPhoneNumber1(), false, null, null, "Nomor Telp sudah ada"));
			view.addObject("pelamar", pelamar);
		}else if(this.repoBio.findByPhoneNumber2(pelamar.getPhoneNumber2())!=null) {
			// jika email sudah digunakan
			result.addError(new FieldError("pelamar", "phoneNumber2",pelamar.getPhoneNumber2(), false, null, null, "Nomor Telp sudah ada"));
			view.addObject("pelamar", pelamar);
		} else {
			// simpan kebiodata
			XBiodataModel biodata = new XBiodataModel(pelamar, this.getAbuid());
			this.repoBio.save(biodata);

			// simpan ke address
			XAddressModel address = new XAddressModel(pelamar, biodata.getId(), this.getAbuid());
			this.addrRepo.save(address);

			view.addObject("pelamar", new FormBiodataModel());
		}
		return view;
	}

}
