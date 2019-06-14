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
@Table(name="x_keterangan_tambahan")
public class XKeteranganTambahanModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_keterangan_tambahan_idx")
	@TableGenerator(name="x_keterangan_tambahan_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
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
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="created_on", nullable=false)
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
	
	@Column(name="emergency_contact_name", nullable=true, length=100)
	private String emergencyContactName;
	
	@Column(name="emergency_contact_phone", nullable=true, length=50)
	private String emergencyContactPhone;
	
	@Column(name="expected_salary", nullable=true, length=20)
	private String expectedSalary;
	
	@Column(name="is_negotiable", nullable=true)
	private Boolean isNegotiable;
	
	@Column(name="start_working", nullable=true, length=10)
	private String startWorking;
	
	@Column(name="is_ready_to_outoftown", nullable=true)
	private Boolean isReadyOutoftown;
	
	@Column(name="is_apply_other_place", nullable=true)
	private Boolean isApplyOtherPlace;
	
	@Column(name="apply_face", nullable=true, length=100)
	private String applyFace;
	
	@Column(name="selection_phase", nullable=true, length=100)
	private String selectionPhase;
	
	@Column(name="is_every_badly_sick", nullable=true)
	private Boolean isEveryBadlySick;
	
	@Column(name="disease_name", nullable=true, length=100)
	private String diseaseName;
	
	@Column(name="disease_time", nullable=true, length=100)
	private String diseaseTime;
	
	@Column(name="is_every_psychotest", nullable=true)
	private Boolean isEveryPsychotest;
	
	@Column(name="psychotest_needs", nullable=true, length=100)
	private String psychotestNeeds;
	
	@Column(name="psychotest_time", nullable=true, length=100)
	private String psychotestTime;
	
	@Column(name="requirementes_requied", nullable=true, length=500)
	private String requirementesRequired;
	
	@Column(name="other_notes", nullable=true, length=1000)
	private String otherNotes;

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

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}

	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}

	public String getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(String expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	public Boolean getIsNegotiable() {
		return isNegotiable;
	}

	public void setIsNegotiable(Boolean isNegotiable) {
		this.isNegotiable = isNegotiable;
	}

	public String getStartWorking() {
		return startWorking;
	}

	public void setStartWorking(String startWorking) {
		this.startWorking = startWorking;
	}

	public Boolean getIsReadyOutoftown() {
		return isReadyOutoftown;
	}

	public void setIsReadyOutoftown(Boolean isReadyOutoftown) {
		this.isReadyOutoftown = isReadyOutoftown;
	}

	public Boolean getIsApplyOtherPlace() {
		return isApplyOtherPlace;
	}

	public void setIsApplyOtherPlace(Boolean isApplyOtherPlace) {
		this.isApplyOtherPlace = isApplyOtherPlace;
	}

	public String getApplyFace() {
		return applyFace;
	}

	public void setApplyFace(String applyFace) {
		this.applyFace = applyFace;
	}

	public String getSelectionPhase() {
		return selectionPhase;
	}

	public void setSelectionPhase(String selectionPhase) {
		this.selectionPhase = selectionPhase;
	}

	public Boolean getIsEveryBadlySick() {
		return isEveryBadlySick;
	}

	public void setIsEveryBadlySick(Boolean isEveryBadlySick) {
		this.isEveryBadlySick = isEveryBadlySick;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getDiseaseTime() {
		return diseaseTime;
	}

	public void setDiseaseTime(String diseaseTime) {
		this.diseaseTime = diseaseTime;
	}

	public Boolean getIsEveryPsychotest() {
		return isEveryPsychotest;
	}

	public void setIsEveryPsychotest(Boolean isEveryPsychotest) {
		this.isEveryPsychotest = isEveryPsychotest;
	}

	public String getPsychotestNeeds() {
		return psychotestNeeds;
	}

	public void setPsychotestNeeds(String psychotestNeeds) {
		this.psychotestNeeds = psychotestNeeds;
	}

	public String getPsychotestTime() {
		return psychotestTime;
	}

	public void setPsychotestTime(String psychotestTime) {
		this.psychotestTime = psychotestTime;
	}

	public String getRequirementesRequired() {
		return requirementesRequired;
	}

	public void setRequirementesRequired(String requirementesRequired) {
		this.requirementesRequired = requirementesRequired;
	}

	public String getOtherNotes() {
		return otherNotes;
	}

	public void setOtherNotes(String otherNotes) {
		this.otherNotes = otherNotes;
	}
	
	
}
