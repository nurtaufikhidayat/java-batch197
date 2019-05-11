package dayo6;

import day05.Orang;

public class MainOOP {

	public static void main(String[] args) {
		Mahasiswa mhs = new Mahasiswa();
		mhs.id = "1";
		mhs.nama = "taufik";
		mhs.alamat = "cibitung";
		mhs.jk = "Laki";
		mhs.noTelp = "0856943747984";
		mhs.nim = "1k05";
		mhs.jurusan = "Teknik Informatika";
		mhs.fakultas = "Teknologi Industri";
		mhs.angkatan = "2014";
		mhs.ipk = 3.5;
		mhs.cetakData();
		
		
		Dosen dsn = new Dosen();
		dsn.id = "2";
		dsn.nama = "bambang";
		dsn.alamat = "depok";
		dsn.jk = "Laki";
		dsn.noTelp = "321323123";
		dsn.nik = "12ASD";
		dsn.spesialis = "mengaji";
		dsn.gaji = 1000000;
		dsn.jabatan = "Dosen Matematika";
		dsn.fakultas = "Teknologi Industri";
		dsn.cetakData();
		

		Staff  stf = new Staff();
		stf.id = "3";
		stf.nama = "lilis";
		stf.alamat ="cikarang";
		stf.jk = "perempuan";
		stf.noTelp = "323123213";
		stf.nik="12F2";
		stf.jabatan = "kurir";
		stf.gaji = 5000000;
		stf.departemen = "humas";
		
		
		Orang org01 = new Orang("4", "desi","cibuntu","perempuan","213213312");
		stf.atasan = org01;
		stf.cetakData();
	}

}
