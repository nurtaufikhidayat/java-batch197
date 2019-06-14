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
@Table(name="x_sertifikasi")
public class XSertifikasiModel {
	@Id

	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_sertifikasi_idx")
	@TableGenerator(name="x_sertifikasi_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id", length = 11)
	private Long id;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="created_by", nullable=false, length = 11)
	private Long createdBy;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="created_on", nullable=false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdOn;
	
	@Column(name="modified_by", nullable=true, length=11)
	private Long modifiedBy;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="modified_on", nullable=true)
	private Date modifiedOn;
	
	@Column(name="deleted_by", nullable=true, length=11)
	private Long deletedBy;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="deleted_on", nullable=true)
	private Date deletedOn;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="is_delete", nullable=false)
	private Boolean isDelete;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="biodata_id", nullable=false, length=11)
	private Long biodataId;
	
	@Column(name="certificate_name", nullable=true, length=200)
	private String certificateName;
	
	@Column(name="publisher", nullable=true, length=100)
	private String publisher;
	
	@Column(name="valid_start_year", nullable=true, length=10)
	private String validStartYear;
	
	@Column(name="valid_start_month", nullable=true, length=10)
	private String validStartMonth;
	
	@Column(name="until_year", nullable=true, length=10)
	private String untilYear;
	
	@Column(name="until_month", nullable=true, length=10)
	private String untilMonth;
	
	@Column(name="notes", nullable=true, length=1000)
	private String notes;

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

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getValidStartYear() {
		return validStartYear;
	}

	public void setValidStartYear(String validStartYear) {
		this.validStartYear = validStartYear;
	}

	public String getValidStartMonth() {
		return validStartMonth;
	}

	public void setValidStartMonth(String validStartMonth) {
		this.validStartMonth = validStartMonth;
	}

	public String getUntilYear() {
		return untilYear;
	}

	public void setUntilYear(String untilYear) {
		this.untilYear = untilYear;
	}

	public String getUntilMonth() {
		return untilMonth;
	}

	public void setUntilMonth(String untilMonth) {
		this.untilMonth = untilMonth;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
