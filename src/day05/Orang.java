package day05;

public class Orang {

	public String id;	
	public String nama;
	public String alamat;
	public String jk;
	public String noTelp;
	
	Main banyakInput = new Main();
	
	int kapasitas = banyakInput.n;
	
	public String[] listId = new String[kapasitas];
	public String[] listNama = new String[kapasitas];
	public String[] listAlamat = new String[kapasitas];
	public String[] listJk = new String[kapasitas];
	public String[] listNoTelp = new String[kapasitas];
	
	public int perhitungan(int a, int b, int c) {
		
		return a+b+c ;
	}
	
//	public Orang(String id, String nama, String alamat, String jk, String noTelp) {
//		this.id = id;
//		this.nama = nama;
//		this.alamat = alamat;
//		this.jk = jk;
//		this.noTelp = noTelp;
//		
//	}
	public void cetakData() {
		System.out.println("ID 	\t: " + id);
		System.out.println("Nama 	\t: " + nama);
		System.out.println("Alamat 	\t: " + alamat);
		System.out.println("Jenik Kelamin \t: " + jk);
		System.out.println("No telep \t: " + noTelp);
		
		
	}
}