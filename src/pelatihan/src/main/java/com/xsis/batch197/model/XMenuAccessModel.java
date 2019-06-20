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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="x_menu_access")
public class XMenuAccessModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_menu_access_idx")
	@TableGenerator(name="x_menu_access_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	
	@Column(name="id", length=11)
	private Long id;	
	
	@Column(name="menutree_id", length=11, nullable=false)
	private Long menutreeId;	
	
	@Column(name="role_id", length=11, nullable=false)
	private Long roleId;
	
	@Column(name="created_by", length=11, nullable=false)
	private Long createdBy;
	
	@Column(name="created_on", nullable=false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdOn;
	
	@Column(name="modified_by", length=11, nullable=true)
	private Long modifiedBy;	
	
	@Column(name="modified_on", nullable=true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date modifiedOn;
	
	@Column(name="deleted_by", length=11, nullable=true)
	private Long deletedBy;
	
	@Column(name="deleted_on", nullable=true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date deletedOn;
	
	@Column(name="is_delete", nullable=false)
	private Boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMenutreeId() {
		return menutreeId;
	}

	public void setMenutreeId(Long menutreeId) {
		this.menutreeId = menutreeId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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


}
