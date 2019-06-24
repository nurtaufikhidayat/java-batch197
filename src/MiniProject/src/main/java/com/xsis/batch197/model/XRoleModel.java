package com.xsis.batch197.model;

import java.util.ArrayList;
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
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "x_role")
public class XRoleModel extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_role_idx")
	@TableGenerator(name = "x_role_idx", table = "x_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)

	@Column(name = "id", length = 11)
	private Long id;

	@Column(name = "code", length = 50, nullable = false)
	private String code;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@ManyToMany(mappedBy = "listRole")
	private List<XAddressBookModel> listAddr = new ArrayList<XAddressBookModel>();

	@ManyToMany
	@JoinTable(name = "x_menu_access", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_role_menu_id")), inverseJoinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_menu_role_id")), foreignKey = @ForeignKey(name = "fk_role_menu_id"), inverseForeignKey = @ForeignKey(name = "fk_menu_role_id"))
	private List<XMenuModel> listMenu = new ArrayList<XMenuModel>();

	public XRoleModel() {
		super();
	}

	public XRoleModel(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	public XRoleModel(String code, String name, Long userId) {
		super(userId);
		this.code = code;
		this.name = name;
	}

	public XRoleModel(Long userId) {
		super(userId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<XAddressBookModel> getListAddr() {
		return listAddr;
	}

	public void setListAddr(List<XAddressBookModel> listAddr) {
		this.listAddr = listAddr;
	}

	public List<XMenuModel> getListMenu() {
		return listMenu;
	}

	public void setListMenu(List<XMenuModel> listMenu) {
		this.listMenu = listMenu;
	}
}
