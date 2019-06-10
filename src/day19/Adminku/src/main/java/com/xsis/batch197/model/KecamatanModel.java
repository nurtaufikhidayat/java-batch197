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
@Table(name="tbl_kecamatan")
public class KecamatanModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="kecamatan_idx")
	@TableGenerator(name="kecamatan_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id")
	private Long id;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="kd_kecamatan", nullable=false, length=10)
	private String kdKecamatan;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="nm_kecamatan", nullable=false, length=120)
	private String nmKecamatan;
	
	@NotNull
	@Column(name="kota_id", nullable=false)
	private Long kotaId;
	
	@ManyToOne
	@JoinColumn(name="kota_id", foreignKey=@ForeignKey(name="fk_kec_kota"), updatable=false, insertable=false)
	private KotaModel kota;

	@OneToMany(mappedBy="kecamatan")
	private List<KelurahanModel> listkelurahan = new ArrayList<KelurahanModel>();

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

	public KotaModel getKota() {
		return kota;
	}

	public void setKota(KotaModel kota) {
		this.kota = kota;
	}

	public List<KelurahanModel> getListkelurahan() {
		return listkelurahan;
	}

	public void setListkelurahan(List<KelurahanModel> listkelurahan) {
		this.listkelurahan = listkelurahan;
	}
}
