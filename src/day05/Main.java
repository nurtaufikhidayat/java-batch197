package day05;

import java.util.Scanner;

public class Main {

	public static Scanner input;
	public static int n;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Masukan banyak data : ");
		int banyakInput = input.nextInt();
		
		n = banyakInput;
		Orang org = new Orang();
		
		System.out.println();
		for (int i = 0; i < banyakInput; i++) {
			System.out.println("Data Ke" + (i+1));
			System.out.print("Masukan ID               =");
			org.listId[i] = input.next();
			System.out.print("Masukan Nama             = ");
			org.listNama[i] = input.next();
			System.out.print("Masukan Alamat           = ");
			org.listAlamat[i]= input.next();
			System.out.print("Masukan Jenis Kelamin    = ");
			org.listJk[i]= input.next();
			System.out.print("Masukan Nomor Telepon    = ");
			org.listNoTelp[i] = input.next();
			System.out.println();
		}
	
		System.out.println();
		System.out.println("Data Bootcamp Batch 197");
		for (int j = 0; j < banyakInput; j++) {
			System.out.println("Data Ke" + (j+1));
			System.out.println("===========================");
			System.out.println("ID 	\t: " + org.listId[j]);
			System.out.println("Nama 	\t: " + org.listNama[j]);
			System.out.println("Alamat 	\t: " + org.listAlamat[j]);
			System.out.println("Jenis Kelamin \t: " + org.listJk[j]);
			System.out.println("No telep \t: " + org.listNoTelp[j]);
			System.out.println("===========================");
		}
	}

}
