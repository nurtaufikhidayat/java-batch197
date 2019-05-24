package com.xsis.batch197.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name ="kelasdetail")
public class KelasdetailModel {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "kelasdetail_seq")
    @TableGenerator(name = "kelasdetail_seq", table = "tbl_sequences", pkColumnName = "seq_id", valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
    @Column(name = "id")
    private int id;
	
	@Column(name="kd_kelas", length = 10)
	private String kdKelas;
	
	@Column(name="nim", length = 10)
	private String nim;
	
	@Column(name="kd_nilai", length = 2 )
	private String kdNilai;
	
	@Column(name="status", length = 10)
	private String status;

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

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getKdNilai() {
		return kdNilai;
	}

	public void setKdNilai(String kdNilai) {
		this.kdNilai = kdNilai;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
