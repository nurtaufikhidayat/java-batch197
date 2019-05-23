package com.xsis.batch197.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "matakuliah")
public class MatakuliahModel {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "matakuliah_seq")
    @TableGenerator(name = "matakuliah_seq", table = "tbl_sequences", pkColumnName = "seq_id", valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
    @Column(name = "id")
    private int id;
	
	@Column(name="KD_MK", length = 10)
	private String kdMatakuliah;
	
	@Column(name="NM_MK", length = 50)
	private String nmMatakuliah;

	@Column(name="SKS")
	private int sks;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKdMatakuliah() {
		return kdMatakuliah;
	}

	public void setKdMatakuliah(String kdMatakuliah) {
		this.kdMatakuliah = kdMatakuliah;
	}

	public String getNmMatakuliah() {
		return nmMatakuliah;
	}

	public void setNmMatakuliah(String nmMatakuliah) {
		this.nmMatakuliah = nmMatakuliah;
	}

	public int getSks() {
		return sks;
	}

	public void setSks(int sks) {
		this.sks = sks;
	}

	public String getKdJurusan() {
		return kdJurusan;
	}

	public void setKdJurusan(String kdJurusan) {
		this.kdJurusan = kdJurusan;
	}

	@Column(name="KD_JURUSAN", length =10)
	private String kdJurusan;
}
