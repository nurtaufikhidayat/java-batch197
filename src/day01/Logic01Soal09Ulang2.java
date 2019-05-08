package day01;

import java.util.Scanner;

public class Logic01Soal09Ulang2 {

	protected static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Input your number : ");
		int n = input.nextInt();
		
		int number = 4;
		for (int i = 1; i <= n; i++) {
			
			if(i%3==0) {
				System.out.print("*" + "\t");
			} else {
				System.out.print(number + "\t");
				number = number * 4;
			}
			
			
		}


	}

}
