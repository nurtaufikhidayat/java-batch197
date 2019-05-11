package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Tes {

	public static Scanner input;

	public static void main(String[] args) {

//		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//		int data = 0;
//
//		String[] id = new String[5];
//		String[] nama = new String[30];
//		String[] alamat = new String[60];
//		String[] jk = new String[10];
//		String[] noTelp = new String[15];
//
//		try {
//			System.out.println("Masukan banyaknya data : ");
//			data = Integer.parseInt(input.readLine());
//			for (int i = 1; i <= data; i++) {
//				System.out.println("Data ke" + i);
//				System.out.print("Masukan ID               =");
//				id[i] = input.readLine();
//				System.out.print("Masukan Nama             = ");
//				nama[i] = input.readLine();
//				System.out.print("Masukan Alamat           = ");
//				alamat[i] = input.readLine();
//				System.out.print("Masukan Jenis Kelamin    = ");
//				jk[i] = input.readLine();
//				System.out.print("Masukan Nomor Telepon    = ");
//				noTelp[i] = input.readLine();
//				System.out.println();
//			}
//		} catch (IOException e) {
//			System.out.println("Error");
//		}
//		
//		System.out.println();
//		System.out.println("Data Bootcamp Batch 197");
//		for (int j = 1; j <= data; j++) {
//			System.out.println("Data Ke" + j);
//			System.out.println("===========================");
//			System.out.println("ID 	\t: " + id[j]);
//			System.out.println("Nama 	\t: " + nama[j]);
//			System.out.println("Alamat 	\t: " + alamat[j]);
//			System.out.println("Jenis Kelamin \t: " + jk[j]);
//			System.out.println("No telep \t: " + noTelp[j]);
//			System.out.println("===========================");
//		}

//		int namaVariable;
//		Orang org01 = new Orang(); // Orang = tipe data, org01 = object
//		org01.id = "1";
//		org01.nama = "Nur Taufik Hidayat";
//		org01.alamat = "Cibitung, Bekasi";
//		org01.jk = "Laki-Laki";
//		org01.noTelp = "085693747984";
//
//		System.out.println("ID 	\t: " + org01.id);
//		System.out.println("Nama 	\t: " + org01.nama);
//		System.out.println("Alamat 	\t: " + org01.alamat);
//		System.out.println("Jenik Kelamin \t: " + org01.jk);
//		System.out.println("No telep \t: " + org01.noTelp);
////		
//		org01.cetakData();
//
//		Orang org02 = new Orang();
//
//		org02.id = "2";
//		org02.nama = "Arif";
//		org02.alamat = "Depok";
//		org02.jk = "Laki-Laki";
//		org02.noTelp = "082131232";
//
//		System.out.println("ID 	\t: " + org02.id);
//		System.out.println("Nama 	\t: " + org02.nama);
//		System.out.println("Alamat 	\t: " + org02.alamat);
//		System.out.println("Jenik Kelamin \t: " + org02.jk);
//		System.out.println("No telep \t: " + org02.noTelp);
//
//		int hasil = org02.perhitungan(2, 3, 4);
//		System.out.println(hasil);
		
		
		
		Orang org04 = new Orang("1", "arfan", "bekasi", "laki", "1231232"); //new Orang sebagai construct
		org04.cetakData();
	}

}
