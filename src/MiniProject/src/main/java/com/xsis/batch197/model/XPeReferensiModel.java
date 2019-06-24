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
@Table(name="x_pe_referensi")
public class XPeReferensiModel extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "x_pe_referensi_idx")
	@TableGenerator(name = "x_pe_referensi_idx", table = "x_index", pkColumnName = "index_id", valueColumnName = "index_value", initialValue = 0, allocationSize = 1)
	@Column(name = "id", length = 11)
	private Long id;

	@Column(name = "biodata_id", nullable = false, length = 11)
	private Long biodataId;
	
	@ManyToOne
	@JoinColumn(name="biodata_id", foreignKey=@ForeignKey(name="fk_pereff_bio_id"), insertable=false, updatable=false)
	private XBiodataModel biodata;
	
	@Column(name = "name", nullable = true, length = 100)
	private String name;
	
	@Column(name = "position", nullable = true, length = 100)
	private String position;
	
	@Column(name = "address_phone", nullable = true, length = 1000)
	private String addressPhone;
	
	@Column(name = "relation", nullable = true, length = 100)
	private String relation;
	
	public XPeReferensiModel() {
		super();
	}
	
	public XPeReferensiModel(Long userId, Long biodataId) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAddressPhone() {
		return addressPhone;
	}

	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public XBiodataModel getBiodata() {
		return biodata;
	}

	public void setBiodata(XBiodataModel biodata) {
		this.biodata = biodata;
	}
}
