package com.xsis.batch197.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tbl_kelurahan")
public class KelurahanModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="kelurahan_idx")
	@TableGenerator(name="kelurahan_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id")
	private Long id;
	
	@Column(name="kd_kelurahan", nullable=false, length=10)
	private String kdKelurahan;
	
	@Column(name="nm_kelurahan", nullable=false, length=120)
	private String nmKelurahan;
	
	@Column(name="kecamatan_id", nullable=false)
	private Long kecamatanId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKdKelurahan() {
		return kdKelurahan;
	}

	public void setKdKelurahan(String kdKelurahan) {
		this.kdKelurahan = kdKelurahan;
	}

	public String getNmKelurahan() {
		return nmKelurahan;
	}

	public void setNmKelurahan(String nmKelurahan) {
		this.nmKelurahan = nmKelurahan;
	}

	public Long getKecamatanId() {
		return kecamatanId;
	}

	public void setKecamatanId(Long kecamatanId) {
		this.kecamatanId = kecamatanId;
	}
}
