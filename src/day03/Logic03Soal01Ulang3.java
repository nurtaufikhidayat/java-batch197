package day03;

import java.util.Scanner;

public class Logic03Soal01Ulang3 {

	public static Scanner input;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input N1 : ");
		int n = input.nextInt();
		
		//deret 1
		int arr[][] = new int[n][n];
		int [] deret = new int[n];
		
		int awal = 1;

		for(int i = 0; i < deret.length; i++) {
			deret[i] = awal;
			awal = awal + (i+2);
		}
		
		//deret2
		int awal2 = 2;
		int[] deret2 = new int [n]; 
		for (int j = 0; j < deret2.length; j++) {
			deret2[j] =  awal2;
			awal2 = awal2 + (2 * (j+1));
			
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				//diagonal kanan bawah
				if(i == j) {
					arr[i][j]= deret[i];
				}
				if(i+j == n -1) {
					arr[i][j]= deret2[j];
					
				}
				System.out.print(arr[i][j] + "\t");		
				
			}
			System.out.println();
		}
		}

}
