package com.xsis.batch197.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.xsis.batch197.repository.XMenuRepo;

@ControllerAdvice
public class BaseMenuController {
	@Autowired
	private XMenuRepo menuRepo;
	
	@ModelAttribute
	public void addAttribute(Model model) {
		model.addAttribute("menuList", this.menuRepo.findByMenuType("SIDEBAR"));
	}
}
