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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="x_biodata")
public class XBiodataModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_biodata_idx")
	@TableGenerator(name="x_biodata_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	
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
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="is_delete", nullable=false)
	private Boolean isDelete;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="fullname", length=225, nullable=false)
	private String fullname;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="nickname", length=100, nullable=false)
	private String nickname;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="pob", length=100, nullable=false)
	private String pob;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="dob", nullable=false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;
	
	@Column(name="gender", nullable=false)
	private Boolean gender;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="religion_id", length=11, nullable=false)
	private Long religionId;

	@Column(name="high", nullable=true)
	private Integer high;

	@Column(name="weight", nullable=true)
	private Integer weight;

	@Column(name="nationality", length=100, nullable=true)
	private String nationality;
	
	@Column(name="ethic", length=50, nullable=true)
	private String ethic;
	
	@Column(name="hobby", length=225, nullable=true)
	private String hobby;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="identity_type_id", length=11, nullable=false)
	private Long identityTypeId;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="identity_no", length=50, nullable=false)
	private String identityNo;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Email(message="Format salah")
	@Column(name="email", length=100, nullable=false)
	private String email;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="phone_number1", length=50, nullable=false)
	private String phoneNumber1;
	
	@Column(name="phone_number2", length=50, nullable=true)
	private String phoneNumber2;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="parent_phone_number", length=50, nullable=false)
	private String parentPhoneNumber;

	@Column(name="child_sequence", length=5, nullable=true)
	private String childSequence;
	
	@Column(name="how_many_brothers", length=5, nullable=true)
	private String howManyBrothers;
	
	@Column(name="marital_status_id", length=11, nullable=false)
	private Long maritalStatusId;
	
	@Column(name="addrbook_id", length=11, nullable=true)
	private Long addrbookId;

	@Column(name="token", length=10, nullable=true)
	private String token;

	@Column(name="expired_token", nullable=true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expiredToken;
	
	@Column(name="marriage_year", length=10, nullable=true)
	private String marriageYear;
	
	@Column(name="company_id", length=11, nullable=false)
	private String companyId;

	@Column(name="is_process", nullable=true)
	private Boolean isProcess;

	@Column(name="is_complete", nullable=true)
	private Boolean isComplete;

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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPob() {
		return pob;
	}

	public void setPob(String pob) {
		this.pob = pob;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Long getReligionId() {
		return religionId;
	}

	public void setReligionId(Long religionId) {
		this.religionId = religionId;
	}

	public Integer getHigh() {
		return high;
	}

	public void setHigh(Integer high) {
		this.high = high;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEthic() {
		return ethic;
	}

	public void setEthic(String ethic) {
		this.ethic = ethic;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Long getIdentityTypeId() {
		return identityTypeId;
	}

	public void setIdentityTypeId(Long identityTypeId) {
		this.identityTypeId = identityTypeId;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getParentPhoneNumber() {
		return parentPhoneNumber;
	}

	public void setParentPhoneNumber(String parentPhoneNumber) {
		this.parentPhoneNumber = parentPhoneNumber;
	}

	public String getChildSequence() {
		return childSequence;
	}

	public void setChildSequence(String childSequence) {
		this.childSequence = childSequence;
	}

	public String getHowManyBrothers() {
		return howManyBrothers;
	}

	public void setHowManyBrothers(String howManyBrothers) {
		this.howManyBrothers = howManyBrothers;
	}

	public Long getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(Long maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public Long getAddrbookId() {
		return addrbookId;
	}

	public void setAddrbookId(Long addrbookId) {
		this.addrbookId = addrbookId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiredToken() {
		return expiredToken;
	}

	public void setExpiredToken(Date expiredToken) {
		this.expiredToken = expiredToken;
	}

	public String getMarriageYear() {
		return marriageYear;
	}

	public void setMarriageYear(String marriageYear) {
		this.marriageYear = marriageYear;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Boolean getIsProcess() {
		return isProcess;
	}

	public void setIsProcess(Boolean isProcess) {
		this.isProcess = isProcess;
	}

	public Boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	
}
