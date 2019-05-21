package day02;
import java.util.Scanner;

public class Soal05 {
	public static Scanner input;
	public static void main(String[] args) {
		System.out.println("Input kalimat :");
        Scanner scanner = new Scanner(System.in);
        String kalimat = scanner.nextLine();
        StringBuilder ubahKalimat = new StringBuilder();
 
        for (String word : kalimat.split(" ")) {
        	//pecah kalimat menjadi kata
            ubahKalimat.append(replaceAll(word, '*'));
            //masukan kata ke method replaceAll
            ubahKalimat.append(" ");

	}
        System.out.println(ubahKalimat);
	}
	
	 public static String replaceAll(String word, char replacer) {
	        StringBuilder ret = new StringBuilder();
	        //objeck string bisa dimodifikasi
	        
	        if (word.length()>2) {
	        	//huruf hanya bisa diganti dengan panjang lebih dari 2
	            ret.append(word.charAt(0));
	            //ganti isi 
	            for (int i = 1; i < word.length() - 1; i++) {
	                ret.append(replacer);
	            }
	            
//	            for (int i = 0; i < 3 ; i++) {
//					ret.append(replacer);
//				}
	            
	            ret.append(word.charAt(word.length() - 1));
	            return ret.toString();
	            //huruf terakhir kata akan tetap
	        }
	 
	        return word;
	    }

}
