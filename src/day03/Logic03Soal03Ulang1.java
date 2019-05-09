package day03;

import java.util.Scanner;

public class Logic03Soal03Ulang1 {

	public static Scanner input;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input N : ");
		int n = input.nextInt();
		System.out.println("Input M : ");
		int m = input.nextInt();
		System.out.println("Input O : ");
		int o = input.nextInt();

		int arr[][] = new int[n][n];
		int[] array = deretTiga(n * 4, m, o);
		int index = 0;
		for (int i = 0; i < n; i++) {
			arr[0][i] = array[index];
			index++;
		}

		// kebawah kanan
		for (int i = 1; i < n; i++) {
			arr[i][n - 1] = array[index];
			index++;
		}
		// bawah ke kiri
		for (int i = n - 2; i >= 0; i--) {
			arr[6][i] = array[index];
			index++;
		}
		// bawah keatas
		for (int i = n - 2; i >= 1; i--) {
			arr[i][0] = array[index];
			index++;
		}

		// cetak array
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	static int[] deretTiga(int n, int m, int o) {
		int arr[] = new int[n];
		int angka = o;
		for (int i = 0; i < n; i++) {

			// mencari posisi 3
			if (i % (m + 1) == m) {
				arr[i] = m;
			} else {
				arr[i] = angka;
				angka += m;
			}
		}
		return arr;
	}

}
