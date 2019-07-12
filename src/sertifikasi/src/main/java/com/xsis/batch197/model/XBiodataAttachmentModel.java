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
@Table(name="x_biodata_attachment")
public class XBiodataAttachmentModel extends BaseModel {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_biodata_attachment_idx")
	@TableGenerator(name="x_biodata_attachment_idx", table="x_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id", length=11)
	private Long id;

	@Column(name="biodata_id", nullable=false, length=11)
	private Long biodataId;
	
	@Column(name="file_name", nullable=true, length=100)
	private String fileName;
	
	@Column(name="file_path", nullable=true, length=1000)
	private String filePath;
	
	@Column(name="notes", nullable=true, length = 1000)
	private String notes;
	
	@Column(name="is_photo", nullable=true, length=1)
	private Integer isPhoto;
	
	@ManyToOne
	@JoinColumn(name="biodata_id", foreignKey=@ForeignKey(name="fk_attch_biodata_id"), insertable=false, updatable=false)
	private XBiodataModel biodata;
	
	public XBiodataAttachmentModel() {
		super();
	}
	
	public XBiodataAttachmentModel(Long userId, Long biodataId) {
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getIsPhoto() {
		return isPhoto;
	}

	public void setIsPhoto(Integer isPhoto) {
		this.isPhoto = isPhoto;
	}

	public XBiodataModel getBiodata() {
		return biodata;
	}

	public void setBiodata(XBiodataModel biodata) {
		this.biodata = biodata;
	}
}
