package FT1;

import java.util.Scanner;

public class SoalNo10 {
	public static void main(String[] args) {
		
		System.out.println("Masukan Kalimat: ");
		Scanner in = new Scanner(System.in);
		System.out.println(getOutput(in.nextLine()));
		in.close();
	}
	//method untuk menampilkan hasil pengecekan
	protected static String getOutput(String sentence) {
		return (isPanagram(sentence)) ?"It's a Pangram" : "It's NOT Pangram";
	}
	//method untuk mengecek apakah kalimat termasuk panagram
	protected static boolean isPanagram(String sentence) {
		//mengubah huruf besar menjadi huruf kecil
		String lowerSentence = sentence.toLowerCase();
		//looping dari a - z, lalu menyimpannya kedalam index letter
		for (char letter = 'a'; letter < 'z'; letter++) {
			//jika tidak ada kata a - z yang diinput, maka hasilnya false
			if(lowerSentence.indexOf(letter)<0) return false;
		}
		//jika huruf a - z ada, maka hasinya true
		return true;
	}
}
