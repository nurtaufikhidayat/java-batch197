package com.xsis.batch197.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(name = "kelas_id")
	private int kelasId;
	
	@Column(name ="nim_id")
	private int nimId;
	
	@Column(name="nilai_id")
	private int nilaiId;
	
	@ManyToOne
	@JoinColumn(name="kelas_id", foreignKey=@ForeignKey(name="fk_kelasdetail_kelas"), insertable=false, updatable=false)
	private KelasModel kelas;
	
	@ManyToOne
	@JoinColumn(name="nim_id", foreignKey=@ForeignKey(name="fk_kelasdetail_mahasiswa"), insertable=false, updatable=false)
	private MahasiswaModel mahasiswa;
	
	@ManyToOne
	@JoinColumn(name="nilai_id", foreignKey=@ForeignKey(name="fk_kelasdetail_bobotnilai"), insertable=false, updatable=false)
	private BobotnilaiModel bobotnilai;
	
	public int getKelasId() {
		return kelasId;
	}

	public void setKelasId(int kelasId) {
		this.kelasId = kelasId;
	}

	public int getNimId() {
		return nimId;
	}

	public void setNimId(int nimId) {
		this.nimId = nimId;
	}

	public int getNilaiId() {
		return nilaiId;
	}

	public void setNilaiId(int nilaiId) {
		this.nilaiId = nilaiId;
	}

	public KelasModel getKelas() {
		return kelas;
	}

	public void setKelas(KelasModel kelas) {
		this.kelas = kelas;
	}

	public MahasiswaModel getMahasiswa() {
		return mahasiswa;
	}

	public void setMahasiswa(MahasiswaModel mahasiswa) {
		this.mahasiswa = mahasiswa;
	}

	public BobotnilaiModel getBobotnilai() {
		return bobotnilai;
	}

	public void setBobotnilai(BobotnilaiModel bobotnilai) {
		this.bobotnilai = bobotnilai;
	}

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
