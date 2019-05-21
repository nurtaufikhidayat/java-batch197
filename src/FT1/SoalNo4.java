package FT1;

import java.util.Scanner;

public class SoalNo4 {
	
	public static Scanner input;
	public static void main(String[] args) {
		System.out.println("Input Kalimat :");
		Scanner scanner = new Scanner(System.in);
		String kalimat = scanner.nextLine();
		//mendefinisikan objek 
		StringBuilder ubahKalimat = new StringBuilder();
		
		//pecah kalimat menjadi kata ketika ada spasi
		for (String word : kalimat.split(" ")) {
			//masukan kata ke method bintang
			ubahKalimat.append(bintang(word, '*'));
			
			ubahKalimat.append(" ");
		}
		System.out.println(ubahKalimat);
	}
	
	public static String bintang(String word, char replacer) {
		StringBuilder ubah = new StringBuilder();
		
		//cek kata lebih dari 2
		if(word.length()>2) {
			//memasukan huruf pertama ke dalam value
			ubah.append(word.charAt(0));
			//mengganti huruf setelah pertama menjadi *
            for (int i = 1; i < word.length() - 1; i++) {
                ubah.append(replacer);
            }
            
			//memasukan huruf terakhir
			ubah.append(word.charAt(word.length() - 1));
			return ubah.toString();
			
		}
		return word;
	}
}
