package FT1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SoalNo1 {
public static void main(String[] args) {
	System.out.println(getMoneySpent(new int[] {34, 26, 44}, new int[] {21,39,33}, 30));
//	System.out.println(getMoneySpent(new int[] {34, 35, 35}, new int[] {35,35,35}, 47));
}	
	static int getMoneySpent(int[] baju, int[] kacamata, int b) {
		int hasil = 0;
		//membuat list bertipe integer
		List<Integer>dd = new ArrayList<Integer>();
		//perulangan
		for (int i = 0; i < baju.length; i++) {
			for (int j = 0; j < kacamata.length; j++) {
				if (baju[i]+ kacamata[j]<=b) {
					dd.add(baju[i] + kacamata[j]);	
				}
				
			}
			
		}
		if(dd.size()== 0) {
			System.out.println("Dana tidak mencukupi");
		} else {
			//mencari value tertinggi
			hasil = Collections.max(dd);
		}
		return hasil;
	}

}
