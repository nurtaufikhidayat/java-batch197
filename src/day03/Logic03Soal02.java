package day03;

import java.util.Scanner;

public class Logic03Soal02 {

	protected static Scanner input;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Masukan nilai N :");
		int n = input.nextInt();
		System.out.println("Masukan nilai M :");
		int m = input.nextInt();
		System.out.println("Masukan nilai O :");
		int o = input.nextInt();
		int array[][] = new int [n][n];
		
		//deklarasi panjang deret
		int[] deret = deretNo2(n * 4, m, o);
		int index = 0;
		
		//deret diagonal
		for (int i = 0; i < n; i++) {
			array[n-1-i][i] = deret[index];
			index++;
		}
		
		//deret kanan kebawah
		for (int i = 1; i < n; i++) {
			array[i][n-1] = deret[index];
			index++;
		}
		
		//deret bawah ke kiri
		for (int i = n-2; i > 0; i--) {
			array[n-1][i] = deret[index];
			index++;
		}
		// cetak array
				for (int i = 0; i < array.length; i++) {
					for (int j = 0; j < array[i].length; j++) {
						System.out.print(array[i][j] + "\t");
					}
					System.out.println("\n");
				}
	}

	//methode untuk membuat deret
	static int[] deretNo2(int n, int m, int o) {
		//buat array untuk deret
		int [] arr= new int[n];
		int angka = o;
		int temp = m ;
		for (int i = 0; i < arr.length; i++) {
			if (i%(m+1) == m) {
				arr[i] = temp;
				temp=temp*m;
			} else {
				arr[i]= angka;
				angka+= m;
			}
			
		}
		return arr;
	}

}
