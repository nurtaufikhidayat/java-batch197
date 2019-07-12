package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xsis.batch197.model.XAddressBookModel;
import com.xsis.batch197.repository.XAddressBookRepo;

@RestController
@RequestMapping("/api")
public class ApiUserController extends BaseController {
	@Autowired
	private XAddressBookRepo userRepo;

	@GetMapping(value = "user")
	public List<XAddressBookModel> listUser() {
		return userRepo.findAll();
	}

	@GetMapping(value = "user/get/{id}")
	public XAddressBookModel getUser(@PathVariable("id") Long id) {
		return userRepo.findById(id).orElse(new XAddressBookModel());
	}

	@PostMapping(value = "user/{username}")
	public XAddressBookModel lockUser(@PathVariable("username") String username) {
		// get data lewat repo
		XAddressBookModel user = this.userRepo.findByEmail(username);
		if (user != null) {
			// mengganti user locked =>1
			user.setIsLocked(1);
			// simpan user
			this.userRepo.save(user);
		}
		return user;
	}

}