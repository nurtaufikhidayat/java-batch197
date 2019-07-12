package com.xsis.batch197.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "x_schedule_type")
public class XScheduleTypeModel extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_schedule_type_idx")
	@TableGenerator(name = "x_schedule_type_idx", table = "x_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "description", length = 100)
	private String description;

	public XScheduleTypeModel() {
		super();
	}
	
	public XScheduleTypeModel(String name, String desc) {
		super();
		this.name=name;
		this.description=desc;
	}
	
	public XScheduleTypeModel(Long userId) {
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

}
