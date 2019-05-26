package com.xsis.batch197.model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Column(name="kd_mk", length = 10)
	private String kdMatakuliah;
	
	@Column(name="nm_mk", length = 100)
	private String nmMatakuliah;

	@Column(name="sks")
	private int sks;
	
	@Column(name="jurusan_id")
	private int jurusanId;
	
	@ManyToOne
	@JoinColumn(name="jurusan_id", foreignKey=@ForeignKey(name="fk_mahasiswa_jurusan"), insertable= false, updatable = false)
	private JurusanModel jurusan;
	
	@OneToMany(mappedBy = "matakuliah")
	private List<KelasModel> listKelas = new ArrayList<KelasModel>();

	public List<KelasModel> getListKelas() {
		return listKelas;
	}

	public void setListKelas(List<KelasModel> listKelas) {
		this.listKelas = listKelas;
	}

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

	public int getJurusanId() {
		return jurusanId;
	}

	public void setJurusanId(int jurusanId) {
		this.jurusanId = jurusanId;
	}

	public JurusanModel getJurusan() {
		return jurusan;
	}

	public void setJurusan(JurusanModel jurusan) {
		this.jurusan = jurusan;
	}
}
