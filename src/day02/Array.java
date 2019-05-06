package day02;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = new int [] {1,2,3,4,5};
		System.out.println(array[0]);
		System.out.println(array[4]);
		int hasil = 0;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			hasil = hasil + array[i];
		}
		System.out.println(hasil);
	}

}
