package FT1;

import java.util.Scanner;

public class SoalNo7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Masukan String : ");
		String kalimat = scanner.nextLine();
		// variable untuk menampung hasil string yang dipisah
		String[] tempArray;
		// sebagai pemisah string
		String delimiter = "";
		// proses pemisahan
		tempArray = kalimat.split(delimiter);
		int n = tempArray.length;
		
		//perulangan dari string paling belakang
		for (int i = 0; i < n; i++) {
			//perulangan bintang sebelah kiri
			for (int a = 0; a < (n / 2); a++) {
				System.out.print("*");
			}
			System.out.print(tempArray[i]);
			//perulangan bintang sebelah kanan
			for (int a = 0; a < (n / 2); a++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
