package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
 
import com.xsis.batch197.model.BiodataModel;
import com.xsis.batch197.repository.BiodataRepo;

@Controller
public class HomeController {
    @Autowired
    private BiodataRepo repo;
   
    @RequestMapping(value="/home/index")
    public String index() {
        return "/home/index";
    }
   
    @RequestMapping(value="/home/save")
    public String save(@ModelAttribute BiodataModel biodata) {
        repo.save(biodata);
        return "redirect:/home/list";
    }
    @RequestMapping(value="/home/list")
    public String list(Model kirim) {
        List<BiodataModel> biodataList = repo.findAll(); //object bioadataList bertipe data list 
        kirim.addAttribute("biodataList", biodataList);
        return "home/list";
    }
   
    @RequestMapping(value="/home/edit/{id}")
    public String edit(Model kirim, @PathVariable(name = "id") Integer id) {
        BiodataModel biodataEdit=repo.findById(id).orElse(null);
        kirim.addAttribute("biodataEdit", biodataEdit);
        return "home/edit";
    }
    @RequestMapping(value="/home/hapus/{id}")
    public String hapus(@PathVariable(name = "id") Integer id) {
        BiodataModel biodataEdit=repo.findById(id).orElse(null);
        repo.delete(biodataEdit);
        return "redirect:/home/list";
    }
 
}