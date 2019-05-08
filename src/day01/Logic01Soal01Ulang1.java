package day01;

import java.util.Scanner;

public class Logic01Soal01Ulang1 {
	
	protected static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Input your number : ");
		int n = input.nextInt();
		
		int number = 1;
		for (int i = 0; i < n; i++) {
			System.out.print(number + "\t");
			number = number + 2;
		}
	}

}
