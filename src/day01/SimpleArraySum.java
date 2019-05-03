package day01;

public class SimpleArraySum {

	public static void main(String[] args) {
	System.out.println(simpleArraySum(new int[] {1,2,3,4,10,11}));
	System.out.println(simpleArraySum(new int[] {1,2,3,4,10,11,12,13,14}));
	System.out.println(simpleArraySum(new int[] {1,2,3,4,10}));
	int jml1 = simpleArraySum(new int[] {555, 666,777});
	System.out.println(jml1);
	}
	static int simpleArraySum(int[] ar) {
		int hasil = 0;
		for (int i = 0; i < ar.length; i++) {
			hasil+=ar[i];
		}
		return hasil;
	}

}
