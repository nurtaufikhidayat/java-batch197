package Hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BirthdayChoclate2 {
	
	static int birthday(List<Integer> s, int d, int m) {
		int result = 0;
		for (int i = 0; i < s.size(); i++) {
			int c = 0;
			for (int j = 0; j < m; j++) {
				if(i + j<s.size()) {
					c += s.get(i+j);  
				}
				
			}
			if(c == d) {
				result++;
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(birthday(new ArrayList<Integer>(Arrays.asList(1,2,1,3,2)),3,2));
		System.out.println(birthday(new ArrayList<Integer>(Arrays.asList(4,1,4,4)),4,1));
	}

}
