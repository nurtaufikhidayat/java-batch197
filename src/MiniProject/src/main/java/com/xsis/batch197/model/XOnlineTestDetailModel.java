package com.xsis.batch197.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "x_online_test_detail")
public class XOnlineTestDetailModel extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_online_test_detail_idx")
	@TableGenerator(name = "x_online_test_detail_idx", table = "x_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
	@Column(name = "id", length = 11)
	private Long id;

	@Column(name = "online_test_id", length = 11, nullable = true)
	private Long onlineTestId;

	@Column(name = "test_type_id", length = 11, nullable = true)
	private Long testTypeId;
	
	@ManyToOne
	@JoinColumn(name="test_type_id", foreignKey=@ForeignKey(name="fk_oldet_testype_id"), insertable=false,updatable=false)
	private XTestTypeModel textType;

	@Column(name = "test_order", nullable = true)
	private Integer testOrder;
	
	@ManyToOne
	@JoinColumn(name="online_test_id", foreignKey=@ForeignKey(name="fk_oldet_olparent_id"), insertable=false,updatable=false)
	private XOnlineTestModel onlineTest;
	
	public XOnlineTestDetailModel() {
		super();
	}
	
	public XOnlineTestDetailModel(Long userId) {
		super(userId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOnlineTestId() {
		return onlineTestId;
	}

	public void setOnlineTestId(Long onlineTestId) {
		this.onlineTestId = onlineTestId;
	}

	public Long getTestTypeId() {
		return testTypeId;
	}

	public void setTestTypeId(Long testTypeId) {
		this.testTypeId = testTypeId;
	}

	public Integer getTestOrder() {
		return testOrder;
	}

	public void setTestOrder(Integer testOrder) {
		this.testOrder = testOrder;
	}

	public XTestTypeModel getTextType() {
		return textType;
	}

	public void setTextType(XTestTypeModel textType) {
		this.textType = textType;
	}

	public XOnlineTestModel getOnlineTest() {
		return onlineTest;
	}

	public void setOnlineTest(XOnlineTestModel onlineTest) {
		this.onlineTest = onlineTest;
	}
}
