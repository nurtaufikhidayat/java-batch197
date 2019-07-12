package com.xsis.batch197.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="x_keterangan_tambahan")
public class XKeteranganTambahanModel extends BaseModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_keterangan_tambahan_idx")
	@TableGenerator(name="x_keterangan_tambahan_idx", table="x_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id", length = 11)
	private Long id;

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
	
	@Column(name="start_working", nullable=true, length=100)
	private String startWorking;
	
	@Column(name="is_ready_to_outoftown", nullable=true)
	private Boolean isReadyOutoftown;
	
	@Column(name="is_apply_other_place", nullable=true)
	private Boolean isApplyOtherPlace;
	
	@Column(name="apply_place", nullable=true, length=100)
	private String applyPlace;
	
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
	
	@OneToOne
	@JoinColumn(name="biodata_id", foreignKey=@ForeignKey(name="fk_kettam_bio_id"), insertable=false,updatable=false)
	private XBiodataModel biodata;
	
	public XKeteranganTambahanModel() {
		super();
	}
	
	public XKeteranganTambahanModel(Long userId, Long biodataId) {
		super(userId);
		this.biodataId=biodataId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getApplyPlace() {
		return applyPlace;
	}

	public void setApplyPlace(String applyPlace) {
		this.applyPlace = applyPlace;
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

	public XBiodataModel getBiodata() {
		return biodata;
	}

	public void setBiodata(XBiodataModel biodata) {
		this.biodata = biodata;
	}
}
