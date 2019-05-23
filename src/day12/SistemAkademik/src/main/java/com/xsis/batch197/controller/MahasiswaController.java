package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.batch197.model.MahasiswaModel;
import com.xsis.batch197.repository.MahasiswaRepo;

@Controller
public class MahasiswaController {
	@Autowired
	private MahasiswaRepo mahasiswaRepo;
	
	@RequestMapping(value = "/mahasiswa/index")
	public String index() {
		return "mahasiswa/index";
	}
	@RequestMapping(value="/mahasiswa/save")
	public String save(@ModelAttribute MahasiswaModel mahasiswa) {
		mahasiswaRepo.save(mahasiswa);
		return "redirect:/mahasiswa/list";
	}
	@RequestMapping(value = "/mahasiswa/list")
	public String list(Model kirim) {
		List<MahasiswaModel> mahasiswaList = mahasiswaRepo.findAll();
		kirim.addAttribute("mahasiswaList", mahasiswaList);
		return "mahasiswa/list";
	}
	
	@RequestMapping(value="/mahasiswa/edit/{id}")
	public String edit(Model kirim, @PathVariable(name="id")Integer id) {
		MahasiswaModel mahasiswaEdit = mahasiswaRepo.findById(id).orElse(null);
		kirim.addAttribute("mahasiswaEdit", mahasiswaEdit);
		return "mahasiswa/edit";
	}
	
	@RequestMapping(value="/mahasiswa/hapus/{id}")
	public String hapus(@PathVariable(name="id") Integer id) {
		MahasiswaModel mahasiswaEdit = mahasiswaRepo.findById(id).orElse(null);
		mahasiswaRepo.delete(mahasiswaEdit);
		return "redirect:/mahasiswa/list";
	}
	
	
	
	
}
