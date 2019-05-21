package FT1;

import java.util.Scanner;

public class SoalNo3 {
	public static Scanner input;

	public static void main(String[] args) {
//		input = new Scanner(System.in);
//		System.out.println("Masukan Input : ");
//		String n = input.nextLine();
//
//		String[] arrayString = n.split(" ");
//		int[] arrayInput = new int[arrayString.length];
//		for (int i = 0; i < arrayInput.length; i++) {
//			arrayInput[i] = Integer.parseInt(arrayString[i]);
//		}
//		bubbleSort(arrayInput);
		int[] case1 = new int[] { 1, 10, 2, 20, 3 };
		bubbleSort(case1);
	}

	public static void bubbleSort(int[] array) {
		int temp = 0;

		// looping
		for (int i = 0; i < array.length; i++) {
			// looping pembanding
			for (int j = 0; j < array.length - 1; j++) {
				// jika isi array sebelumnya lebih besar dari aray sesudah
				if (array[j] < array[j + 1]) {
					// simpan nilai sementara isi array sebelum
					temp = array[j];
					// berikan nilai isi dari array after kepada array before
					array[j] = array[j + 1];
					// berikan nilai isi dari sementara ke array after
					array[j + 1] = temp;
				}
			}
		}
		// cetak hasil array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");

		}
	}

}
