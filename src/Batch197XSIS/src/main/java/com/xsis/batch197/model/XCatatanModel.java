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
@Table(name="x_catatan")
public class XCatatanModel extends BaseModel {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="x_keluarga_idx")
	@TableGenerator(name="x_keluarga_idx", table="x_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id", length=11)
	private Long id;
	
	@Column(name="biodata_id", nullable=false, length=11)
	private Long biodataId;
	
	@Column(name="title", nullable=true, length=100)
	private String title;
	
	@Column(name="note_type_id", nullable=true, length=11)
	private Long noteTypeId;
	
	@ManyToOne
	@JoinColumn(name="note_type_id", foreignKey=@ForeignKey(name="fk_catatan_notetype_id"), insertable=false, updatable=false)
	private XNoteTypeModel noteType;
	
	@Column(name="notes", nullable=true, length=1000)
	private String notes;
	
	@ManyToOne
	@JoinColumn(name="biodata_id", foreignKey=@ForeignKey(name="fk_catatan_bio_id"), insertable=false, updatable=false)
	private XBiodataModel biodata;
	
	@ManyToOne
	@JoinColumn(name="created_by", foreignKey=@ForeignKey(name="fk_catatan_addrb_id"), insertable=false, updatable=false)
	private XAddressBookModel user;
	
	public XCatatanModel() {
		super();
	}
	
	public XCatatanModel(Long userId, Long biodataId) {
		super(userId);
		this.biodataId=biodataId;
	}

	public XNoteTypeModel getNoteType() {
		return noteType;
	}

	public void setNoteType(XNoteTypeModel noteType) {
		this.noteType = noteType;
	}

	public XAddressBookModel getUser() {
		return user;
	}

	public void setUser(XAddressBookModel user) {
		this.user = user;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getNoteTypeId() {
		return noteTypeId;
	}

	public void setNoteTypeId(Long noteTypeId) {
		this.noteTypeId = noteTypeId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public XBiodataModel getBiodata() {
		return biodata;
	}

	public void setBiodata(XBiodataModel biodata) {
		this.biodata = biodata;
	}
	
}
