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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "x_online_test_detail")
public class XOnlineTestDetailModel {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_online_test_detail_idx")
	@TableGenerator(name = "x_online_test_detail_idx", table = "tbl_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
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

	@Column(name = "online_test_id", length = 11, nullable = true)
	private Long onlineTestId;

	@Column(name = "test_type_id", length = 11, nullable = true)
	private Long testTypeId;

	@Column(name = "test_order", nullable = true)
	private Integer testOrder;

}
