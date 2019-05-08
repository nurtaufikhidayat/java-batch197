package day02;

import java.util.Scanner;

public class Soal03 {
	
	public static Scanner input;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input N1 : ");
		int n1 = in.nextInt();
		System.out.println("Input N2 : ");
		int n2 = in.nextInt();
		System.out.println("Input N3 : ");
		int n3 = in.nextInt();
		int [] deret = new int[n1];
		for(int i = 0; i<n1; i++) {
			deret[i] = n2;
			if(i<n1/2) {
				n2 = n2 * n3;
			}else {
				n2 = n2 / n3;
			}
			System.out.print(deret[i] + "\t");
		}
		System.out.println();
		System.out.print("perhitungan = " + deret[n1/2]);
		int hasil = deret[n1/2];
		for(int i = n1/2 +1; i < n1/2 + 3; i++ ) {
			hasil = hasil -deret[i];
			System.out.print("-"+ deret[i]);
			
		}
		System.out.println("="+ hasil);
	}
}
