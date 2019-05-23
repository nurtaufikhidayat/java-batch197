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
@Table(name ="jurusan")
public class JurusanModel {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "jurusan_seq")
    @TableGenerator(name = "jurusan_seq", table = "tbl_sequences", pkColumnName = "seq_id", valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
    @Column(name = "id")
    private int id;
	
	@Column(name="kd_jurusan", length = 10)
	private String kdJurusan;
	
	@Column(name="nm_jurusan", length = 50)
	private String nmJurusan;
	
	@Column(name="fakultas_id")
	private int fakultasId;
	
	@OneToMany(mappedBy="jurusan")
	private List<MahasiswaModel> listMhs = new ArrayList<MahasiswaModel>();
	
	@ManyToOne
	@JoinColumn(name ="fakultas_id", foreignKey=@ForeignKey(name="fk_jurusan_fakultas"), updatable=false, insertable=false)
	private FakultasModel fakultas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKdJurusan() {
		return kdJurusan;
	}

	public void setKdJurusan(String kdJurusan) {
		this.kdJurusan = kdJurusan;
	}

	public String getNmJurusan() {
		return nmJurusan;
	}

	public void setNmJurusan(String nmJurusan) {
		this.nmJurusan = nmJurusan;
	}

	public int getFakultasId() {
		return fakultasId;
	}

	public void setFakultasId(int fakultasId) {
		this.fakultasId = fakultasId;
	}

	public List<MahasiswaModel> getListMhs() {
		return listMhs;
	}

	public void setListMhs(List<MahasiswaModel> listMhs) {
		this.listMhs = listMhs;
	}

	public FakultasModel getFakultas() {
		return fakultas;
	}

	public void setFakultas(FakultasModel fakultas) {
		this.fakultas = fakultas;
	}

}
