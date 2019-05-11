package Hackerrank;

import java.util.Scanner;

public class CamelCase {

	public static Scanner input;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String s = in.next();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                count++;
            }
        }
        System.out.println(count + 1);

	}
	
//	 static int camelcase(String s) {
////		 String s = in.next();
////	        int count = 0;
////	        for (int i = 0; i < s.length(); i++) {
////	            if (Character.isUpperCase(s.charAt(i))) {
////	                count++;
////	            }
////	        }
////			return s;
////		 
////
//	 }

}
