package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.batch197.model.MatakuliahModel;
import com.xsis.batch197.repository.MatakuliahRepo;

@Controller
public class MatakuliahController {
	@Autowired
	private MatakuliahRepo repo;

	@RequestMapping(value = "/matakuliah/index")
	public String index() {
		return "/matakuliah/index";
	}

	@RequestMapping(value = "/matakuliah/save")
	public String save(@ModelAttribute MatakuliahModel matakuliah) {
		repo.save(matakuliah);
		return "redirect:/matakuliah/list";
	}

	@RequestMapping(value = "/matakuliah/list")
	public String list(Model kirim) {
		List<MatakuliahModel> matakuliahList = repo.findAll();
		kirim.addAttribute("matakuliahList", matakuliahList);
		return "matakuliah/list";
	}

	@RequestMapping(value = "/matakuliah/edit/{id}")
	public String edit(Model kirim, @PathVariable(name = "id") Integer id) {
		MatakuliahModel matakuliahEdit = repo.findById(id).orElse(null);
		kirim.addAttribute("matakuliahEdit", matakuliahEdit);
		return "matakuliah/edit";
	}

	@RequestMapping(value = "/matakuliah/hapus/{id}")
	public String hapus(@PathVariable(name = "id") Integer id) {
		MatakuliahModel matakuliahEdit = repo.findById(id).orElse(null);
		repo.delete(matakuliahEdit);
		return "redirect:/matakuliah/list";
	}
}
