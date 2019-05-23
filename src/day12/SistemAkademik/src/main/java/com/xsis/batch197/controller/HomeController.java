package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.batch197.model.FakultasModel;
import com.xsis.batch197.repository.FakultasRepo;

@Controller
public class HomeController {
	@Autowired
	private FakultasRepo fakultasRepo;
	
	@RequestMapping(value="/home/fakultas")
	public String fakultas() {
		return "/home/fakultas";
	}
	@RequestMapping(value="/home/save")
    public String save(@ModelAttribute FakultasModel fakultas) {
        fakultasRepo.save(fakultas);
        return "redirect:/home/list";
	}
	@RequestMapping(value="/home/list")
    public String list(Model kirim) {
        List<FakultasModel> fakultasList = fakultasRepo.findAll(); //object fakultasList bertipe data list 
        kirim.addAttribute("fakultasList", fakultasList);
        return "home/list";
	}
	
	@RequestMapping(value="/home/edit/{id}")
    public String edit(Model kirim, @PathVariable(name = "id") Integer id) {
        FakultasModel fakultasEdit=fakultasRepo.findById(id).orElse(null);
        kirim.addAttribute("fakultasEdit", fakultasEdit);
        return "home/edit";
    }
	
	@RequestMapping(value="/home/hapus/{id}")
    public String hapus(@PathVariable(name = "id") Integer id) {
        FakultasModel fakultasEdit=fakultasRepo.findById(id).orElse(null);
        fakultasRepo.delete(fakultasEdit);
        return "redirect:/home/list";
	}
}
