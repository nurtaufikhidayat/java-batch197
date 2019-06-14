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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "x_rencana_jadwal")
public class XRencanaJadwalModel {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_rencana_jadwal_idx")
	@TableGenerator(name = "x_rencana_jadwal_idx", table = "tbl_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
	@Column(name = "id", length = 11)
	private Long id;

	@Column(name = "created_by", length = 11, nullable = false)
	private Long createdBy;

	@Column(name = "created_on", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date createdOn;

	@Column(name = "modified_by", length = 11, nullable = true)
	private Long modifiedBy;

	@Column(name = "modified_on", nullable = true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date modifiedOn;

	@Column(name = "delete_by", length = 11, nullable = true)
	private Long deletedBy;

	@Column(name = "deleted_on", nullable = true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date deletedOn;

	@Column(name = "is_delete", nullable = false)
	private Boolean isDelete;

	@Column(name = "schedule_code", length = 20, nullable = true)
	private String scheduleCode;

	@Column(name = "schedule_date", nullable = true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date scheduleDate;

	@Column(name = "time", length = 10, nullable = true)
	private String time;

	@Column(name = "ro", length = 11, nullable = true)
	private Long ro;

	@Column(name = "tro", length = 11, nullable = true)
	private Long tro;

	@Column(name = "schedule_type_id", length = 11, nullable = true)
	private Long scheduleTypeId;

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
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date sentDate;

	@Column(name = "status", length = 50, nullable = true)
	private String status;

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

}
