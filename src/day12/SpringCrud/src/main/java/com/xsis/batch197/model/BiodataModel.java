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
@Table(name = "biodata")
public class BiodataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "biodata_seq")
    @TableGenerator(name = "biodata_seq", table = "tbl_sequences", pkColumnName = "seq_id", valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
    @Column(name = "id")
    private int id;
   
    @Column(name = "nama", length = 100)
    private String nama;
   
    @Column(name = "alamat", length = 225)
    private String alamat;
   
    @Column(name = "tpt_lahir", length = 50)
    private String tptLahir;
   
    @Column(name = "tgl_lahir")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tglLahir;
   
    @Column(name = "jk", length = 10)
    private String jk;
   
    @Column(name = "agama", length = 10)
    private String agama;
   
    @Column(name = "pekerjaan", length = 100)
    private String pekerjaan;
   
    @Column(name = "gol_darah", length = 2)
    private String golDarah;
 
    public int getId() {        //MembacaID
        return id;              //Mengakses id dari get & set
    }
 
    public void setId(int id) { //MenuliskanID
        this.id = id;
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
 
    public String getJk() {
        return jk;
    }
 
    public void setJk(String jk) {
        this.jk = jk;
    }
 
    public String getAgama() {
        return agama;
    }
 
    public void setAgama(String agama) {
        this.agama = agama;
    }
 
    public String getPekerjaan() {
        return pekerjaan;
    }
 
    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }
 
    public String getGolDarah() {
        return golDarah;
    }
 
    public void setGolDarah(String golDarah) {
        this.golDarah = golDarah;
    }
   
}