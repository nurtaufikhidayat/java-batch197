package day02;


public class diagonalDifference {

	public static void main(String[] args) {
		        int array[][] = new int [][] {{11,2,4},{4,5,6},{10,8,-12}};
		        int d1 = 0, d2 = 0;
		        for(int i = 0; i < array.length; i++){
		            for(int j = 0; j<array[i].length; j++){
		            	System.out.print(array[i][j]+"\t");
		                if(i==j){
		                    d1 = d1 + array[i][j];
		                }
		                if(i+j==array.length-1){
		                    d2 = d2 + array[i][j];
		                }
		            }
		            System.out.println("\n");
		        }
		       
		        System.out.println(Math.abs(d1-d2));

	}

}
