package com.xsis.batch197.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.FormBiodataModel;
import com.xsis.batch197.model.XAddressModel;
import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XRiwayatPendidikanModel;
import com.xsis.batch197.repository.XAddressRepo;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XRiwayatPendidikanRepo;

@Controller
@RequestMapping(value = "/pelamar")
public class PelamarController {
	private static final Logger logger = LoggerFactory.getLogger(PelamarController.class);
	
	@Autowired
	private XRiwayatPendidikanRepo repoRiwPend;
	@Autowired
	private XBiodataRepo repoBiodata;

	@Autowired
	private XAddressRepo repoAddress;
	
	@GetMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("pelamar/index");

		return view;
	}

	@GetMapping(value = "/add")
	public ModelAndView create() {
		// buat object view
		ModelAndView view = new ModelAndView("pelamar/create");
		// membuat object pelamar yg akan dikirim ke view
		// object pelamar adalah new object dari PelamarModel
		FormBiodataModel pelamar = new FormBiodataModel();
		// isi kdProvinsi dengan method getKode()
		view.addObject("biodata", pelamar);
		return view;
	}
	
	private boolean  saveValidation(FormBiodataModel pelamar, BindingResult result) {
		boolean isValid = true;
		Long countEmail = repoBiodata.count(new Specification<XBiodataModel>()  {
			
			@Override
			public Predicate toPredicate(Root<XBiodataModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				return criteriaBuilder.equal(root.get("email"), pelamar.getEmail());
			}
		});
		
		if(countEmail.intValue() > 0) {
			result.rejectValue("email", "email.duplicate", "Email is duplicate");
			isValid = false;
		}
		
		Long countNik = repoBiodata.count(new Specification<XBiodataModel>()  {
			
			@Override
			public Predicate toPredicate(Root<XBiodataModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				return criteriaBuilder.equal(root.get("identityNo"), pelamar.getIdentityNo());
			}
		});
		
		if(countNik.intValue() > 0) {
			result.rejectValue("identityNo", "identityNo.duplicate", "identityNo is duplicate");
			isValid=false;
		}
		
		Long countParentPhone = repoBiodata.count(new Specification<XBiodataModel>()  {
			
			@Override
			public Predicate toPredicate(Root<XBiodataModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				return criteriaBuilder.or(
						criteriaBuilder.equal(root.get("parentPhoneNumber"), pelamar.getParentPhoneNumber()),
						criteriaBuilder.equal(root.get("phoneNumber1"), pelamar.getParentPhoneNumber()),
						
						criteriaBuilder.equal(root.get("phoneNumber2"), pelamar.getParentPhoneNumber())
						
						
								);
			}
		});
		
		if(countParentPhone.intValue() > 0) {
			result.rejectValue("parentPhoneNumber", "countPhone.duplicate", "Parent Phone is duplicate");
			isValid=false;
		}
		
		
Long countPhone1 = repoBiodata.count(new Specification<XBiodataModel>()  {
			
			@Override
			public Predicate toPredicate(Root<XBiodataModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				return criteriaBuilder.or(
						criteriaBuilder.equal(root.get("parentPhoneNumber"), pelamar.getPhoneNumber1()),
						criteriaBuilder.equal(root.get("phoneNumber1"), pelamar.getPhoneNumber1()),
						
						criteriaBuilder.equal(root.get("phoneNumber2"), pelamar.getPhoneNumber1())
						
						
								);
			}
		});
		
		if(countPhone1.intValue() > 0) {
			result.rejectValue("phoneNumber1", "countPhone.duplicate", "Phone 1 is duplicate");
			isValid=false;
		}
		
Long countPhone2 = repoBiodata.count(new Specification<XBiodataModel>()  {
			
			@Override
			public Predicate toPredicate(Root<XBiodataModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				return criteriaBuilder.or(
						criteriaBuilder.equal(root.get("parentPhoneNumber"), pelamar.getPhoneNumber2()),
						criteriaBuilder.equal(root.get("phoneNumber1"), pelamar.getPhoneNumber2()),
						
						criteriaBuilder.equal(root.get("phoneNumber2"), pelamar.getPhoneNumber2())
						
						
								);
			}
		});
		
		if(countParentPhone.intValue() > 0) {
			result.rejectValue("phoneNumber2", "countPhone2.duplicate", "Parent Phone is duplicate");
			isValid=false;
		}
		return isValid;
	}

	//#3. Menangkap data dari form
	@PostMapping(value = "/save")
	public ModelAndView save(@Valid @ModelAttribute("biodata") FormBiodataModel pelamar, BindingResult result) {
		if (result.hasErrors()) {
			saveValidation(pelamar, result);
			logger.info("save pelamar error");
		} else {
			
			
			
			
			if(saveValidation(pelamar, result)) {
				XBiodataModel biodata = new XBiodataModel(pelamar);
				Long dummyIdUser = new Long(1);
				Date createdOn = new Date();
				biodata.setCreatedOn(createdOn);
				biodata.setCreatedBy(dummyIdUser);
				biodata.setIsDelete(false);
				biodata.setIdentityTypeId(new Long(1));
				biodata.setCompanyId("");

				repoBiodata.save(biodata);
				
				XAddressModel address = new XAddressModel(pelamar);
				address.setCreatedOn(createdOn);
				address.setCreatedBy(dummyIdUser);
				address.setIsDelete(false);
				address.setBiodataId(biodata.getId());
				repoAddress.save(address);
			}
			
			
			
		}

		ModelAndView view = new ModelAndView("pelamar/create");
		view.addObject("pelamar", pelamar);
		return view;
	}

	@GetMapping(value = "/cari")
	public ModelAndView cari() {
		ModelAndView view = new ModelAndView("pelamar/cari");

		return view;
	}

	@GetMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("pelamar/list");
		List<XRiwayatPendidikanModel> listRiwPend = repoRiwPend.findAll();
		view.addObject("list", listRiwPend);
		return view;
	}

	@GetMapping(value = "/list/{key}")
	public ModelAndView list(@PathVariable("key") String key) {
		// buat object view
		ModelAndView view = new ModelAndView("pelamar/list");
		// load data provinsi via repo, disimpan kedalam list
		List<XRiwayatPendidikanModel> list = repoRiwPend.search(key);
		// lemparkan data ke view, list object baru, datanya listprovinsi
		view.addObject("list", list);
		return view;
	}

//	Membuat Form View detail kota
	@GetMapping(value = "/detail/{id}")
	public ModelAndView detail(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("pelamar/detail");
		XRiwayatPendidikanModel riwPend = repoRiwPend.findById(id).orElse(new XRiwayatPendidikanModel());
		view.addObject("riwPend", riwPend);
		return view;
	}
}
