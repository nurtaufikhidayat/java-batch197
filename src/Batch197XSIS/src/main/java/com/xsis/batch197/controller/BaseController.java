package com.xsis.batch197.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.xsis.batch197.model.XAddressBookModel;
import com.xsis.batch197.repository.XAddressBookRepo;

public class BaseController {
	@Autowired
	private XAddressBookRepo userRepo;

	public String getEmail() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String result = " -";
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			result = auth.getName();
		}
		return result;
	}

	public Long getAbuid() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Long result = Long.MIN_VALUE;
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			result = this.userRepo.findByEmail(auth.getName()).getId();
		}
		return result;
	}

	public XAddressBookModel getXAddressBookModel() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		XAddressBookModel result = new XAddressBookModel();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			result = this.userRepo.findByEmail(auth.getName());
		}
		return result;
	}
}
