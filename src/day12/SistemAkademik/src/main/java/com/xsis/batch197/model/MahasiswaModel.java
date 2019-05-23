package com.xsis.batch197.model;

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
@Table(name="mahasiswa")
public class MahasiswaModel {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "mahasiswa_seq")
    @TableGenerator(name = "mahasiswa_seq", table = "tbl_sequences", pkColumnName = "seq_id", valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
    @Column(name = "id")
    private int id;
	
	@Column(name="nim", length = 10)
	private String nim;
	
	@Column(name="nm_mhs", length = 100)
	private String nmMhs;
	
	@Column(name="jk", length = 10)
	private String jk;
	
	@Column(name="alamat", length = 50)
	private String alamat;
	
	@Column(name="jurusan_id")
	private int jurusanId;
	
	@Column(name="status", length = 10)
	private String status;
	
	@ManyToOne
	@JoinColumn(name="jurusan_id", foreignKey=@ForeignKey(name="fk_mahasiswa_jurusan"), insertable= false, updatable = false)
	private JurusanModel jurusan;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getNmMhs() {
		return nmMhs;
	}

	public void setNmMhs(String nmMhs) {
		this.nmMhs = nmMhs;
	}

	public String getJk() {
		return jk;
	}

	public void setJk(String jk) {
		this.jk = jk;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public int getJurusanId() {
		return jurusanId;
	}

	public void setJurusanId(int jurusanId) {
		this.jurusanId = jurusanId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JurusanModel getJurusan() {
		return jurusan;
	}

	public void setJurusan(JurusanModel jurusan) {
		this.jurusan = jurusan;
	}
	
	
}
