package com.xsis.batch197.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "x_riwayat_pendidikan")
public class XRiwayatPendidikanModel extends BaseModel{
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_riwayat_pendidikan_idx")
	@TableGenerator(name = "x_riwayat_pendidikan_idx", table="x_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id", length=11)
	private Long id;
	
	@Column(name="biodata_id", length=11, nullable=false)
	private Long biodataId;
	
	@Column(name="school_name", length=100, nullable=true)
	private String schoolName;
	
	@Column(name="city", length=50, nullable=true)
	private String city;
	
	@Column(name="country", length=50, nullable=true)
	private String country;
	
	@Column(name="education_level_id", length=11, nullable=true)
	private Long educationLevelId;
	
	@ManyToOne
	@JoinColumn(name="education_level_id", foreignKey=@ForeignKey(name="fk_ripen_edulev_id"), insertable=false, updatable=false)
	private XEducationLevelModel eductationLevel;
	
	@Column(name="entry_year", length=10, nullable=true)
	private String entryYear;
	
	@Column(name="graduation_year", length=10, nullable=true)
	private String graduationYear;
	
	@Column(name="major", length=100, nullable=true)
	private String major;
	
	@Column(name="gpa", nullable=true)
	private Double gpa;
	
	@Column(name="notes", length=1000, nullable=true)
	private String notes;
	
	@Column(name="order_pendidikan", nullable=true)
	private Integer orderPendidikan;
	
	@Column(name="judul_ta", length=255, nullable=true)
	private String judulTa;
	
	@Column(name="deskripsi_ta", length=5000, nullable=true)
	private String deskripsiTa;
	
	@ManyToOne
	@JoinColumn(name="biodata_id", foreignKey=@ForeignKey(name="fk_ripen_bio_id"), insertable=false, updatable=false)
	private XBiodataModel biodata;
	
	public XRiwayatPendidikanModel() {
		super();
	}
	
	public XRiwayatPendidikanModel(Long userId, Long biodatId) {
		super(userId);
		this.biodataId=biodatId;
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

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
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

	public Long getEducationLevelId() {
		return educationLevelId;
	}

	public void setEducationLevelId(Long educationLevelId) {
		this.educationLevelId = educationLevelId;
	}

	public String getEntryYear() {
		return entryYear;
	}

	public void setEntryYear(String entryYear) {
		this.entryYear = entryYear;
	}

	public String getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getOrderPendidikan() {
		return orderPendidikan;
	}

	public void setOrderPendidikan(Integer orderPendidikan) {
		this.orderPendidikan = orderPendidikan;
	}

	public String getJudulTa() {
		return judulTa;
	}

	public void setJudulTa(String judulTa) {
		this.judulTa = judulTa;
	}

	public String getDeskripsiTa() {
		return deskripsiTa;
	}

	public void setDeskripsiTa(String deskripsiTa) {
		this.deskripsiTa = deskripsiTa;
	}

	public XBiodataModel getBiodata() {
		return biodata;
	}

	public void setBiodata(XBiodataModel biodata) {
		this.biodata = biodata;
	}

	public XEducationLevelModel getEductationLevel() {
		return eductationLevel;
	}

	public void setEductationLevel(XEducationLevelModel eductationLevel) {
		this.eductationLevel = eductationLevel;
	}
	
}
