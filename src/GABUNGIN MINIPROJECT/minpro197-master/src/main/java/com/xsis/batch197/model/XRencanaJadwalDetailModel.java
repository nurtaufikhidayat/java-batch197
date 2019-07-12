package com.xsis.batch197.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "x_rencana_jadwal_detail")
public class XRencanaJadwalDetailModel extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_rencana_jadwal_detail_idx")
	@TableGenerator(name = "x_rencana_jadwal_detail_idx", table = "x_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
	@Column(name = "id", length = 11)
	private Long id;

	@Column(name = "rencana_jadwal_id", length = 11, nullable = false)
	private Long rencanaJadwalId;

	@Column(name = "biodata_id", length = 11, nullable = false)
	private Long biodataId;

	public XRencanaJadwalDetailModel() {
		super();
	}
	
	public XRencanaJadwalDetailModel(Long userId) {
		super(userId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRencanaJadwalId() {
		return rencanaJadwalId;
	}

	public void setRencanaJadwalId(Long rencanaJadwalId) {
		this.rencanaJadwalId = rencanaJadwalId;
	}

	public Long getBiodataId() {
		return biodataId;
	}

	public void setBiodataId(Long biodataId) {
		this.biodataId = biodataId;
	}
}
