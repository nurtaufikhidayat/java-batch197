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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_kota")
public class KotaModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="kota_idx")
	@TableGenerator(name="kota_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id")
	private Long id;
	
	@NotBlank
	@NotEmpty
	@Column(name="kd_kota", nullable=false, length=10)
	private String kdKota;
	
	@NotBlank
	@NotEmpty
	@Column(name="nm_kota", nullable=false, length=120)
	private String nmKota;
	
	@NotNull
	@Column(name="provinsi_id", nullable=false)
	private Long provinsiId;
	
	@ManyToOne
	@JoinColumn(name="provinsi_id", foreignKey=@ForeignKey(name="fk_kota_prop"), updatable= false, insertable= false)
	private ProvinsiModel provinsi;
	
	@OneToMany(mappedBy="kota")
	private List<KecamatanModel> listKecamatan = new ArrayList<KecamatanModel>();

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

	public ProvinsiModel getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(ProvinsiModel provinsi) {
		this.provinsi = provinsi;
	}

	public List<KecamatanModel> getListKecamatan() {
		return listKecamatan;
	}

	public void setListKecamatan(List<KecamatanModel> listKecamatan) {
		this.listKecamatan = listKecamatan;
	}
}
