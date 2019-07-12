package com.xsis.batch197.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="x_company")
public class XCompanyModel extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_company_idx")
	@TableGenerator(name="x_company_idx", table = "x_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
	@Column(name="id")
	private Long id;
	
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
	
	@OneToMany(mappedBy="company")
	private List<XBiodataModel> listBiodata = new ArrayList<XBiodataModel>();
	
	public XCompanyModel() {
		super();
	}
	public XCompanyModel(String name, String desc) {
		super();
		this.description = desc;
		this.name= name;
	}
	
	public XCompanyModel(String name, String desc, Long userId) {
		super(userId);
		this.description = desc;
		this.name= name;
	}
	
	public XCompanyModel(Long userId) {
		super(userId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<XBiodataModel> getListBiodata() {
		return listBiodata;
	}

	public void setListBiodata(List<XBiodataModel> listBiodata) {
		this.listBiodata = listBiodata;
	}
	
}
