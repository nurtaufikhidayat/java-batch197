package com.xsis.batch197.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch197.repository.XCompanyRepo;
import com.xsis.batch197.repository.XRoleRepo;

@Controller
public class HomeController {
	@Autowired
	private XRoleRepo roleRepo;

	@Autowired
	private XCompanyRepo comRepo;

	@GetMapping(value = "/")
	public ModelAndView index() {
		return new ModelAndView("home/index");
	}

	@GetMapping(value = "/home/index")
	public ModelAndView dashbord() {
		return new ModelAndView("home/index");
	}

	@GetMapping(value = "/forgot-password")
	public ModelAndView forgot() {
		return new ModelAndView("home/forgot-password");
	}

	@GetMapping(value = "/form-forgot-password")
	public ModelAndView formforgot() {
		return new ModelAndView("home/form-forgot-password");
	}

	// setelah login pilih role dan pilih company
	@GetMapping(value = "/select-role")
	public ModelAndView selectAccess() {
		ModelAndView view = new ModelAndView("home/select-access");
		// add object to list
		view.addObject("listRole", this.roleRepo.findAll());
		view.addObject("listCompany", this.comRepo.findAll());

		return view;
	}

	// untuk menangkap request setelah dipilih role dan company
	@PostMapping(value = "/set-access")
	private String setAccess(@RequestParam("roleId") Long roleId, @RequestParam("companyId") Long companyId, HttpSession session) {
		session.setAttribute("roleId", roleId);
		session.setAttribute("companyId", companyId);
		
		return "redirect:/home/index";
	}
}
