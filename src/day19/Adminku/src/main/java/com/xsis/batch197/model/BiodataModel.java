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
@Table(name="tbl_biodata")
public class BiodataModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="biodata_idx")
	@TableGenerator(name="biodata_idx", table="tbl_index", pkColumnName="index_id", valueColumnName="index_value", initialValue=0, allocationSize=1)
	@Column(name="id")
	private Long id;
	
	@Column(name="nik", length=20, nullable=false)
	@NotNull
	private String nik;
	
	@Column(name="nama", length=100, nullable=false)
	@NotNull
	private String nama;
	
	@Column(name="alamat", length=100, nullable=false)
	private String alamat;
	
	@Column(name="kelurahan_id", length=100, nullable=false)
	private Long kelurahanId;
	
	@Column(name="kecamatan_id", length=100, nullable=false)
	private Long kecamatanId;
	
	@Column(name="kota_id", length=100, nullable=false)
	private Long kotaId;
	
	@Column(name="provinsi_id", length=100, nullable=false)
	private Long provinsiId;
	
	@Column(name="jk", length=10, nullable=false)
	private String jk;
	
	@Column(name="tpt_lahir", length=100, nullable=false)
	private String tptLahir;
	
	@Column(name="tgl_lahir", nullable=false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date tglLahir;
	
	@Column(name="agama", length=20, nullable=false)
	private String agama;
	
	@Column(name="gol_darah", length=2, nullable=false)
	private String golDarah;
	
	@Column(name="status_nikah", length=10, nullable=false)
	private String statusNikah;
	
	@Column(name="warga_negara", length=5, nullable=false)
	private String wargaNegara;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public Long getKelurahanId() {
		return kelurahanId;
	}

	public void setKelurahanId(Long kelurahanId) {
		this.kelurahanId = kelurahanId;
	}

	public Long getKecamatanId() {
		return kecamatanId;
	}

	public void setKecamatanId(Long kecamatanId) {
		this.kecamatanId = kecamatanId;
	}

	public Long getKotaId() {
		return kotaId;
	}

	public void setKotaId(Long kotaId) {
		this.kotaId = kotaId;
	}

	public Long getProvinsiId() {
		return provinsiId;
	}

	public void setProvinsiId(Long provinsiId) {
		this.provinsiId = provinsiId;
	}

	public String getJk() {
		return jk;
	}

	public void setJk(String jk) {
		this.jk = jk;
	}

	public String getTptLahir() {
		return tptLahir;
	}

	public void setTptLahir(String tptLahir) {
		this.tptLahir = tptLahir;
	}

	public Date getTglLahir() {
		return tglLahir;
	}

	public void setTglLahir(Date tglLahir) {
		this.tglLahir = tglLahir;
	}

	public String getAgama() {
		return agama;
	}

	public void setAgama(String agama) {
		this.agama = agama;
	}

	public String getGolDarah() {
		return golDarah;
	}

	public void setGolDarah(String golDarah) {
		this.golDarah = golDarah;
	}

	public String getStatusNikah() {
		return statusNikah;
	}

	public void setStatusNikah(String statusNikah) {
		this.statusNikah = statusNikah;
	}

	public String getWargaNegara() {
		return wargaNegara;
	}

	public void setWargaNegara(String wargaNegara) {
		this.wargaNegara = wargaNegara;
	}
}
