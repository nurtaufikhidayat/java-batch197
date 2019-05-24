package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.batch197.model.RuangModel;
import com.xsis.batch197.repository.RuangRepo;

@Controller
public class RuangController {
	@Autowired
	private RuangRepo ruangRepo;
	
	@RequestMapping(value = "/ruang/index")
	public String index() {
		return "/ruang/index";
	}
	
	@RequestMapping(value="/ruang/save")
	public String save(@ModelAttribute RuangModel ruang) {
		ruangRepo.save(ruang);
		return "redirect:/ruang/list";
	}
	
	@RequestMapping(value="/ruang/list")
	public String list(Model kirim) {
		List<RuangModel> ruangList = ruangRepo.findAll();
		kirim.addAttribute("ruangList", ruangList);
		return "ruang/list";
	}
	@RequestMapping(value = "/ruang/edit/{id}")
	public String edit(Model kirim, @PathVariable(name ="id")Integer id) {
		RuangModel ruangEdit = ruangRepo.findById(id).orElse(null);
		kirim.addAttribute("ruangEdit", ruangEdit);
		return "ruang/edit";
		
	}
	
	@RequestMapping(value ="/ruang/hapus/{id}")
	public String hapus(@PathVariable(name ="id")Integer id) {
		RuangModel ruangEdit = ruangRepo.findById(id).orElse(null);
		ruangRepo.delete(ruangEdit);
		return "redirect:/ruang/list";
	}
	
	
}
