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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_provinsi")
public class ProvinsiModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="provinsi_idx")
	@TableGenerator(name="provinsi_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id")
	private Long id;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="kd_provinsi", nullable=false, length=10)
	private String kdProvinsi;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="nm_provinsi", nullable=false, length=120)
	private String nmProvinsi;
	
	@OneToMany(mappedBy="provinsi")
	private List<KotaModel> listKota = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKdProvinsi() {
		return kdProvinsi;
	}

	public void setKdProvinsi(String kdProvinsi) {
		this.kdProvinsi = kdProvinsi;
	}

	public String getNmProvinsi() {
		return nmProvinsi;
	}

	public void setNmProvinsi(String nmProvinsi) {
		this.nmProvinsi = nmProvinsi;
	}

	public List<KotaModel> getListKota() {
		return listKota;
	}

	public void setListKota(List<KotaModel> listKota) {
		this.listKota = listKota;
	}
	
}
