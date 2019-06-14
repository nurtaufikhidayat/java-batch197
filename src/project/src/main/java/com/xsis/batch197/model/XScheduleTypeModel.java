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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="x_schedule_type")
public class XScheduleTypeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_schedule_type_idx")
	@TableGenerator(name="x_schedule_type_idx", table = "tbl_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
	@Column(name="id")
	private Long id;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="created_by",  nullable = false, length = 11)
	private Long createdBy;
	
	@NotBlank
	@NotEmpty
	@Column(name="created_on", nullable=false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdOn;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="modified_by", length = 11)
	private Long modifiedBy;
	
	@NotBlank
	@NotEmpty
	@Column(name="modified_on")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date modifiedOn;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="deleted_by", length = 11)
	private Long deletedBy;
	
	@NotBlank
	@NotEmpty
	@Column(name="deleted_on")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date deletedOn;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="is_delete",  nullable = false, length = 11)
	private Boolean isDelete;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="name",  nullable = false, length = 50)
	private String name;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="description", length = 100)
	private String description;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
