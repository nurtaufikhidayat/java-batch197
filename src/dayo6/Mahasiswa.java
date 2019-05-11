package dayo6;

import day05.Orang;

public class Mahasiswa extends Orang {
	public String nim;
	public String jurusan;
	public String fakultas;
	public String angkatan;
	public double ipk;
	
	public void cetakData() {
		super.cetakData();
		System.out.println("NIM \t\t: "+ nim);
		System.out.println("Jurusan \t: "+ jurusan);
		System.out.println("Fakultas \t: "+ fakultas);
		System.out.println("IPK \t\t: "+ ipk);
	}
}
