package day02;
import java.util.Scanner;
public class Soal01 {
	public static Scanner input;
	public static void main(String[] args) {
	input =  new Scanner(System.in);
	System.out.println("input n1 : ");
	int n1 = Integer.parseInt(input.nextLine());
	System.out.println("input n2 : ");
	int n2 = Integer.parseInt(input.nextLine());
	System.out.println("");
	int angka = 1;
	int hasil = 0;
	int angka0 = 0;
	int angka1 = 0;
	int angka2 = 0;
	table(n1,angka);
	jumlah(n2, angka, hasil, angka0, angka1, angka2);
	}
	public static void table(int t1, int t2) {
		for (int counter = 0; counter < t1; counter++) {
			System.out.print(counter+"\t");
		}
		System.out.println("");
		for(int counter1 = 0; counter1 < t1; counter1++) {
			System.out.print(t2+"\t");
			t2=t2*3;
		}
	}
	
	public static void jumlah(int jN2, int jAngka, int jHasil, int jAngka0, int jAngka1, int jAngka2) {
		for(int counter = 0; counter<jN2; counter++) {
			switch(counter) {
			case 0:
				jAngka0 = jAngka;
				jHasil = jHasil + jAngka;
				break;
			case 1:
				jAngka1 = jAngka;
				jHasil = jHasil + jAngka;
				break;
			case 2:
				jAngka2 = jAngka;
				jHasil = jHasil + jAngka;
				break;
			}
			jAngka = jAngka * 3;
			
		}
		System.out.println("\n"+jAngka0 + " + " + jAngka1 + " + " + jAngka2 + " = " + jHasil );
	}
}


