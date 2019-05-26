package com.xsis.batch197.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="bobotnilai")
public class BobotnilaiModel {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "bobotnilai_seq")
    @TableGenerator(name = "bobotnilai_seq", table = "tbl_sequences", pkColumnName = "seq_id", valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
    @Column(name = "id")
    private int id;
	
	@Column(name="kd_nilai", length = 2)
	private String kdNilai;
	
	@Column(name="bobot")
	private int bobot;

	public int getId() {
		return id;
	}
	
	@OneToMany(mappedBy="bobotnilai")
	private List<KelasdetailModel> listKelasdetail = new ArrayList<KelasdetailModel>();

	public List<KelasdetailModel> getListKelasdetail() {
		return listKelasdetail;
	}


	public void setListKelasdetail(List<KelasdetailModel> listKelasdetail) {
		this.listKelasdetail = listKelasdetail;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getKdNilai() {
		return kdNilai;
	}


	public void setKdNilai(String kdNilai) {
		this.kdNilai = kdNilai;
	}


	public int getBobot() {
		return bobot;
	}


	public void setBobot(int bobot) {
		this.bobot = bobot;
	}
}
