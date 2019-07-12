package com.xsis.batch197.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.xsis.batch197.model.XCompanyModel;
import com.xsis.batch197.model.XMenuModel;
import com.xsis.batch197.model.XRoleModel;
import com.xsis.batch197.repository.XCompanyRepo;
import com.xsis.batch197.repository.XMenuRepo;
import com.xsis.batch197.repository.XRoleRepo;

@ControllerAdvice
public class BaseMenuController {
	@Autowired
	private XMenuRepo menuRepo;

	@Autowired
	private XRoleRepo roleRepo;

	@Autowired
	private XCompanyRepo compRepo;

	@ModelAttribute
	public void addAttribute(Model model, HttpSession session) {
		// main menu
		model.addAttribute("menuList", this.menuRepo.findByMenuType("SIDEBAR", Sort.by("menuOrder").ascending()));
		// biodata menu
		model.addAttribute("biodataMenuList", this.menuRepo.findByMenuType("BIODATA", Sort.by("menuOrder").ascending()));
		
		
		if (session.getAttribute("roleId") != null) {
			Long roleId = Long.parseLong(session.getAttribute("roleId").toString());
			if (roleId != 0) {
				XRoleModel role = this.roleRepo.findById(roleId).orElse(null);
				model.addAttribute("role", role);
			}
		}

		if (session.getAttribute("companyId") != null) {
			Long companyId = Long.parseLong(session.getAttribute("companyId").toString());
			if (companyId != 0) {
				XCompanyModel company = this.compRepo.findById(companyId).orElse(null);
				model.addAttribute("company", company);
			}
		}
	}
}
