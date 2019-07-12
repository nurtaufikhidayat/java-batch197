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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "x_address")
public class XAddressModel extends BaseModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_address_idx")
	@TableGenerator(name = "x_address_idx", table="x_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id", length=11)
	private Long id;

	@Column(name="biodata_id", length=11, nullable=false)
	private Long biodataId;
	
	@Column(name="address1", length=1000, nullable=true)
	private String address1;
	
	@Column(name="postal_code1", length=20, nullable=true)
	private String postalCode1;
	
	@Column(name="rt1", length=5, nullable=true)
	private String rt1;
	
	@Column(name="rw1", length=5, nullable=true)
	private String rw1;
	
	@Column(name="kelurahan1", length=100, nullable=true)
	private String kelurahan1;
	
	@Column(name="kecamatan1", length=100, nullable=true)
	private String kecamatan1;
	
	@Column(name="region1", length=100, nullable=true)
	private String region1;
	
	@Column(name="address2", length=1000, nullable=true)
	private String address2;
	
	@Column(name="postal_code2", length=20, nullable=true)
	private String postalCode2;
	
	@Column(name="rt2", length=5, nullable=true)
	private String rt2;
	
	@Column(name="rw2", length=5, nullable=true)
	private String rw2;
	
	@Column(name="kelurahan2", length=100, nullable=true)
	private String kelurahan2;
	
	@Column(name="kecamatan2", length=100, nullable=true)
	private String kecamatan2;
	
	@Column(name="region2", length=100, nullable=true)
	private String region2;
	
	@OneToOne
	@JoinColumn(name="biodata_id", foreignKey=@ForeignKey(name="fk_addr_bio_id"), insertable=false,updatable=false)
	private XBiodataModel biodata;
	
	public XAddressModel() {
		super();
	}
	
	public XAddressModel(Long userId, Long biodataId) {
		super(userId);
		this.biodataId=biodataId;
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

	public XBiodataModel getBiodata() {
		return biodata;
	}

	public void setBiodata(XBiodataModel biodata) {
		this.biodata = biodata;
	}
}
