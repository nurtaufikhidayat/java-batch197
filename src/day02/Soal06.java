package day02;

import java.util.Scanner;

public class Soal06 {

	public static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Masukan Kalimat : ");
		String text = input.next();
		
		int a = text.length();
		int b = 0;
		for (int i = 0; i<a; i++) {
			if(Character.isUpperCase(text.charAt(i))) {
				b++;
			}
		}
		System.out.println(text);
		System.out.println("Jumlah huruf besar : " + b);

	}

}
