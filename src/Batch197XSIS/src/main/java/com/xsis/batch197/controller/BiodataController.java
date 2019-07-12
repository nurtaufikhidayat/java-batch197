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


import com.xsis.batch197.modelview.FormBiodataModel;
import com.xsis.batch197.model.XAddressBookModel;
import com.xsis.batch197.model.XAddressModel;
import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XCompanyModel;
import com.xsis.batch197.model.XIdentityTypeModel;
import com.xsis.batch197.model.XMaritalStatusModel;
import com.xsis.batch197.model.XReligionModel;
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
	private XAddressBookRepo repoAddressBook;
	
	@Autowired
	private XCompanyRepo repoCompany;
	
	@Autowired
	private XIdentityTypeRepo repoIdentityType;
	
	@Autowired
	private XMaritalStatusRepo repoMarital;
	
	@Autowired
	private XReligionRepo repoReligion;
	
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
	
	

}
