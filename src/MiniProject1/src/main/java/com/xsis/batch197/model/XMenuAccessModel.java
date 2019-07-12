package com.xsis.batch197.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="x_menu_access")
public class XMenuAccessModel extends BaseModel{
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_menu_access_idx")
	@TableGenerator(name="x_menu_access_idx", table="x_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	
	@Column(name="id", length=11)
	private Long id;	
	
	@Column(name="menu_id", length=11, nullable=false)
	private Long menuId;	
	
	@Column(name="role_id", length=11, nullable=false)
	private Long roleId;
	
	public XMenuAccessModel() {
		super();
	}
	
	public XMenuAccessModel(Long userId) {
		super(userId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
