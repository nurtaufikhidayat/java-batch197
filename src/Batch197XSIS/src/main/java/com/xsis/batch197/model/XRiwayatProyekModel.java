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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "x_riwayat_proyek")
public class XRiwayatProyekModel extends BaseModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_riwayat_proyek_idx")
	@TableGenerator(name = "x_riwayat_proyek_idx", table="x_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id", length=11)
	private Long id;
	
	@NotNull
	@Column(name="riwayat_pekerjaan_id", length=11, nullable=false)
	private Long riwayatPekerjaanId;
	
	@Column(name="start_year", length=10, nullable=true)
	private String startYear;
	
	@Column(name="start_month", length=10, nullable=true)
	private String startMonth;
	
	@Column(name="project_name", length=50, nullable=true)
	private String projectName;
	
	@Column(name="project_duration", nullable=true )
	private Integer projectDuration;
	
	@Column(name="time_period_id", length=11, nullable=true)
	private Long timePeriodId;
	
	@Column(name="client", length=100, nullable=true)
	private String client;
	
	@Column(name="project_position", length=100, nullable=true)
	private String projectPosition;
	
	@Column(name="description", length=1000, nullable=true)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="biodata_id", foreignKey=@ForeignKey(name="fk_ripro_bio_id"), insertable=false, updatable=false)
	private XBiodataModel biodata;
	
	public XRiwayatProyekModel() {
		super();
	}
	
	public XRiwayatProyekModel(Long userId) {
		super(userId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRiwayatPekerjaanId() {
		return riwayatPekerjaanId;
	}

	public void setRiwayatPekerjaanId(Long riwayatPekerjaanId) {
		this.riwayatPekerjaanId = riwayatPekerjaanId;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getProjectDuration() {
		return projectDuration;
	}

	public void setProjectDuration(Integer projectDuration) {
		this.projectDuration = projectDuration;
	}

	public Long getTimePeriodId() {
		return timePeriodId;
	}

	public void setTimePeriodId(Long timePeriodId) {
		this.timePeriodId = timePeriodId;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getProjectPosition() {
		return projectPosition;
	}

	public void setProjectPosition(String projectPosition) {
		this.projectPosition = projectPosition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public XBiodataModel getBiodata() {
		return biodata;
	}

	public void setBiodata(XBiodataModel biodata) {
		this.biodata = biodata;
	}
	
}
