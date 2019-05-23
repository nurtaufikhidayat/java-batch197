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
@Table(name ="fakultas")
public class FakultasModel {
	public List<JurusanModel> getListJurusan() {
		return listJurusan;
	}

	public void setListJurusan(List<JurusanModel> listJurusan) {
		this.listJurusan = listJurusan;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "fakultas_seq")
    @TableGenerator(name = "fakultas_seq", table = "tbl_sequences", pkColumnName = "seq_id", valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
    @Column(name = "id")
    private int id;
	
	@Column(name ="kd_fakultas", length = 10)
	private String kdFakultas;
	
	@Column(name ="nm_fakultas", length = 50)
	private String nmFakultas;
	
	@OneToMany(mappedBy ="fakultas")
	private List<JurusanModel> listJurusan = new ArrayList<JurusanModel>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKdFakultas() {
		return kdFakultas;
	}

	public void setKdFakultas(String kdFakultas) {
		this.kdFakultas = kdFakultas;
	}

	public String getNmFakultas() {
		return nmFakultas;
	}

	public void setNmFakultas(String nmFakultas) {
		this.nmFakultas = nmFakultas;
	}
}
