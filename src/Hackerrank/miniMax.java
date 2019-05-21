package Hackerrank;

import java.util.Scanner;

import java.util.*;

public class miniMax {

	// Complete the miniMaxSum function below.
	static void miniMaxSum(int[] arr) {
		Arrays.sort(arr);
		long min = 0, max = 0;
//		for (int i = 0; i < arr.length - 1; i++) {
//			min += arr[i];
//			max += arr[i+1];
//
//		}
		int n = 4;
		for (int i = 0; i < n; i++) {
			min += arr[i];
			max += arr[arr.length-1-i];

		}
		System.out.println(min + " " + max);
	}

	private static final Scanner scanner = new Scanner(System.in);
	public static Scanner input;

	public static void main(String[] args) {
//		input = new Scanner(System.in);
//		System.out.println("Masukan Deret : ");
//		String n = input.nextLine();
//		
//		String[] arrayString = n.split(" ");
//		int[] arrayInput = new int[arrayString.length];
//		
//
//		for (int i = 0; i < arrayInput.length; i++) {
//			arrayInput[i] = Integer.parseInt(arrayString[i]);
//		}
//
//		miniMaxSum(arrayInput);
//
//		scanner.close();
		int[] arrayInput = new int[] { 1, 2, 4, 6, 7, 8, 9 };
		miniMaxSum(arrayInput);

	}

}
