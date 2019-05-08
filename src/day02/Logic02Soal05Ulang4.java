package day02;

import java.util.Scanner;

public class Logic02Soal05Ulang4 {

	public static void main(String[] args) {
		System.out.println("Input kalimat :");
        Scanner scanner = new Scanner(System.in);
        String kalimat = scanner.nextLine();
        StringBuilder ubahKalimat = new StringBuilder();
 
        for (String word : kalimat.split(" ")) {
            ubahKalimat.append(replaceAll(word, '*'));
            ubahKalimat.append(" ");

	}
        System.out.println(ubahKalimat);
	}
	
	 public static String replaceAll(String word, char replacer) {
	        StringBuilder ret = new StringBuilder();
	        if (word.length()>2) {
	            ret.append(word.charAt(0));
	            for (int i = 1; i < word.length() - 1; i++) {
	                ret.append(replacer);
	            }
	            ret.append(word.charAt(word.length() - 1));
	            return ret.toString();
	        }
	 
	        return word;
	    }}
