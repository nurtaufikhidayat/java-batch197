package day01;

import java.util.Scanner;

public class Logic01Soal10Ulang5 {

	protected static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Input your number = ");
		int n = input.nextInt();
		
		int number = 3;		
		for(int i = 0; i<n; i++) {
			
			if(i == 3) {
				System.out.print("xxx" + "\t");
			} else {
				System.out.print(number +"\t");
			}
			number = number * 3;
		}
	}
}
