package com.xsis.batch197.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.xsis.batch197.model.XBiodataAttachmentModel;
import com.xsis.batch197.model.XBiodataModel;
import com.xsis.batch197.model.XKeahlianModel;
import com.xsis.batch197.model.XRiwayatPekerjaanModel;
import com.xsis.batch197.model.XRiwayatPelatihanModel;
import com.xsis.batch197.model.XRiwayatPendidikanModel;
import com.xsis.batch197.model.XSertifikasiModel;
import com.xsis.batch197.repository.XBiodataAttachmentRepo;
import com.xsis.batch197.repository.XBiodataRepo;
import com.xsis.batch197.repository.XKeahlianRepo;
import com.xsis.batch197.repository.XRiwayatPekerjaanRepo;
import com.xsis.batch197.repository.XRiwayatPelatihanRepo;
import com.xsis.batch197.repository.XRiwayatPendidikanRepo;
import com.xsis.batch197.repository.XSertifikasiRepo;

@Controller
public class ProfilController {
	
	@Autowired
	private XBiodataRepo repoBio;
	
	@Autowired
	private XRiwayatPendidikanRepo repoRiwpend;
	
	@Autowired 
	private XRiwayatPekerjaanRepo repoRiwpek;
	
	@Autowired
	private XKeahlianRepo repoKeahlian;
	
	@Autowired
	private XRiwayatPelatihanRepo repoRiwpel;
	
	@Autowired
	private XSertifikasiRepo repoSer;
	
	@Autowired
	private XBiodataAttachmentRepo repoBioaat;

	@GetMapping(value = "/pelamar/profile/{bid}")
	private ModelAndView index(@PathVariable("bid") Long biodataId) {
		// view profile
		ModelAndView view = new ModelAndView("profile/index");
		// get biodata Id
		XBiodataModel biodata = this.repoBio.findById(biodataId).orElse(null);
		view.addObject("biodata", biodata);
		
		List<XRiwayatPendidikanModel> listPendidikan = repoRiwpend.findAll();
		view.addObject("listPendidikan", listPendidikan);
		List<XRiwayatPekerjaanModel> listPekerjaan = repoRiwpek.findAll();
		view.addObject("listPekerjaan", listPekerjaan);
		List<XKeahlianModel> listKeahlian = repoKeahlian.findAll();
		view.addObject("listKeahlian", listKeahlian);
		List<XRiwayatPelatihanModel> listPelatihan = repoRiwpel.findAll();
		view.addObject("listPelatihan", listPelatihan);
		List<XSertifikasiModel> listSertifikasi = repoSer.findAll();
		view.addObject("listSertifikasi", listSertifikasi);
		List<XBiodataAttachmentModel> listAttch = repoBioaat.findAll();
		view.addObject("listAttch", listAttch);

		return view;
	}
}
