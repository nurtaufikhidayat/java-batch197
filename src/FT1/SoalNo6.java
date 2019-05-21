package FT1;

import java.util.Arrays;

public class SoalNo6 {
	
	public static void main(String[] args) {
		int[] case1 = new int[] {1, 2, 4, 7, 8, 6, 9};
		miniMax(case1);
	}
	
	static void miniMax(int[] arr) {
		//mengurutkan array
		Arrays.sort(arr);
		//deklarasi variable n 
		int n = 3;
		long min = 0, max = 0;
		//perulangan 
		for (int i = 0; i < n; i++) {
			//min dimulai dari indeks ke 0
			min += arr[i];
			//max dimulai dari index ke 
			max += arr[arr.length-1-i];
		}
		System.out.println(min + " " + max);
	}
}
