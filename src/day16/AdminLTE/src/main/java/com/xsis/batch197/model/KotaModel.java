package com.xsis.batch197.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tbl_kota")
public class KotaModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="kota_idx")
	@TableGenerator(name="kota_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id")
	private Long id;
	
	@Column(name="kd_kota", nullable=false, length=10)
	private String kdKota;
	
	@Column(name="nm_kota", nullable=false, length=120)
	private String nmKota;
	
	@Column(name="provinsi_id", nullable=false)
	private Long provinsiId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKdKota() {
		return kdKota;
	}

	public void setKdKota(String kdKota) {
		this.kdKota = kdKota;
	}

	public String getNmKota() {
		return nmKota;
	}

	public void setNmKota(String nmKota) {
		this.nmKota = nmKota;
	}

	public Long getProvinsiId() {
		return provinsiId;
	}

	public void setProvinsiId(Long provinsiId) {
		this.provinsiId = provinsiId;
	}
}
