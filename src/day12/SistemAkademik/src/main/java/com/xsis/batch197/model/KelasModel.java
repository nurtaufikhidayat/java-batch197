package com.xsis.batch197.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="kelas")
public class KelasModel {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "kelas_seq")
    @TableGenerator(name = "kelas_seq", table = "tbl_sequences", pkColumnName = "seq_id", valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
    @Column(name = "id")
	private int id;
	
	@Column(name="kd_kelas", length = 10)
	private String kdKelas;
	
	@Column(name="nm_kelas", length = 50)
	private String nmKelas;
	
	@Column(name="kd_dosen", length = 10 )
	private String kdDosen;
	
	@Column(name="kd_mk", length = 10)
	private String kdMatakuliah;
	
	@Column(name="kd_ruang", length = 10)
	private String kdRuang;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKdKelas() {
		return kdKelas;
	}

	public void setKdKelas(String kdKelas) {
		this.kdKelas = kdKelas;
	}

	public String getNmKelas() {
		return nmKelas;
	}

	public void setNmKelas(String nmKelas) {
		this.nmKelas = nmKelas;
	}

	public String getKdDosen() {
		return kdDosen;
	}

	public void setKdDosen(String kdDosen) {
		this.kdDosen = kdDosen;
	}

	public String getKdMatakuliah() {
		return kdMatakuliah;
	}

	public void setKdMatakuliah(String kdMatakuliah) {
		this.kdMatakuliah = kdMatakuliah;
	}

	public String getKdRuang() {
		return kdRuang;
	}

	public void setKdRuang(String kdRuang) {
		this.kdRuang = kdRuang;
	}
	
}
