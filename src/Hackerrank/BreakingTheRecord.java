package Hackerrank;

import java.util.Arrays;

public class BreakingTheRecord {
	public static void main(String[] args) {
		int[] array1 = breakingRecords(new int[] { 10, 5, 20, 20, 4, 5, 2, 25, 1 });
		System.out.println(Arrays.toString(array1));
		int[] array2 = breakingRecords(new int[] { 3, 4, 21, 36, 10, 28, 35, 5, 24, 42 });
		System.out.println(Arrays.toString(array2));
	}

	static int[] breakingRecords(int[] scores) {
		int max = 0;
		int min = 0;
		int vMax = scores[0];
		int vMin = scores[0];

		for (int i = 1; i < scores.length; i++) {
			if (scores[i] > vMax) {
				max++;
				vMax = scores[i];
			}
			if (scores[i] < vMin) {
				min++;
				vMin = scores[i];
			}

		}

		return new int[] { max, min };
	}
}
