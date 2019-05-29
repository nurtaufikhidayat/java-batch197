package com.xsis.batch197.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tbl_kecamatan")
public class KecamatanModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="kecamatan_idx")
	@TableGenerator(name="kecamatan_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id")
	private Long id;
	
	@Column(name="kd_kecamatan", nullable=false, length=10)
	private String kdKecamatan;
	
	@Column(name="nm_kecamatan", nullable=false, length=120)
	private String nmKecamatan;
	
	@Column(name="kota_id", nullable=false)
	private Long kotaId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKdKecamatan() {
		return kdKecamatan;
	}

	public void setKdKecamatan(String kdKecamatan) {
		this.kdKecamatan = kdKecamatan;
	}

	public String getNmKecamatan() {
		return nmKecamatan;
	}

	public void setNmKecamatan(String nmKecamatan) {
		this.nmKecamatan = nmKecamatan;
	}

	public Long getKotaId() {
		return kotaId;
	}

	public void setKotaId(Long kotaId) {
		this.kotaId = kotaId;
	}
}
