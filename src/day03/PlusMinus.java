package day03;

import java.lang.reflect.Array;

public class PlusMinus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void plusMinus(int[] arr) {
		double pos = 0;
		double neg = 0;
		double zer = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]> 0) {
				pos++;
			} else if(arr[i]<0) {
				neg++;
			} else {
				zer++;
			}
			
		}
		System.out.println(pos/arr.length);
		System.out.println(pos/arr.length);
		System.out.println(pos/arr.length);


    }


}
