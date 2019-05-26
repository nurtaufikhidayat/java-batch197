package com.xsis.batch197.model;

import java.util.ArrayList;
import java.util.List;

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
@Table(name="kelas")
public class KelasModel {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "kelas_seq")
    @TableGenerator(name = "kelas_seq", table = "tbl_sequences", pkColumnName = "seq_id", valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
    @Column(name = "id")
	private int id;
	
	@Column(name="kd_kelas", length = 10)
	private String kdKelas;
	
	@Column(name="nm_kelas", length = 100)
	private String nmKelas;
	
	@Column(name="dosen_id")
	private int dosenId;
	
	@Column(name="matakuliah_id")
	private int matakuliahId;
	
	@Column(name="ruang_id")
	private int ruangId;
	
	@OneToMany(mappedBy="kelas")
	private List<KelasdetailModel> listKelasdetail = new ArrayList<KelasdetailModel>();
	
	public List<KelasdetailModel> getListKelasdetail() {
		return listKelasdetail;
	}

	public void setListKelasdetail(List<KelasdetailModel> listKelasdetail) {
		this.listKelasdetail = listKelasdetail;
	}

	@ManyToOne
	@JoinColumn(name="dosen_id", foreignKey=@ForeignKey(name="fk_kelas_dosen"), insertable= false, updatable= false)
	private DosenModel dosen;
	
	@ManyToOne
	@JoinColumn(name="matakuliah_id", foreignKey=@ForeignKey(name="fk_kelas_matakuliah"), insertable= false, updatable= false)
	private MatakuliahModel matakuliah;
	
	@ManyToOne
	@JoinColumn(name="ruang_id", foreignKey=@ForeignKey(name="fk_kelas_ruang"), insertable = false, updatable = false)
	private RuangModel ruang;

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

	public int getDosenId() {
		return dosenId;
	}

	public void setDosenId(int dosenId) {
		this.dosenId = dosenId;
	}

	public int getMatakuliahId() {
		return matakuliahId;
	}

	public void setMatakuliahId(int matakuliahId) {
		this.matakuliahId = matakuliahId;
	}

	public int getRuangId() {
		return ruangId;
	}

	public void setRuangId(int ruangId) {
		this.ruangId = ruangId;
	}

	public DosenModel getDosen() {
		return dosen;
	}

	public void setDosen(DosenModel dosen) {
		this.dosen = dosen;
	}

	public MatakuliahModel getMatakuliah() {
		return matakuliah;
	}

	public void setMatakuliah(MatakuliahModel matakuliah) {
		this.matakuliah = matakuliah;
	}

	public RuangModel getRuang() {
		return ruang;
	}

	public void setRuang(RuangModel ruang) {
		this.ruang = ruang;
	}
	
}
