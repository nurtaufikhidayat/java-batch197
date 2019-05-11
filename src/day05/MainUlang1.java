package day05;

import java.util.Scanner;

public class MainUlang1 {

	public static Scanner input;
	public static int n;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Masukan Banyak data input  :");
		int banyakInput1 = input.nextInt();
		
		n = banyakInput1;
		
		Orang1 org = new Orang1();
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.println("Data Ke" + (i+1));
			System.out.println("Masukan ID            = ");
			org.listId[i] = input.next();
			System.out.println("Masukan Nama          = ");
			org.listNama[i] = input.next();
			System.out.println("Masukan Alamat        = ");
			org.listAlamat[i] = input.next();
			System.out.println("Masukan Jenis Kelamin = ");
			org.listJk[i] = input.next();
			System.out.println("Masukan No Telephone = ");
			org.listNoTelp[i] = input.next();
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Data Bootcamp Java Batch 197");
		for (int i = 0; i < n; i++) {
			System.out.println("Data Ke"+ (i+1));
			System.out.println("ID \t\t:" + org.listId[i]);
			System.out.println("Nama \t\t:" + org.listNama[i]);
			System.out.println("Alamat \t\t:" + org.listAlamat[i]);
			System.out.println("Jenis Kelamin \t:" + org.listJk[i]);
			System.out.println("No Telephone \t:" + org.listNoTelp[i]);
		}

	}

}
