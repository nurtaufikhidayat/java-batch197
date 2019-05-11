package Hackerrank;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Kangoro {
	
	public static void main(String[] args) {
		String case1 = kangaroo(0, 3, 4, 2);
		System.out.println(case1);
		String case2 = kangaroo(0, 3, 4, 2);
		System.out.println(case2);
		
	}
	static String kangaroo(int x1, int v1, int x2, int v2) {

		String result = "";
		if (x1 < x2 && v1 < v2)
			result = "NO";
		else {
			if (v1 != v2 && (x2 - x1) % (v1 - v2) == 0)
				result = "YES";
			else
				result = "NO";

		}

		return result;
	}

}
