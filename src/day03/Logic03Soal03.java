package day03;

public class Logic03Soal03 {

	public static void main(String[] args) {
		int array[][]= new int[][] {{1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13,14,15},
			{16,17,18,19,20},
			{21,22,23,24,25}};
		int d1= 0, d2=0;
		for(int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]+"\t");
				if (i == j) {
					d1 = d1 + array[i][j];
				}
				if (i+j == array.length -1) {
					d2 = d2 + array[i][j];
				}
					
			}
			System.out.println();
		}
		System.out.println(Math.abs(d1-d2));
	}

}
