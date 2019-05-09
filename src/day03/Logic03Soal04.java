package day03;

import java.util.Scanner;

public class Logic03Soal04 {

	public static Scanner input;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Masukkan N :");
		int n = input.nextInt();
		System.out.println("Masukkan M : ");
		int m = input.nextInt();

		int[] deret = deretAngka(n,m);
		for (int i = 0; i < n; i++) {
			System.out.print(deret[i] + "\t");
		}
		
		for (int i = 0; i <= m; i++) {
			System.out.println("");
			System.out.println("geser ke" + i);
			int temp = deret[n-1];
			for (int j = n-1; j > 0; j--) {
				deret[j] = deret[j-1];
			}
			deret[0] = temp;
			for (int x = 0; x < n; x++) {
				System.out.print(deret[x] + "\t");
		}

	}
	}
	
	static int[] deretAngka(int n, int m) {
		int hasil[] = new int [n];
		int awal = 1;
		int tambah = 2;
		for (int i = 0; i < n; i++) {
			hasil[i] = awal;
			awal = awal + tambah;
			tambah++;
		}
		return hasil;
	}
}
