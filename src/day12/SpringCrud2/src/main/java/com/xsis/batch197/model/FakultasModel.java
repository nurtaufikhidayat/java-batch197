package com.xsis.batch197.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;


@Entity
public class FakultasModel {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "biodata_seq")
    @TableGenerator(name = "biodata_seq", table = "tbl_sequences", pkColumnName = "seq_id", valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
	@Column(name = "id")
    private int id;
	
	@Column(name="KD_FAKULTAS", length = 10)
	private String kdFakultas;
	
	@Column(name="NM_FAKULTAS", length = 150)
	private String nmFakultas;

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
