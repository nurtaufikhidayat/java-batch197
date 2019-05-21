package com.xsis.batch197.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BiodataController {
	@RequestMapping(value="/biodata/add")
	public String index() {
		return "biodata/add";
	}
	@RequestMapping(value="/biodata/tabel")
	public String tabel() {
		return "biodata/tabel";
		
	}
	@RequestMapping(value="/biodata/nyoba")
	public String nyoba() {
		return "biodata/nyoba";
	}
}
