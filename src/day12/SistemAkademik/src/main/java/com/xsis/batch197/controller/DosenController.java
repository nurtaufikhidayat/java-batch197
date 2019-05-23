package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.batch197.model.DosenModel;
import com.xsis.batch197.repository.DosenRepo;

@Controller
public class DosenController {
	@Autowired
	private DosenRepo repo;

	@RequestMapping(value = "/dosen/index")
	public String index() {
		return "/dosen/index";
	}

	@RequestMapping(value = "/dosen/save")
	public String save(@ModelAttribute DosenModel dosen) {
		repo.save(dosen);
		return "redirect:/dosen/list";
	}

	@RequestMapping(value = "/dosen/list")
	public String list(Model kirim) {
		List<DosenModel> dosenList = repo.findAll();
		kirim.addAttribute("dosenList", dosenList);
		return "dosen/list";
	}

	@RequestMapping(value = "/dosen/edit/{id}")
	public String edit(Model kirim, @PathVariable(name = "id") Integer id) {
		DosenModel dosenEdit = repo.findById(id).orElse(null);
		kirim.addAttribute("dosenEdit", dosenEdit);
		return "dosen/edit";
	}

	@RequestMapping(value = "/dosen/hapus/{id}")
	public String hapus(@PathVariable(name = "id") Integer id) {
		DosenModel dosenEdit = repo.findById(id).orElse(null);
		repo.delete(dosenEdit);
		return "redirect:/dosen/list";
	}
}
