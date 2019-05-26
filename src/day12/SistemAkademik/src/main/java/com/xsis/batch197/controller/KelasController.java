package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.xsis.batch197.model.DosenModel;
import com.xsis.batch197.model.KelasModel;
import com.xsis.batch197.model.MatakuliahModel;
import com.xsis.batch197.model.RuangModel;
import com.xsis.batch197.repository.DosenRepo;
import com.xsis.batch197.repository.KelasRepo;
import com.xsis.batch197.repository.MatakuliahRepo;
import com.xsis.batch197.repository.RuangRepo;

@Controller
public class KelasController {
	
	@Autowired
	private KelasRepo kelasRepo;
	
	@Autowired
	private DosenRepo dosenRepo;
	
	@Autowired
	private MatakuliahRepo matakuliahRepo;
	
	@Autowired
	private RuangRepo ruangRepo;
	
	@RequestMapping(value = "/kelas/index")
	public String index(Model kirim) {
		List<DosenModel> listDosen = dosenRepo.findAll();
		kirim.addAttribute("listDosen", listDosen);
		List<MatakuliahModel> listMatakuliah = matakuliahRepo.findAll();
		kirim.addAttribute("listMatakuliah", listMatakuliah);
		List<RuangModel> listRuang = ruangRepo.findAll();
		kirim.addAttribute("listRuang", listRuang);
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
		List<DosenModel> listDosen = dosenRepo.findAll();
		kirim.addAttribute("listDosen", listDosen);
		List<MatakuliahModel> listMatakuliah = matakuliahRepo.findAll();
		kirim.addAttribute("listMatakuliah", listMatakuliah);
		List<RuangModel> listRuang = ruangRepo.findAll();
		kirim.addAttribute("listRuang", listRuang);
		return "kelas/edit";
	}
	
	@RequestMapping(value="/kelas/hapus/{id}")
	public String hapus(@PathVariable(name="id")Integer id) {
		KelasModel kelasEdit = kelasRepo.findById(id).orElse(null);
		kelasRepo.delete(kelasEdit);
		return "redirect:/kelas/list";
	}
}
