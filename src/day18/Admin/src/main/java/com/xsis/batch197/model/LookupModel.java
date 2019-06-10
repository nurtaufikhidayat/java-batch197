package com.xsis.batch197.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_lookup")
public class LookupModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="lookup_idx")
	@TableGenerator(name="lookup_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id")
	private Long id;
	
	@Column(name="kd_lookup", length=20, nullable=false)
	@NotNull
	@NotEmpty
	@NotBlank
	private String kdLookup;
	
	@Column(name="nm_lookup", length=120, nullable=false)
	@NotNull
	@NotEmpty
	@NotBlank
	private String nmLookup;
	
	@Column(name="type", length=20, nullable=false)
	@NotNull
	@NotEmpty
	@NotBlank
	private String type;
	
	@Column(name="posisi", nullable=false)
	@NotNull
	private Integer posisi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKdLookup() {
		return kdLookup;
	}

	public void setKdLookup(String kdLookup) {
		this.kdLookup = kdLookup;
	}

	public String getNmLookup() {
		return nmLookup;
	}

	public void setNmLookup(String nmLookup) {
		this.nmLookup = nmLookup;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPosisi() {
		return posisi;
	}

	public void setPosisi(Integer posisi) {
		this.posisi = posisi;
	}
}
