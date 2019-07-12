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
@Table(name = "x_identity_type")
public class XIdentityTypeModel extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_identity_type_idx")
	@TableGenerator(name = "x_identity_type_idx", table = "x_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
	@Column(name = "id", length=11)
	private Long id;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "description", length = 100, nullable = true)
	private String description;

	public XIdentityTypeModel() {
		super();
	}
	
	public XIdentityTypeModel(String name, String desc) {
		super();
		this.name=name;
		this.description=desc;
	}
	
	public XIdentityTypeModel(String name, String desc, Long userId) {
		super(userId);
		this.name=name;
		this.description=desc;
	}
	
	public XIdentityTypeModel(Long UserId) {
		super(UserId);
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
	
}
