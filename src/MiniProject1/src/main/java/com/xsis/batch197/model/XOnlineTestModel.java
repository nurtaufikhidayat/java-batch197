package com.xsis.batch197.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="x_online_test")
public class XOnlineTestModel extends BaseModel {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_keluarga_idx")
	@TableGenerator(name="x_keluarga_idx", table="x_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id", length=11)
	private Long id;
	
	@Column(name="biodata_id", nullable=true, length=11)
	private Long biodataId;
	
	@Column(name="period_code", nullable=true, length=11)
	private String periodCode;
	
	@Column(name="period", nullable=true)
	private Integer period;
	
	@Column(name="test_date", nullable=true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date testDate;
	
	@Column(name="expired_date", nullable=true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expiredDate;
	
	@Column(name="user_access", nullable=true, length=10)
	private String userAccess;
	
	@Column(name="status", nullable=true, length=50)
	private String status;
	
	@ManyToOne
	@JoinColumn(name="biodata_id", foreignKey=@ForeignKey(name="fk_oltest_bio_id"), insertable=false,updatable=false)
	private XBiodataModel biodata;
	
	@OneToMany(mappedBy="onlineTest")
	private List<XOnlineTestDetailModel> listDetail = new ArrayList<XOnlineTestDetailModel>();
	
	public XOnlineTestModel() {
		super();
	}
	
	public XOnlineTestModel(Long userId, Long biodataId) {
		super(userId);
		this.biodataId = biodataId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBiodataId() {
		return biodataId;
	}

	public void setBiodataId(Long biodataId) {
		this.biodataId = biodataId;
	}

	public String getPeriodCode() {
		return periodCode;
	}

	public void setPeriodCode(String periodCode) {
		this.periodCode = periodCode;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getUserAccess() {
		return userAccess;
	}

	public void setUserAccess(String userAccess) {
		this.userAccess = userAccess;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public XBiodataModel getBiodata() {
		return biodata;
	}

	public void setBiodata(XBiodataModel biodata) {
		this.biodata = biodata;
	}

	public List<XOnlineTestDetailModel> getListDetail() {
		return listDetail;
	}

	public void setListDetail(List<XOnlineTestDetailModel> listDetail) {
		this.listDetail = listDetail;
	}
}
