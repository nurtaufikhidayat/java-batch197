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
@Table(name = "x_riwayat_pekerjaan")
public class XRiwayatPekerjaanModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_riwayat_pekerjaan_idx")
	@TableGenerator(name = "x_riwayat_pekerjaan_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id", length=11)
	private Long id;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="created_by", length=11, nullable=false)
	private Long createdBy;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="created_on", nullable=false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdOn;
	
	@Column(name="modified_by", length=11, nullable=true)
	private Long modifiedBy;
	
	@Column(name="modified_on", nullable=true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date modifiedOn;
	
	@Column(name="deleted_by", length=11, nullable=true)
	private Long deletedBy;
	
	@Column(name="deleted_on", nullable=true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date deletedOn;
	
	@Column(name="is_delete", nullable=false)
	private Boolean isDelete;
	
	@NotNull
	@Column(name="biodata_id", length=11, nullable=false)
	private Long biodataId;
	
	@Column(name="company_name", length=100, nullable=true)
	private String companyName;
	
	@Column(name="city", length=50, nullable=true)
	private String city;
	
	@Column(name="country", length=50, nullable=true)
	private String country;
	
	@Column(name="join_year", length=10, nullable=true)
	private String joinYear;
	
	@Column(name="join_month", length=10, nullable=true)
	private String joinMonth;
	
	@Column(name="resign_year", length=10, nullable=true)
	private String resignYear;
	
	@Column(name="resign_month", length=10, nullable=true)
	private String resignMonth;
	
	@Column(name="last_position", length=100, nullable=true)
	private String lastPosition;
	
	@Column(name="income", length=20, nullable=true)
	private String income;
	
	@Column(name="is_it_related", nullable=true)
	private Boolean isItRelated;
	
	@Column(name="about_job", length=1000, nullable=true)
	private String aboutJob;
	
	@Column(name="exit_reason", length=500, nullable=true)
	private String exitReason;
	
	@Column(name="notes", length=5000, nullable=true)
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getJoinYear() {
		return joinYear;
	}

	public void setJoinYear(String joinYear) {
		this.joinYear = joinYear;
	}

	public String getJoinMonth() {
		return joinMonth;
	}

	public void setJoinMonth(String joinMonth) {
		this.joinMonth = joinMonth;
	}

	public String getResignYear() {
		return resignYear;
	}

	public void setResignYear(String resignYear) {
		this.resignYear = resignYear;
	}

	public String getResignMonth() {
		return resignMonth;
	}

	public void setResignMonth(String resignMonth) {
		this.resignMonth = resignMonth;
	}

	public String getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(String lastPosition) {
		this.lastPosition = lastPosition;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public Boolean getIsItRelated() {
		return isItRelated;
	}

	public void setIsItRelated(Boolean isItRelated) {
		this.isItRelated = isItRelated;
	}

	public String getAboutJob() {
		return aboutJob;
	}

	public void setAboutJob(String aboutJob) {
		this.aboutJob = aboutJob;
	}

	public String getExitReason() {
		return exitReason;
	}

	public void setExitReason(String exitReason) {
		this.exitReason = exitReason;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	

}
