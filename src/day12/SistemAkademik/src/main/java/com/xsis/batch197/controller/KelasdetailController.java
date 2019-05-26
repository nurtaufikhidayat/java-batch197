package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.batch197.model.BobotnilaiModel;
import com.xsis.batch197.model.DosenModel;
import com.xsis.batch197.model.KelasModel;
import com.xsis.batch197.model.KelasdetailModel;
import com.xsis.batch197.model.MahasiswaModel;
import com.xsis.batch197.model.MatakuliahModel;
import com.xsis.batch197.model.RuangModel;
import com.xsis.batch197.repository.BobotnilaiRepo;
import com.xsis.batch197.repository.KelasRepo;
import com.xsis.batch197.repository.KelasdetailRepo;
import com.xsis.batch197.repository.MahasiswaRepo;

@Controller
public class KelasdetailController {
	
	@Autowired
	private KelasdetailRepo kelasdetailRepo;
	
	@Autowired
	private KelasRepo kelasRepo;
	
	@Autowired
	private MahasiswaRepo mahasiswaRepo;
	
	@Autowired
	private BobotnilaiRepo bobotnilaiRepo;

	
	@RequestMapping(value="/kelasdetail/index")
	public String index(Model kirim) {
		List<KelasModel> listKelas = kelasRepo.findAll();
		kirim.addAttribute("listKelas", listKelas);
		List<MahasiswaModel> listMahasiswa = mahasiswaRepo.findAll();
		kirim.addAttribute("listMahasiswa", listMahasiswa);
		List<BobotnilaiModel> listBobotnilai = bobotnilaiRepo.findAll();
		kirim.addAttribute("listBobotnilai", listBobotnilai);
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
		List<KelasModel> listKelas = kelasRepo.findAll();
		kirim.addAttribute("listKelas", listKelas);
		List<MahasiswaModel> listMahasiswa = mahasiswaRepo.findAll();
		kirim.addAttribute("listMahasiswa", listMahasiswa);
		List<BobotnilaiModel> listBobotnilai = bobotnilaiRepo.findAll();
		kirim.addAttribute("listBobotnilai", listBobotnilai);
		return "kelasdetail/edit";
	}
	
	@RequestMapping(value="/kelasdetail/hapus/{id}")
	public String hapus(@PathVariable(name="id")Integer id) {
		KelasdetailModel kelasdetailEdit = kelasdetailRepo.findById(id).orElse(null);
		kelasdetailRepo.delete(kelasdetailEdit);
		return "redirect:/kelasdetail/list";
	}
	
}
