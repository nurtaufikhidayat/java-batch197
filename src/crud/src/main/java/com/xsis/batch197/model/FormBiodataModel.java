package com.xsis.batch197.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class FormBiodataModel {
	@NotEmpty(message="Tidak boleh kosong")
	private String fullname;
	
	@NotEmpty(message="Tidak boleh kosong")
	private String nickname;
	
	@NotEmpty(message="Tidak boleh kosong")
	private String pob;
	
	@NotNull(message="Tidak boleh kosong")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;
	
	@NotNull(message="Tidak boleh kosong")
	private Boolean gender;
	
	@NotNull(message="Tidak boleh kosong")
	private Long religionId;

	@NotNull(message="Tidak boleh kosong")
	private Integer high;

	@NotNull(message="Tidak boleh kosong")
	private Integer weight;

	@NotEmpty(message="Tidak boleh kosong")
	private String nationality;
	
	@NotEmpty(message="Tidak boleh kosong")
	private String ethnic;
	
	private String hobby;
	
	@NotNull(message="Tidak boleh kosong")
	private Long identityTypeId;
	
	private String identityNo;
	
	@Email(message="Format email salah")
	@NotEmpty(message="Tidak boleh kosong")
	private String email;

	private String phoneNumber1;
	
	private String phoneNumber2;

	@NotEmpty(message="Tidak boleh kosong")
	private String parentPhoneNumber;

	@NotEmpty(message="Tidak boleh kosong")
	private String childSequence;
	
	@NotEmpty(message="Tidak boleh kosong")
	private String howManyBrothers;

	@NotNull(message="Tidak boleh kosong")
	private Long maritalStatusId;
	
	private Long addrbookId;

	@Column(name="token", length=10, nullable=true)
	private String token;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expiredToken;
	
	private String marriageYear;
	
	private String companyId;

	private Boolean isProcess;

	private Boolean isComplete;
	
	// address
	
	@NotEmpty(message="Tidak boleh kosong")
	private String address1;
	
	@Column(name="postal_code1", length=20, nullable=true)
	private String postalCode1;
	
	@NotEmpty(message="Tidak boleh kosong")
	private String rt1;
	
	@NotEmpty(message="Tidak boleh kosong")
	private String rw1;
	
	@NotEmpty(message="Tidak boleh kosong")
	private String kelurahan1;
	
	@NotEmpty(message="Tidak boleh kosong")
	private String kecamatan1;

	@NotEmpty(message="Tidak boleh kosong")
	private String region1;
	
	@NotEmpty(message="Tidak boleh kosong")
	private String address2;
	
	@Column(name="postal_code2", length=20, nullable=true)
	private String postalCode2;

	@NotEmpty(message="Tidak boleh kosong")
	private String rt2;
	
	@NotEmpty(message="Tidak boleh kosong")
	private String rw2;
	
	@NotEmpty(message="Tidak boleh kosong")
	private String kelurahan2;
	
	@NotEmpty(message="Tidak boleh kosong")
	private String kecamatan2;
	
	@NotEmpty(message="Tidak boleh kosong")
	private String region2;

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

	public String getEthnic() {
		return ethnic;
	}

	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
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

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getPostalCode1() {
		return postalCode1;
	}

	public void setPostalCode1(String postalCode1) {
		this.postalCode1 = postalCode1;
	}

	public String getRt1() {
		return rt1;
	}

	public void setRt1(String rt1) {
		this.rt1 = rt1;
	}

	public String getRw1() {
		return rw1;
	}

	public void setRw1(String rw1) {
		this.rw1 = rw1;
	}

	public String getKelurahan1() {
		return kelurahan1;
	}

	public void setKelurahan1(String kelurahan1) {
		this.kelurahan1 = kelurahan1;
	}

	public String getKecamatan1() {
		return kecamatan1;
	}

	public void setKecamatan1(String kecamatan1) {
		this.kecamatan1 = kecamatan1;
	}

	public String getRegion1() {
		return region1;
	}

	public void setRegion1(String region1) {
		this.region1 = region1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPostalCode2() {
		return postalCode2;
	}

	public void setPostalCode2(String postalCode2) {
		this.postalCode2 = postalCode2;
	}

	public String getRt2() {
		return rt2;
	}

	public void setRt2(String rt2) {
		this.rt2 = rt2;
	}

	public String getRw2() {
		return rw2;
	}

	public void setRw2(String rw2) {
		this.rw2 = rw2;
	}

	public String getKelurahan2() {
		return kelurahan2;
	}

	public void setKelurahan2(String kelurahan2) {
		this.kelurahan2 = kelurahan2;
	}

	public String getKecamatan2() {
		return kecamatan2;
	}

	public void setKecamatan2(String kecamatan2) {
		this.kecamatan2 = kecamatan2;
	}

	public String getRegion2() {
		return region2;
	}

	public void setRegion2(String region2) {
		this.region2 = region2;
	}
	
	
}
