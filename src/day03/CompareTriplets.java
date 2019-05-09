package day03;

import java.util.ArrayList;
import java.util.List;

public class CompareTriplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    	List<Integer> array = new ArrayList<>();
    	array.add(0,0);
    	array.add(1,0);
        for (int i = 0; i < a.size(); i++) {
			if(a.get(i) > b.get(i)) {
				int x = array.get(0);
				x++;
				
				array.set(0, x);
			}
			if(a.get(i) < b.get(i)) {
				int x = array.get(1);
				x++;
				
				array.set(1, x);
			}
		}
    	return array; 
    }


}
