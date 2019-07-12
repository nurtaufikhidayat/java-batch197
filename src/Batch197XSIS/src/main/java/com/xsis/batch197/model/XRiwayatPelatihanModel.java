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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "x_riwayat_pelatihan")
public class XRiwayatPelatihanModel extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_riwayat_pelatihan_idx")
	@TableGenerator(name = "x_riwayat_pelatihan_idx", table = "x_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
	@Column(name = "id", length = 11)
	private Long id;

	@Column(name = "biodata_id", length = 11, nullable = false)
	private Long biodataId;

	@NotEmpty(message="Tidak boleh kosong")
	@Column(name = "training_name", length = 100, nullable = true)
	private String trainingName;

	@NotEmpty(message="Tidak boleh kosong")
	@Column(name = "organizer", length = 50, nullable = true)
	private String organizer;

	@NotEmpty(message="Tidak boleh kosong")
	@Column(name = "training_year", length = 10, nullable = true)
	private String trainingYear;

	@NotEmpty(message="Tidak boleh kosong")
	@Column(name = "training_month", length = 10, nullable = true)
	private String trainingMonth;

	@Column(name = "training_duration", nullable = true)
	private Integer trainingDuration;

	@Column(name = "time_period_id", length = 11, nullable = true)
	private Long timePeriodId;

	@Column(name = "city", length = 50, nullable = true)
	private String city;

	@Column(name = "country", length = 50, nullable = true)
	private String country;

	@Column(name = "notes", length = 1000, nullable = true)
	private String notes;
	
	@ManyToOne
	@JoinColumn(name="biodata_id", foreignKey=@ForeignKey(name="fk_ripel_bio_id"), insertable=false, updatable=false)
	private XBiodataModel biodata;
	
	@ManyToOne
	@JoinColumn(name="time_period_id", foreignKey=@ForeignKey(name="fk_ripel_periode_id"), insertable=false, updatable=false)
	private XTimePeriodeModel timePeriode;

	public XRiwayatPelatihanModel() {
		super();
	}
	
	public XRiwayatPelatihanModel(Long userId, Long biodatId) {
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

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public String getTrainingYear() {
		return trainingYear;
	}

	public void setTrainingYear(String trainingYear) {
		this.trainingYear = trainingYear;
	}

	public String getTrainingMonth() {
		return trainingMonth;
	}

	public void setTrainingMonth(String trainingMonth) {
		this.trainingMonth = trainingMonth;
	}

	public Integer getTrainingDuration() {
		return trainingDuration;
	}

	public void setTrainingDuration(Integer trainingDuration) {
		this.trainingDuration = trainingDuration;
	}

	public Long getTimePeriodId() {
		return timePeriodId;
	}

	public void setTimePeriodId(Long timePeriodId) {
		this.timePeriodId = timePeriodId;
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

	public XTimePeriodeModel getTimePeriode() {
		return timePeriode;
	}

	public void setTimePeriode(XTimePeriodeModel timePeriode) {
		this.timePeriode = timePeriode;
	}

}