package com.xsis.batch197.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "x_addrbook")
public class XAddressBookModel extends BaseModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_addrbook_idx")
	@TableGenerator(name = "x_addrbook_idx", table = "x_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
	@Column(name = "id", length = 11)
	private Long id;

	@NotNull
	@Column(name = "is_locked", nullable = false, length = 1)
	private Integer isLocked;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "email", length = 100, nullable = false)
	private String email;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "abuid", length = 50, nullable = false)
	private String abuid;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "abpwd", length = 225, nullable = false)
	private String abpwd;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "x_user_role", joinColumns = @JoinColumn(name = "addrbook_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_addr_role_id")), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_role_addr_id")), foreignKey = @ForeignKey(name = "fk_addr_role_id"), inverseForeignKey = @ForeignKey(name = "fk_role_addr_id"))
	private List<XRoleModel> listRole = new ArrayList<XRoleModel>();

	@OneToOne(mappedBy = "addressBook")
	private XBiodataModel biodata;

	public XAddressBookModel() {
		super();
	}

	public XAddressBookModel(String email, String username, String password) {
		super();
		this.email = email;
		this.abuid = username;
		this.abpwd = password;
		this.isLocked = 0;
		this.setIsDelete(0);
	}

	public XAddressBookModel(Long userId) {
		super(userId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Integer isLocked) {
		this.isLocked = isLocked;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbuid() {
		return abuid;
	}

	public void setAbuid(String abuid) {
		this.abuid = abuid;
	}

	public String getAbpwd() {
		return abpwd;
	}

	public void setAbpwd(String abpwd) {
		this.abpwd = abpwd;
	}

	public List<XRoleModel> getListRole() {
		return listRole;
	}

	public void setListRole(List<XRoleModel> listRole) {
		this.listRole = listRole;
	}

	public XBiodataModel getBiodata() {
		return biodata;
	}

	public void setBiodata(XBiodataModel biodata) {
		this.biodata = biodata;
	}
}
