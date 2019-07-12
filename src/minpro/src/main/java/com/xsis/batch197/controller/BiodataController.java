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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.model.XAddressBookModel;
import com.xsis.batch197.model.XAddressModel;
import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XCompanyModel;
import com.xsis.batch197.model.XIdentityTypeModel;
import com.xsis.batch197.model.XMaritalStatusModel;
import com.xsis.batch197.model.XReligionModel;
import com.xsis.batch197.modelview.FormBiodataModel;
import com.xsis.batch197.repository.XAddressBookRepo;
import com.xsis.batch197.repository.XAddressRepo;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XCompanyRepo;
import com.xsis.batch197.repository.XIdentityTypeRepo;
import com.xsis.batch197.repository.XMaritalStatusRepo;
import com.xsis.batch197.repository.XReligionRepo;

@Controller
public class BiodataController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(PelamarController.class);

	@Autowired
	private XBiodataRepo repoBio;

	@Autowired
	private XIdentityTypeRepo identityRepo;

	@Autowired
	private XMaritalStatusRepo maritalRepo;

	@Autowired
	private XReligionRepo religionRepo;

	@Autowired
	private XAddressRepo repoAddress;

	@GetMapping(value = "/pelamar/biodata/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view biodata
		ModelAndView view = new ModelAndView("biodata/index");
		// get biodata Id
		XBiodataModel biodata = this.repoBio.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);

		return view;
	}

	@GetMapping(value = "/biodata/ubah/{id}")
	public ModelAndView edit(@PathVariable(name = "id") Long id) {
		ModelAndView view = new ModelAndView("biodata/_form");
		// ambil dulu dari database
		XBiodataModel biodata = repoBio.findById(id).orElse(null);		
		
		XAddressModel address = new XAddressModel();
		address = this.repoAddress.findByBiodataId(id);
		
		// buat object form dengan constructor baru
		FormBiodataModel form = new FormBiodataModel(biodata);
		if(address != null) {
			form.setAddressData(address);
		}
		//kirim ke view
		view.addObject("biodata", form);
		
		List<XReligionModel> listReligion = this.religionRepo.findAll();
		view.addObject("listReligion", listReligion);
		
		List<XIdentityTypeModel> listIdentity = identityRepo.findAll();
		view.addObject("listIdentity", listIdentity);
		
		List<XMaritalStatusModel> listMarital = maritalRepo.findAll();
		view.addObject("listMarital", listMarital);

		return view;
	}
	
	@PostMapping(value="/biodata/save")
	public ModelAndView save(@ModelAttribute FormBiodataModel biodata, BindingResult result) {
		ModelAndView view = new ModelAndView("biodata/_form");
		// jika ada error
		if(result.hasErrors()) {
			// data yang error dikirim lagi ke view
			view.addObject("biodata", biodata);
		}else {
			// kalau sukses maka, biodata dibuat baru, agar ga ada error
			Long userId = this.getAbuid();
			XBiodataModel pelamar = new XBiodataModel(biodata, userId);
			this.repoBio.save(pelamar);
			
			XAddressModel address = new XAddressModel(biodata,userId);
			this.repoAddress.save(address);
			view.addObject("biodata", new FormBiodataModel());
		}
		return view;
	}
	
/*
	private boolean saveValidation(FormBiodataModel pelamar, BindingResult result) {
		boolean isValid = true;
		// cek isi data repoBiodata
		Long countEmail = repoBio.count(new Specification<XBiodataModel>() {
			@Override
			public Predicate toPredicate(Root<XBiodataModel> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				// membandingkan email yang ada di field email dengan email yang baru dimasukan
				return criteriaBuilder.equal(root.get("email"), pelamar.getEmail());
			}
		});
		// jika email sudah ada atau lebih dari 0
		if (countEmail.intValue() > 0) {
			result.rejectValue("email", "email.duplicate", "Email is duplicate");
			isValid = false;
		}
		Long countNik = repoBio.count(new Specification<XBiodataModel>() {
			@Override
			public Predicate toPredicate(Root<XBiodataModel> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				// membandingan nomor identitas yang ada di field identy\ityNo dengan identitas
				// yang baru di masukan/input
				return criteriaBuilder.equal(root.get("identityNo"), pelamar.getIdentityNo());
			}
		});
		// jika nik sudah ada atau lebih dari 0
		if (countNik.intValue() > 0) {
			result.rejectValue("identityNo", "identityNo.duplicate", "identityNo is duplicate");
			isValid = false;
		}
		Long countParentPhone = repoBio.count(new Specification<XBiodataModel>() {
			@Override
			public Predicate toPredicate(Root<XBiodataModel> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				// membandingkan parentPhoneNumber yang diinput dengan parentPhoneNumber,
				// phoneNumber, phoneNumber2 yang ada di field
				return criteriaBuilder.or(
						criteriaBuilder.equal(root.get("parentPhoneNumber"), pelamar.getParentPhoneNumber()),
						criteriaBuilder.equal(root.get("phoneNumber1"), pelamar.getParentPhoneNumber()),
						criteriaBuilder.equal(root.get("phoneNumber2"), pelamar.getParentPhoneNumber())
				);
			}
		});
		// jika no hp sudah ada atau lebih dari 0
		if (countParentPhone.intValue() > 0) {
			result.rejectValue("parentPhoneNumber", "countPhone.duplicate", "Parent Phone is duplicate");
			isValid = false;
		}
		Long countPhone1 = repoBio.count(new Specification<XBiodataModel>() {
			@Override
			public Predicate toPredicate(Root<XBiodataModel> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				return criteriaBuilder.or(
						criteriaBuilder.equal(root.get("parentPhoneNumber"), pelamar.getPhoneNumber1()),
						criteriaBuilder.equal(root.get("phoneNumber1"), pelamar.getPhoneNumber1()),
						criteriaBuilder.equal(root.get("phoneNumber2"), pelamar.getPhoneNumber1())
				);
			}
		});
		if (countPhone1.intValue() > 0) {
			result.rejectValue("phoneNumber1", "countPhone.duplicate", "Phone 1 is duplicate");
			isValid = false;
		}
		Long countPhone2 = repoBio.count(new Specification<XBiodataModel>() {
			@Override
			public Predicate toPredicate(Root<XBiodataModel> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				return criteriaBuilder.or(
						criteriaBuilder.equal(root.get("parentPhoneNumber"), pelamar.getPhoneNumber2()),
						criteriaBuilder.equal(root.get("phoneNumber1"), pelamar.getPhoneNumber2()),
						criteriaBuilder.equal(root.get("phoneNumber2"), pelamar.getPhoneNumber2())
				);
			}
		});
		if (countParentPhone.intValue() > 0) {
			result.rejectValue("phoneNumber2", "countPhone2.duplicate", "Parent Phone is duplicate");
			isValid = false;
		}
		return isValid;
	}
	@PostMapping(value = "/biodata/update/{id}")
	public ModelAndView update(@Valid @ModelAttribute("biodata") FormBiodataModel pelamar, BindingResult result) {
		if (result.hasErrors()) {
			saveValidation(pelamar, result);
			logger.info("save pelamar error");
		} else {
			if (saveValidation(pelamar, result)) {
				XBiodataModel biodata = new XBiodataModel(pelamar, this.getAbuid());
				Long dummyIdUser = new Long(1);
				Date createdOn = new Date();
				biodata.setCreatedOn(createdOn);
				biodata.setCreatedBy(dummyIdUser);
				biodata.setIsDelete(0);
				biodata.setIdentityTypeId(new Long(1));
				biodata.setCompanyId(dummyIdUser);
				repoBio.save(biodata);
				XAddressModel address = new XAddressModel(pelamar, biodata.getId(), this.getAbuid());
				address.setCreatedOn(createdOn);
				address.setCreatedBy(dummyIdUser);
				address.setIsDelete(0);
				repoAddress.save(address);
			}
		}
		ModelAndView view = new ModelAndView("biodata/edit");
		view.addObject("pelamar", pelamar);
		return view;
	}
*/
}