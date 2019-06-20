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
@Table(name="x_menutree")
public class XMenutreeModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_menutree_idx")
	@TableGenerator(name="x_menutree_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	
	@Column(name="id", length=11)
	private Long id;
	
	@Column(name="title", length=50, nullable=false)
	private String title;
	
	@Column(name="menu_image_url", length=100, nullable=true)
	private String menuImageUrl;
	
	@Column(name="menu_icon", length=100, nullable=true)
	private String menuIcon;
	
	@Column(name="menu_order", nullable=false)
	private Integer menuOrder;
	
	@Column(name="menu_level", nullable=false)
	private Integer menuLevel;

	@Column(name="menu_parent", length=11, nullable=true)
	private Long menuParent;
	
	@Column(name="menu_url", length=100, nullable=false)
	private Long menuUrl;
	
	@Column(name="menu_type", length=10, nullable=false)
	private String menuType;
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMenuImageUrl() {
		return menuImageUrl;
	}

	public void setMenuImageUrl(String menuImageUrl) {
		this.menuImageUrl = menuImageUrl;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Integer getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}

	public Integer getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}

	public Long getMenuParent() {
		return menuParent;
	}

	public void setMenuParent(Long menuParent) {
		this.menuParent = menuParent;
	}

	public Long getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(Long menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
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
