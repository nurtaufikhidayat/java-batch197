package day01;

import java.util.Scanner;

public class Staircase {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		  Scanner in = new Scanner(System.in);
	        int n = scanner.nextInt();
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (j < n - 1 - i) {
	                    System.out.print(" ");
	                } else {
	                    System.out.print("#");
	                }
	            }
	            System.out.println("");
	        }

	}

}
