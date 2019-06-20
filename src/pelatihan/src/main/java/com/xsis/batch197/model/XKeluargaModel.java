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
@Table(name = "x_keluarga")
public class XKeluargaModel {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_keluarga_idx")
	@TableGenerator(name="x_keluarga_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id", length=11)
	private Long id;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="created_by", nullable=false, length=11)
	private Long createdBy;
	
	@NotNull
	@NotBlank
	@NotEmpty

	@Column(name="creted_on", nullable=false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdOn;

	@Column(name="modified_by", nullable=true, length=11)
	private Long modifiedBy;
	
	@Column(name="modified_on", nullable=true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date modifiedOn;
	
	@Column(name="deleted_by", nullable=true, length=11)
	private Long deletedBy;
	
	@Column(name="deleted_on", nullable=true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date deletedOn;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="is_deleted", nullable=false)
	private Boolean isDeleted;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="biodata_id", nullable=false, length=11)
	private Long biodataId;
	
	@Column(name="family_tree_type_id", nullable=true, length=11)
	private Long familyTreeTypeId;
	
	@Column(name="family_relation_id", nullable=true, length=11)
	private Long familyRelationId;
	
	@Column(name="name", nullable=true, length=100)
	private String name;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="gender", nullable=false)
	private Boolean gender;
	
	@Column(name="dob", nullable=true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;
	
	@Column(name="education_level_id", nullable=true, length=11)
	private Long educationLevelId;
	
	@Column(name="job", nullable=true, length=100)
	private String job;
	
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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getBiodataId() {
		return biodataId;
	}

	public void setBiodataId(Long biodataId) {
		this.biodataId = biodataId;
	}

	public Long getFamilyTreeTypeId() {
		return familyTreeTypeId;
	}

	public void setFamilyTreeTypeId(Long familyTreeTypeId) {
		this.familyTreeTypeId = familyTreeTypeId;
	}

	public Long getFamilyRelationId() {
		return familyRelationId;
	}

	public void setFamilyRelationId(Long familyRelationId) {
		this.familyRelationId = familyRelationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getEducationLevelId() {
		return educationLevelId;
	}

	public void setEducationLevelId(Long educationLevelId) {
		this.educationLevelId = educationLevelId;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
