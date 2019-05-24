package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.batch197.model.KelasdetailModel;
import com.xsis.batch197.repository.KelasdetailRepo;

@Controller
public class KelasdetailController {
	
	@Autowired
	private KelasdetailRepo kelasdetailRepo;
	
	@RequestMapping(value="/kelasdetail/index")
	public String index() {
		return "kelasdetail/index";
	}
	
	@RequestMapping(value ="/kelasdetail/save")
	public String save(@ModelAttribute KelasdetailModel kelasdetail) {
		kelasdetailRepo.save(kelasdetail);
		return "redirect:/kelasdetail/list";
	}
	
	@RequestMapping(value="/kelasdetail/list")
	public String list(Model kirim) {
		List<KelasdetailModel> kelasdetailList = kelasdetailRepo.findAll();
		kirim.addAttribute("kelasdetailList", kelasdetailList);
		return "kelasdetail/list";
	}
	
	@RequestMapping(value="/kelasdetail/edit/{id}")
	public String edit(Model kirim, @PathVariable(name ="id")Integer id) {
		KelasdetailModel kelasdetailEdit = kelasdetailRepo.findById(id).orElse(null);
		kirim.addAttribute("kelasdetailEdit", kelasdetailEdit);
		return "kelasdetail/edit";
	}
	
	public String hapus(@PathVariable(name="id")Integer id) {
		KelasdetailModel kelasdetailEdit = kelasdetailRepo.findById(id).orElse(null);
		kelasdetailRepo.delete(kelasdetailEdit);
		return "redirect:/kelasdetail/list";
	}
	
}
