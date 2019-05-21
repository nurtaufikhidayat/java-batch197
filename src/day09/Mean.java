package day09;

import java.util.Scanner;

public class Mean {

	public static Scanner input;
	public static void main(String[] args) {
		// inisialisasi
		input = new Scanner(System.in);
		int n, jml, nilai[];
		float rata, jumlah = 0;
		
		//input Siswa
		System.out.println("Masukan jumlah siswa : ");
		n = input.nextInt();
		
		//inisial array
		nilai = new int[n];
		
		//input nilai
		for (int i = 0; i <= n-1; i++) {
			System.out.println("Nilai siswa " + (i+1) + " : ");
			nilai[i] = input.nextInt();
			System.out.println();
		}
		//hitung jumlah
		for (int j = 0; j <= n - 1 ; j++) {
			jumlah = jumlah + nilai[j];
			
		}
		
		//hitung rata-rata
		rata = jumlah/n;
		
		//output
		System.out.println("Daftar Nilai Siswa");
		System.out.println("==================");
		System.out.println("Nilai Rata-Rata : " + jumlah);

	}

}
