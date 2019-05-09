package day03;

import java.util.Scanner;

public class Logic03Soal06 {
	
	public static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Masukan N : ");
		int n = input.nextInt();
		System.out.println("Masukan M : ");
		int m = input.nextInt();
		
		int[] deret = deretAngka6(n,m);
		for (int i = 0; i < deret.length; i++) {
			System.out.print(deret[i] + "\t");
		}
		for (int i = 0; i <= m; i++) {
			System.out.println("");
			System.out.println("geser ke" + i);
			int temp = deret[0];
			for (int j = 0; j < n-1 ; j++) {
				deret[j] = deret[j+1];
			}
			deret[n-1] = temp;
			for (int x = 0; x < n; x++) {
				System.out.print(deret[x] + "\t");
			}
		}
	}
	
	static int[] deretAngka6(int n, int m) {
		int[] hasil = new int[n];
		int awal = 2;
		int tambah = 2;
		
		for (int i = 0; i < n; i++) {
			hasil[i] = awal;
			awal = awal + tambah;
			tambah = tambah + 2;
		}
		return hasil;
		
	}

}
