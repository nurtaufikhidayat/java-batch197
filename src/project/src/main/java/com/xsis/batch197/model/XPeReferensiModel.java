package com.xsis.batch197.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="x_pe_referensi")
public class XPeReferensiModel {
	@Id

	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_pe_referensi_idx")
	@TableGenerator(name = "x_pe_referensi_idx", table = "tbl_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
	@Column(name = "id", length = 11)
	private Long id;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "created_by", nullable = false, length = 11)
	private Long createdBy;

	@NotNull
	@NotBlank
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "created_on", nullable = false)
	private Date createdOn;

	@Column(name = "modified_by", nullable = true, length = 11)
	private Long modifiedBy;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "modified_on", nullable = true)
	private Date modifiedOn;

	@Column(name = "deleted_by", nullable = true, length = 11)
	private Long deletedBy;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "deleted_on", nullable = true)
	private Date deletedOn;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "is_delete", nullable = false)
	private Boolean isDelete;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "biodata_id", nullable = false, length = 11)
	private Long biodataId;
	
	@Column(name = "name", nullable = true, length = 100)
	private String name;
	
	@Column(name = "position", nullable = true, length = 100)
	private String position;
	
	@Column(name = "address_phone", nullable = true, length = 1000)
	private String addressPhone;
	
	@Column(name = "relation", nullable = true, length = 100)
	private String relation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Long getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Date getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(Date deletedOn) {
		this.deletedOn = deletedOn;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Long getBiodataId() {
		return biodataId;
	}

	public void setBiodataId(Long biodataId) {
		this.biodataId = biodataId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAddressPhone() {
		return addressPhone;
	}

	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	
}
