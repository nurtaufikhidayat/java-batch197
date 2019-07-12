package com.xsis.batch197.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.xsis.batch197.modelview.FormBiodataModel;

@Entity
@Table(name="x_biodata")
public class XBiodataModel extends BaseModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_biodata_idx")
	@TableGenerator(name="x_biodata_idx", table="x_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	
	@Column(name="id", length=11)
	private Long id;
	
	@Column(name="fullname", length=225, nullable=false)
	private String fullname;
	
	@Column(name="nick_name", length=100, nullable=false)
	private String nickname;
	
	@Column(name="pob", length=100, nullable=false)
	private String pob;
	
	@Column(name="dob", nullable=false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;
	
	@Column(name="gender", nullable=false)
	private Boolean gender;
	
	@Column(name="religion_id", length=11, nullable=false)
	private Long religionId;
	
	@ManyToOne
	@JoinColumn(name="religion_id", foreignKey=@ForeignKey(name="fk_bio_religion_id"), insertable=false, updatable=false)
	private XReligionModel religion;

	@Column(name="high", nullable=true)
	private Integer high;

	@Column(name="weight", nullable=true)
	private Integer weight;

	@Column(name="nationality", length=100, nullable=true)
	private String nationality;
	
	@Column(name="ethnic", length=50, nullable=true)
	private String ethnic;
	
	@Column(name="hobby", length=225, nullable=true)
	private String hobby;
	
	@Column(name="identity_type_id", length=11, nullable=false)
	private Long identityTypeId;
	
	@ManyToOne
	@JoinColumn(name="identity_type_id",foreignKey=@ForeignKey(name="fk_bio_iddtype_id"), insertable=false, updatable=false)
	private XIdentityTypeModel identityType;
	
	@Column(name="identity_no", length=50, nullable=false)
	private String identityNo;
	
	@Column(name="email", length=100, nullable=false)
	private String email;

	@Column(name="phone_number1", length=50, nullable=false)
	private String phoneNumber1;
	
	@Column(name="phone_number2", length=50, nullable=true)
	private String phoneNumber2;
	
	@Column(name="parent_phone_number", length=50, nullable=false)
	private String parentPhoneNumber;

	@Column(name="child_sequence", length=5, nullable=true)
	private String childSequence;
	
	@Column(name="how_many_brothers", length=5, nullable=true)
	private String howManyBrothers;
	
	@Column(name="marital_status_id", length=11, nullable=false)
	private Long maritalStatusId;
	
	@ManyToOne
	@JoinColumn(name="marital_status_id",foreignKey=@ForeignKey(name="fk_bio_marstatus_id"), insertable=false, updatable=false)
	private XMaritalStatusModel maritalStatus;
	
	@Column(name="addrbook_id", length=11, nullable=true)
	private Long addrbookId;
	
	@OneToOne
	@JoinColumn(name="addrbook_id", foreignKey=@ForeignKey(name="fk_bio_addrbook_id"), insertable=false, updatable=false)
	private XAddressBookModel addressBook;

	@Column(name="token", length=10, nullable=true)
	private String token;

	@Column(name="expired_token", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date expiredToken;
	
	@Column(name="marriage_year", length=10, nullable=true)
	private String marriageYear;
	
	@Column(name="company_id", length=11, nullable=true)
	private Long companyId;
	
	@ManyToOne
	@JoinColumn(name="company_id",foreignKey=@ForeignKey(name="fk_bio_company_id"), insertable=false, updatable=false)
	private XCompanyModel company;

	@Column(name="is_process", nullable=true, length=1)
	private Boolean isProcess;

	@Column(name="is_complete", nullable=true, length=1)
	private Boolean isComplete;
	
	@OneToOne(mappedBy="biodata")
	private XAddressModel address;
	
	@OneToOne(mappedBy="biodata")
	private XKeteranganTambahanModel ketTambahan;
	
	@OneToMany(mappedBy="biodata")
	private List<XBiodataAttachmentModel> listAttch = new ArrayList<XBiodataAttachmentModel>();
	
	@OneToMany(mappedBy="biodata")
	private List<XSertifikasiModel> listSertifikasi = new ArrayList<XSertifikasiModel>();
	
	@OneToMany(mappedBy="biodata")
	private List<XCatatanModel> listCatatan = new ArrayList<XCatatanModel>();
	
	@OneToMany(mappedBy="biodata")
	private List<XKeluargaModel> listKeluarga = new ArrayList<XKeluargaModel>();
	
	@OneToMany(mappedBy="biodata")
	private List<XOnlineTestModel> listOnlineTest = new ArrayList<XOnlineTestModel>();
	
	@OneToMany(mappedBy="biodata")
	private List<XRiwayatPekerjaanModel> listPekerjaan = new ArrayList<XRiwayatPekerjaanModel>();
	
	@OneToMany(mappedBy="biodata")
	private List<XRiwayatPelatihanModel> listPelatihan = new ArrayList<XRiwayatPelatihanModel>();
	
	@OneToMany(mappedBy="biodata")
	private List<XRiwayatPendidikanModel> listPendidikan = new ArrayList<XRiwayatPendidikanModel>();
	
	@OneToMany(mappedBy="biodata")
	private List<XRiwayatProyekModel> listProyek = new ArrayList<XRiwayatProyekModel>();
	
	@ManyToMany(mappedBy="listBiodata")
	private List<XRencanaJadwalModel> listRencanaJadwal = new ArrayList<XRencanaJadwalModel>();
	
	@OneToMany(mappedBy="biodata")
	private List<XOrganisasiModel> listOrganisasi = new ArrayList<XOrganisasiModel>();
	
	@OneToMany(mappedBy="biodata")
	private List<XKeahlianModel> listKeahlian = new ArrayList<XKeahlianModel>();
	
	public XBiodataModel() {
		super();
	}
	
	public XBiodataModel(Long userId) {
		super(userId);
	}
	
	public XBiodataModel(FormBiodataModel form, Long userId) {
		super(userId);
		this.id = form.getId();
		this.fullname= form.getFullname();
		this.nickname= form.getNickname();
		this.pob= form.getPob();
		this.dob= form.getDob();
		this.gender= form.getGender();
		this.religionId= form.getReligionId();
		this.high = form.getHigh();
		this.weight = form.getWeight();
		this.nationality = form.getNationality();
		this.ethnic = form.getEthnic();
		this.hobby = form.getHobby();
		this.identityTypeId = form.getIdentityTypeId();
		this.identityNo = form.getIdentityNo();
		this.email = form.getEmail();
		this.phoneNumber1 = form.getPhoneNumber1();
		this.phoneNumber2 = form.getPhoneNumber2();
		this.parentPhoneNumber= form.getParentPhoneNumber();
		this.childSequence = form.getChildSequence();
		this.howManyBrothers = form.getHowManyBrothers();
		this.maritalStatusId = form.getMaritalStatusId();
		this.addrbookId = form.getAddrbookId();
		this.token = form.getToken();
		this.expiredToken = form.getExpiredToken();
		this.marriageYear = form.getMarriageYear();
		this.companyId = form.getCompanyId();
		this.isProcess = form.getIsProcess();
		this.isComplete = form.getIsComplete();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
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

	public XReligionModel getReligion() {
		return religion;
	}

	public void setReligion(XReligionModel religion) {
		this.religion = religion;
	}

	public XIdentityTypeModel getIdentityType() {
		return identityType;
	}

	public void setIdentityType(XIdentityTypeModel identityType) {
		this.identityType = identityType;
	}

	public XMaritalStatusModel getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(XMaritalStatusModel maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public XAddressBookModel getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(XAddressBookModel addressBook) {
		this.addressBook = addressBook;
	}

	public XCompanyModel getCompany() {
		return company;
	}

	public void setCompany(XCompanyModel company) {
		this.company = company;
	}

	public XAddressModel getAddress() {
		return address;
	}

	public void setAddress(XAddressModel address) {
		this.address = address;
	}

	public XKeteranganTambahanModel getKetTambahan() {
		return ketTambahan;
	}

	public void setKetTambahan(XKeteranganTambahanModel ketTambahan) {
		this.ketTambahan = ketTambahan;
	}

	public List<XBiodataAttachmentModel> getListAttch() {
		return listAttch;
	}

	public void setListAttch(List<XBiodataAttachmentModel> listAttch) {
		this.listAttch = listAttch;
	}

	public List<XSertifikasiModel> getListSertifikasi() {
		return listSertifikasi;
	}

	public void setListSertifikasi(List<XSertifikasiModel> listSertifikasi) {
		this.listSertifikasi = listSertifikasi;
	}

	public List<XCatatanModel> getListCatatan() {
		return listCatatan;
	}

	public void setListCatatan(List<XCatatanModel> listCatatan) {
		this.listCatatan = listCatatan;
	}

	public List<XKeluargaModel> getListKeluarga() {
		return listKeluarga;
	}

	public void setListKeluarga(List<XKeluargaModel> listKeluarga) {
		this.listKeluarga = listKeluarga;
	}

	public List<XOnlineTestModel> getListOnlineTest() {
		return listOnlineTest;
	}

	public void setListOnlineTest(List<XOnlineTestModel> listOnlineTest) {
		this.listOnlineTest = listOnlineTest;
	}

	public List<XRiwayatPekerjaanModel> getListPekerjaan() {
		return listPekerjaan;
	}

	public void setListPekerjaan(List<XRiwayatPekerjaanModel> listPekerjaan) {
		this.listPekerjaan = listPekerjaan;
	}

	public List<XRiwayatPelatihanModel> getListPelatihan() {
		return listPelatihan;
	}

	public void setListPelatihan(List<XRiwayatPelatihanModel> listPelatihan) {
		this.listPelatihan = listPelatihan;
	}

	public List<XRiwayatPendidikanModel> getListPendidikan() {
		return listPendidikan;
	}

	public void setListPendidikan(List<XRiwayatPendidikanModel> listPendidikan) {
		this.listPendidikan = listPendidikan;
	}

	public List<XRiwayatProyekModel> getListProyek() {
		return listProyek;
	}

	public void setListProyek(List<XRiwayatProyekModel> listProyek) {
		this.listProyek = listProyek;
	}

	public List<XRencanaJadwalModel> getListRencanaJadwal() {
		return listRencanaJadwal;
	}

	public void setListRencanaJadwal(List<XRencanaJadwalModel> listRencanaJadwal) {
		this.listRencanaJadwal = listRencanaJadwal;
	}

	public List<XOrganisasiModel> getListOrganisasi() {
		return listOrganisasi;
	}

	public void setListOrganisasi(List<XOrganisasiModel> listOrganisasi) {
		this.listOrganisasi = listOrganisasi;
	}

	public List<XKeahlianModel> getListKeahlian() {
		return listKeahlian;
	}

	public void setListKeahlian(List<XKeahlianModel> listKeahlian) {
		this.listKeahlian = listKeahlian;
	}
}
