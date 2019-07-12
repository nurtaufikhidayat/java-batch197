package com.xsis.batch197.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "x_keluarga")
public class XKeluargaModel extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_keluarga_idx")
	@TableGenerator(name = "x_keluarga_idx", table = "x_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
	@Column(name = "id", length = 11)
	private Long id;

	@Column(name = "biodata_id", nullable = false, length = 11)
	private Long biodataId;

	@NotNull(message = "Susunan Keluarga Wajib dipilih")
	@Column(name = "family_tree_type_id", nullable = true, length = 11)
	private Long familyTreeTypeId;

	@ManyToOne
	@JoinColumn(name = "family_tree_type_id", foreignKey = @ForeignKey(name = "fk_kel_familytree_id"), insertable = false, updatable = false)
	private XFamilyTreeTypeModel familyTree;

	@NotNull(message = "Hubungan Keluarga Wajib dipilih")
	@Column(name = "family_relation_id", nullable = true, length = 11)
	private Long familyRelationId;

	@ManyToOne
	@JoinColumn(name = "family_relation_id", foreignKey = @ForeignKey(name = "fk_kel_familyrelation_id"), insertable = false, updatable = false)
	private XFamilyRelationModel familyRelation;

	@NotEmpty(message = "Nama Tidak boleh kosong")
	@Column(name = "name", nullable = true, length = 100)
	private String name;

	@Column(name = "gender", nullable = true)
	private Boolean gender;

	@Column(name = "dob", nullable = true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;

	@NotNull(message = "Pendidikan Wajib dipilih")
	@Column(name = "education_level_id", nullable = true, length = 11)
	private Long educationLevelId;

	@ManyToOne
	@JoinColumn(name = "education_level_id", foreignKey = @ForeignKey(name = "fk_kel_edulev_id"), insertable = false, updatable = false)
	private XEducationLevelModel educationLevel;

	@NotEmpty(message = "Pekerjaan Tidak boleh kosong")
	@Column(name = "job", nullable = true, length = 100)
	private String job;

	@NotEmpty(message = "Catatan Tidak boleh kosong")
	@Column(name = "notes", nullable = true, length = 1000)
	private String notes;

	@ManyToOne
	@JoinColumn(name = "biodata_id", foreignKey = @ForeignKey(name = "fk_kel_bio_id"), insertable = false, updatable = false)
	private XBiodataModel biodata;
	
	@Transient
	private String genderName;

	public XKeluargaModel() {
		super();
	}

	public XKeluargaModel(Long userId) {
		super(userId);
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

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public XBiodataModel getBiodata() {
		return biodata;
	}

	public void setBiodata(XBiodataModel biodata) {
		this.biodata = biodata;
	}

	public XEducationLevelModel getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(XEducationLevelModel educationLevel) {
		this.educationLevel = educationLevel;
	}

	public XFamilyTreeTypeModel getFamilyTree() {
		return familyTree;
	}

	public void setFamilyTree(XFamilyTreeTypeModel familyTree) {
		this.familyTree = familyTree;
	}

	public XFamilyRelationModel getFamilyRelation() {
		return familyRelation;
	}

	public void setFamilyRelation(XFamilyRelationModel familyRelation) {
		this.familyRelation = familyRelation;
	}
}
