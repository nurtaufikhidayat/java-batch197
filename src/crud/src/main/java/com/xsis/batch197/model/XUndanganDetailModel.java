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
@Table(name = "x_undangan_detail")
public class XUndanganDetailModel {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_undangan_detail_idx")
	@TableGenerator(name = "x_undangan_detail_idx", table = "tbl_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
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

	@Column(name = "undangan_id", length = 11, nullable = false)
	private Long undanganId;

	@Column(name = "biodata_id", length = 11, nullable = false)
	private Long biodataId;

	@Column(name = "notes", length = 1000, nullable = true)
	private String notes;
	
	
}
