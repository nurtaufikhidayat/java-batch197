package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.batch197.model.FakultasModel;
import com.xsis.batch197.model.JurusanModel;
import com.xsis.batch197.repository.FakultasRepo;
import com.xsis.batch197.repository.JurusanRepo;

@Controller
public class JurusanController {
	@Autowired
	private JurusanRepo jurusanRepo;
	
	@Autowired
	private FakultasRepo fakultasRepo;

	@RequestMapping(value="/jurusan/index")
	public String index(Model fakultas) {
		List<FakultasModel> listFakultas = fakultasRepo.findAll();
		fakultas.addAttribute("listFakultas", listFakultas);
		return "/jurusan/index";
	}
	
	@RequestMapping(value="/jurusan/save")
	public String save(@ModelAttribute JurusanModel jurusan) {
		jurusanRepo.save(jurusan);
		return "redirect:/jurusan/list";
	}
	
	@RequestMapping(value="/jurusan/list")
	public String list(Model kirim) {
		List<JurusanModel> jurusanList = jurusanRepo.findAll();
		kirim.addAttribute("jurusanList", jurusanList);
		return "jurusan/list";
	}
	
	@RequestMapping(value="/jurusan/edit/{id}")
	public String edit(Model kirim, @PathVariable(name ="id")Integer id) {
		JurusanModel jurusanEdit=jurusanRepo.findById(id).orElse(null);
		kirim.addAttribute("jurusanEdit", jurusanEdit);
		List<FakultasModel> listFakultas = fakultasRepo.findAll();
		kirim.addAttribute("listFakultas", listFakultas);
		return "jurusan/edit";
	}
	
	@RequestMapping(value="/jurusan/hapus/{id}")
	public String hapus(@PathVariable(name = "id") Integer id) {
	    JurusanModel jurusanEdit=jurusanRepo.findById(id).orElse(null);
	    jurusanRepo.delete(jurusanEdit);
	    return "redirect:/jurusan/list";
	}
	
	
	
}
