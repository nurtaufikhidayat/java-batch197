package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.batch197.model.KelasModel;
import com.xsis.batch197.repository.KelasRepo;

@Controller
public class KelasController {
	
	@Autowired
	private KelasRepo kelasRepo;
	
	@RequestMapping(value = "/kelas/index")
	public String index() {
		return "/kelas/index";
	}
	
	@RequestMapping(value="/kelas/save")
	public String save(@ModelAttribute KelasModel kelas) {
		kelasRepo.save(kelas);
		return "redirect:/kelas/list";
	}
	
	@RequestMapping(value="/kelas/list")
	public String list(Model kirim) {
		List<KelasModel> kelasList = kelasRepo.findAll();
		kirim.addAttribute("kelasList", kelasList);
		return "kelas/list";
	}
	
	@RequestMapping(value="/kelas/edit/{id}")
	public String edit(Model kirim, @PathVariable(name="id")Integer id) {
		KelasModel kelasEdit = kelasRepo.findById(id).orElse(null);
		kirim.addAttribute("kelasEdit", kelasEdit);
		return "kelas/edit";
	}
	
	@RequestMapping(value="/kelas/hapus/{id}")
	public String hapus(@PathVariable(name="id")Integer id) {
		KelasModel kelasEdit = kelasRepo.findById(id).orElse(null);
		kelasRepo.delete(kelasEdit);
		return "redirect:/kelas/list";
	}
}
