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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "x_address")
public class XAddressModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_address_idx")
	@TableGenerator(name = "x_address_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id", length=11)
	private Long id;
	
	@Column(name="created_by", length=11, nullable=false)
	private Long createdBy;
	
	@Column(name="created_on", nullable=false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdOn;
	
	@Column(name="modified_by", length=11, nullable=true)
	private Long modifiedBy;
	
	@Column(name="modified_on", nullable=true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date modifiedOn;
	
	@Column(name="deleted_by", length=11, nullable=true)
	private Long deletedBy;
	
	@Column(name="deleted_on", nullable=true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date deletedOn;
	
	@Column(name="is_delete", nullable=false)
	private Boolean isDelete;
	
	@NotNull
	@Column(name="biodata_id", length=11, nullable=false)
	private Long biodataId;
	
	@NotEmpty(message="Tidak boleh kosong")
	@Column(name="address1", length=1000, nullable=true)
	private String address1;
	
	@NotEmpty(message="Tidak boleh kosong")
	@Column(name="postal_code1", length=20, nullable=true)
	private String postalCode1;
	
	@NotEmpty(message="Tidak boleh kosong")
	@Column(name="rt1", length=5, nullable=true)
	private String rt1;
	
	@NotEmpty(message="Tidak boleh kosong")
	@Column(name="rw1", length=5, nullable=true)
	private String rw1;
	
	@NotEmpty(message="Tidak boleh kosong")
	@Column(name="kelurahan1", length=100, nullable=true)
	private String kelurahan1;
	
	@NotEmpty(message="Tidak boleh kosong")
	@Column(name="kecamatan1", length=100, nullable=true)
	private String kecamatan1;
	
	@NotEmpty(message="Tidak boleh kosong")
	@Column(name="region1", length=100, nullable=true)
	private String region1;
	
	@NotEmpty(message="Tidak boleh kosong")
	@Column(name="address2", length=1000, nullable=true)
	private String address2;
	
	@NotEmpty(message="Tidak boleh kosong")
	@Column(name="postal_code2", length=20, nullable=true)
	private String postalCode2;

	@NotEmpty(message="Tidak boleh kosong")
	@Column(name="rt2", length=5, nullable=true)
	private String rt2;
	
	@NotEmpty(message="Tidak boleh kosong")
	@Column(name="rw2", length=5, nullable=true)
	private String rw2;
	
	@NotEmpty(message="Tidak boleh kosong")
	@Column(name="kelurahan2", length=100, nullable=true)
	private String kelurahan2;
	
	@NotEmpty(message="Tidak boleh kosong")
	@Column(name="kecamatan2", length=100, nullable=true)
	private String kecamatan2;
	
	@NotEmpty(message="Tidak boleh kosong")
	@Column(name="region2", length=100, nullable=true)
	private String region2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Long getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Date getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(Date deletedOn) {
		this.deletedOn = deletedOn;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Long getBiodataId() {
		return biodataId;
	}

	public void setBiodataId(Long biodataId) {
		this.biodataId = biodataId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getPostalCode1() {
		return postalCode1;
	}

	public void setPostalCode1(String postalCode1) {
		this.postalCode1 = postalCode1;
	}

	public String getRt1() {
		return rt1;
	}

	public void setRt1(String rt1) {
		this.rt1 = rt1;
	}

	public String getRw1() {
		return rw1;
	}

	public void setRw1(String rw1) {
		this.rw1 = rw1;
	}

	public String getKelurahan1() {
		return kelurahan1;
	}

	public void setKelurahan1(String kelurahan1) {
		this.kelurahan1 = kelurahan1;
	}

	public String getKecamatan1() {
		return kecamatan1;
	}

	public void setKecamatan1(String kecamatan1) {
		this.kecamatan1 = kecamatan1;
	}

	public String getRegion1() {
		return region1;
	}

	public void setRegion1(String region1) {
		this.region1 = region1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPostalCode2() {
		return postalCode2;
	}

	public void setPostalCode2(String postalCode2) {
		this.postalCode2 = postalCode2;
	}

	public String getRt2() {
		return rt2;
	}

	public void setRt2(String rt2) {
		this.rt2 = rt2;
	}

	public String getRw2() {
		return rw2;
	}

	public void setRw2(String rw2) {
		this.rw2 = rw2;
	}

	public String getKelurahan2() {
		return kelurahan2;
	}

	public void setKelurahan2(String kelurahan2) {
		this.kelurahan2 = kelurahan2;
	}

	public String getKecamatan2() {
		return kecamatan2;
	}

	public void setKecamatan2(String kecamatan2) {
		this.kecamatan2 = kecamatan2;
	}

	public String getRegion2() {
		return region2;
	}

	public void setRegion2(String region2) {
		this.region2 = region2;
	}

}
