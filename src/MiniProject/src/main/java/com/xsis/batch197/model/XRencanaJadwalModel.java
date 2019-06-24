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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "x_rencana_jadwal")
public class XRencanaJadwalModel extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_rencana_jadwal_idx")
	@TableGenerator(name = "x_rencana_jadwal_idx", table = "x_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
	@Column(name = "id", length = 11)
	private Long id;

	@Column(name = "schedule_code", length = 20, nullable = true)
	private String scheduleCode;

	@Column(name = "schedule_date", nullable = true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date scheduleDate;

	@Column(name = "time", length = 10, nullable = true)
	private String time;

	@Column(name = "ro", length = 11, nullable = true)
	private Long ro;

	@Column(name = "tro", length = 11, nullable = true)
	private Long tro;

	@Column(name = "schedule_type_id", length = 11, nullable = true)
	private Long scheduleTypeId;
	
	@ManyToOne
	@JoinColumn(name="schedule_type_id", foreignKey=@ForeignKey(name="fk_renjad_shectype_id"), insertable=false, updatable=false)
	private XScheduleTypeModel scheduleType;

	@Column(name = "location", length = 100, nullable = true)
	private String location;

	@Column(name = "other_ro_tro", length = 100, nullable = true)
	private String otherRoTro;

	@Column(name = "notes", length = 1000, nullable = true)
	private String notes;

	@Column(name = "is_automatic_mail", nullable = true)
	private Boolean isAutomaticMail;

	@Column(name = "sent_datee", nullable = true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sentDate;

	@Column(name = "status", length = 50, nullable = true)
	private String status;
	
	@ManyToMany
	@JoinTable(
			name="x_rencana_jadwal_detail",
			joinColumns=@JoinColumn(name="rencana_jadwal_id", referencedColumnName="id", foreignKey=@ForeignKey(name="fk_renjad_bio_id")),
			inverseJoinColumns=@JoinColumn(name="biodata_id", referencedColumnName="id", foreignKey=@ForeignKey(name="fk_bio_renjad_id")),
			foreignKey=@ForeignKey(name="fk_renjad_bio_id"),
			inverseForeignKey=@ForeignKey(name="fk_bio_renjad_id")
			)
	private List<XBiodataModel> listBiodata = new ArrayList<XBiodataModel>();

	public XRencanaJadwalModel() {
		super();
	}
	
	public XRencanaJadwalModel(Long userId) {
		super(userId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScheduleCode() {
		return scheduleCode;
	}

	public void setScheduleCode(String scheduleCode) {
		this.scheduleCode = scheduleCode;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getRo() {
		return ro;
	}

	public void setRo(Long ro) {
		this.ro = ro;
	}

	public Long getTro() {
		return tro;
	}

	public void setTro(Long tro) {
		this.tro = tro;
	}

	public Long getScheduleTypeId() {
		return scheduleTypeId;
	}

	public void setScheduleTypeId(Long scheduleTypeId) {
		this.scheduleTypeId = scheduleTypeId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOtherRoTro() {
		return otherRoTro;
	}

	public void setOtherRoTro(String otherRoTro) {
		this.otherRoTro = otherRoTro;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Boolean getIsAutomaticMail() {
		return isAutomaticMail;
	}

	public void setIsAutomaticMail(Boolean isAutomaticMail) {
		this.isAutomaticMail = isAutomaticMail;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public XScheduleTypeModel getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(XScheduleTypeModel scheduleType) {
		this.scheduleType = scheduleType;
	}
}
