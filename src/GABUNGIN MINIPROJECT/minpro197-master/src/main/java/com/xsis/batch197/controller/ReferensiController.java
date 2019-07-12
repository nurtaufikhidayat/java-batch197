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
public class ReferensiController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(ReferensiController.class);

	@Autowired
	private XBiodataRepo bioRepo;

	@Autowired
	private XPeReferensiRepo refRepo;

	
}
