package Hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {

	static final Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");

	}

	static boolean isAnagram(String a, String b) {
		// tes for invalid inputt
		if (a == null || b == null || a.equals("") || b.equals("")) {
			throw new IllegalArgumentException();
		}
		// initial quick tes
		if (a.length() != b.length()) {
			return false;
		}
		// complete the function
		a = a.toLowerCase();
		b = b.toLowerCase();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < b.length(); i++) {
			Character c = b.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				int f = map.get(c);
				map.put(c, ++f);
			}

		}

		for (int j = 0; j < a.length(); j++) {
			Character c = b.charAt(j);
			if (!map.containsKey(c)) {
				return false;
			}

			int f = map.get(c);
			if (f == 0) {
				return false;
			} else {
				map.put(c, --f);
			}

		}
		return true;
	}
}
