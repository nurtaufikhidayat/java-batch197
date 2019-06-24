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
@Table(name="x_riwayat_pelatihan")
public class XRiwayatPelatihanModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_riwayat_pelatihan_idx")
	@TableGenerator(name = "x_riwayat_pelatihan_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id", length=11)
	private Long id;
	
	@Column(name="created_by", length=11, nullable=false)
	private Long createdBy;
	
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
	
	@Column(name="training_name", length=100, nullable=true)
	private String trainingName;
	
	@Column(name="organizer", length=50, nullable=true)
	private String organizer;
	
	@Column(name="training_year", length=10, nullable=true)
	private String trainingYear;
	
	@Column(name="training_month", length=10, nullable=true)
	private String trainingMonth;
	
	@Column(name="training_duration", nullable=true)
	private Integer trainingDuration;
	
	@Column(name="time_period_id", length=11, nullable=true)
	private Long timePeriodId;
	
	@Column(name="city", length=50, nullable=true)
	private String city;
	
	@Column(name="country", length=50, nullable=true)
	private String country;
	
	@Column(name="notes", length=1000, nullable=true)
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

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public String getTrainingYear() {
		return trainingYear;
	}

	public void setTrainingYear(String trainingYear) {
		this.trainingYear = trainingYear;
	}

	public String getTrainingMonth() {
		return trainingMonth;
	}

	public void setTrainingMonth(String trainingMonth) {
		this.trainingMonth = trainingMonth;
	}

	public Integer getTrainingDuration() {
		return trainingDuration;
	}

	public void setTrainingDuration(Integer trainingDuration) {
		this.trainingDuration = trainingDuration;
	}

	public Long getTimePeriodId() {
		return timePeriodId;
	}

	public void setTimePeriodId(Long timePeriodId) {
		this.timePeriodId = timePeriodId;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
