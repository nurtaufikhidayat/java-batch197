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
@Table(name = "x_sertifikasi")
public class XSertifikasiModel extends BaseModel {
	@Id

	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_sertifikasi_idx")
	@TableGenerator(name = "x_sertifikasi_idx", table = "x_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
	@Column(name = "id", length = 11)
	private Long id;

	@Column(name = "biodata_id", nullable = false, length = 11)
	private Long biodataId;

	@Column(name = "certificate_name", nullable = true, length = 200)
	private String certificateName;

	@Column(name = "publisher", nullable = true, length = 100)
	private String publisher;

	@Column(name = "valid_start_year", nullable = true, length = 10)
	private String validStartYear;

	@Column(name = "valid_start_month", nullable = true, length = 10)
	private String validStartMonth;

	@Column(name = "until_year", nullable = true, length = 10)
	private String untilYear;

	@Column(name = "until_month", nullable = true, length = 10)
	private String untilMonth;

	@Column(name = "notes", nullable = true, length = 1000)
	private String notes;
	
	@ManyToOne
	@JoinColumn(name="biodata_id", foreignKey=@ForeignKey(name="fk_ser_bio_id"), insertable=false, updatable=false)
	private XBiodataModel biodata;

	public XSertifikasiModel() {
		super();
	}
	
	public XSertifikasiModel(Long userId, Long biodataId) {
		super(userId);
		this.biodataId= biodataId;
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

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getValidStartYear() {
		return validStartYear;
	}

	public void setValidStartYear(String validStartYear) {
		this.validStartYear = validStartYear;
	}

	public String getValidStartMonth() {
		return validStartMonth;
	}

	public void setValidStartMonth(String validStartMonth) {
		this.validStartMonth = validStartMonth;
	}

	public String getUntilYear() {
		return untilYear;
	}

	public void setUntilYear(String untilYear) {
		this.untilYear = untilYear;
	}

	public String getUntilMonth() {
		return untilMonth;
	}

	public void setUntilMonth(String untilMonth) {
		this.untilMonth = untilMonth;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public XBiodataModel getBiodata() {
		return biodata;
	}

	public void setBiodata(XBiodataModel biodata) {
		this.biodata = biodata;
	}
}
