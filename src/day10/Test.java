package day10;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {33, 2, 1, 5};
		min(a);
		
	}
	static void min(int[] arr) {

		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(min>arr[i])
				min = arr[i];
			
		}
		System.out.println(min);
	}
	

}
