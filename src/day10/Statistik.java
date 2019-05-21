package day10;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Statistik {
	public static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Masukan Input : ");
		String n = input.nextLine();

		String[] arrayString = n.split(" ");
		int[] arrayInput = new int[arrayString.length];
		for (int i = 0; i < arrayInput.length; i++) {
			arrayInput[i] = Integer.parseInt(arrayString[i]);
		}

		modus(arrayInput);
		median(arrayInput);
		mean(arrayInput);
		bubbleSort(arrayInput);

//		modus(new int[] { 2, 2, 2, 3, 4, 5, 6, 7, 7, 8, 9, 3, 3, 2, 4, 4, 6, 6 });
//		modus(new int[] { 2, 3, 4, 2, 2, 5, 8, 7, 9, 3, 4, 5, 6, 2, 3, 3, 1, 1 });
//		modus(new int[] { 1, 2, 4, 2, 2, 5, 8, 7, 9, 3, 4, 8, 6, 8, 7, 3, 4, 1 });
//		median(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 9 });
//		median(new int[] { 2, 4, 6, 3, 4, 6, 7, 8, 9 });
//		median(new int[] { 7, 7, 4, 3, 1, 4, 9, 9, 1 });
	}

	public static void modus(int[] array) {
		HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
		Arrays.sort(array);

		// looping sebanyak panjang array
		for (int i = 0; i < array.length; i++) {

			// .containsKey berfungsi sebagai pembanding
			// apakah ada nilai (array ke-i)
			// dibagian key pada Map
			// Bernilai TRUE apabila nilai tersebut sudah diinisialisasi
			if (data.containsKey(array[i])) {
				// .get will return value to which the specified key is mapped
				// yang mana value ini adalah jumlah kemunculan
				int value = data.get(array[i]);
				value++;
				// update jumlah kemunculan nilai
				data.put(array[i], value);

			} else {
				// berikan key-dataInput dengan nilai array ke-i
				// berikan value-dataInput dengan nilai inisialisasi jumlah kemunculan yaitu 1
				data.put(array[i], 1);

			}

		}
		int key = Collections.max(data.entrySet(), Map.Entry.comparingByValue()).getKey();
		int value = Collections.max(data.values());
		System.out.println("modus : " + key + " value : " + value);
	}

	public static void median(int[] array) {
		Arrays.sort(array);
		float median = 0;
		if (array.length % 2 == 0) {
			median = (float) (array[array.length / 2] + array[array.length / 2] - 1);
			median /= 2;
		} else {
			median = (float) (array[array.length / 2]);
			System.out.println("Median : " + median);
		}
		System.out.println("Median : " + median);
	}

	public static void mean(int[] array) {
		double sum = 0;
		double mean = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		mean = (double) (sum / array.length);
		System.out.println("mean : " + mean);
	}

	public static void bubbleSort(int[] array) {
		int temp = 0;

		// looping
		for (int i = 0; i < array.length; i++) {
			// looping pembanding
			for (int j = 0; j < (array.length - 1); j++) {
				// if arr[before] > arr[after]
				if (array[j] > array[j + 1]) {
					// simpan nilai sementara arr[before]
					temp = array[j];
					// berikan nilai arr[after] kepada arr[before]
					array[j] = array[j + 1];
					// berikan nilai sementara kepada arr[after]
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
