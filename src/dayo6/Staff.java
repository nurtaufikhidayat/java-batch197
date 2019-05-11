package dayo6;

import day05.Orang;

public class Staff extends Orang {
	public String nik;
	public String jabatan;
	public int gaji;
	public String departemen;
	public Orang atasan; //agregation(Orang)
	
	public void cetakData() {
		super.cetakData();
		System.out.println("NIK \t\t: "+ nik);
		System.out.println("Jabatan \t: "+ jabatan);
		System.out.println("Gaji \t\t: "+ gaji);
		System.out.println("Departemen \t: "+ departemen);
		System.out.println("Atasan \t\t: "+ atasan.nama);
	}
}
