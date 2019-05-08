package day02;

import java.util.Scanner;

public class TimeConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String time = in.next();
		String listTime[] = time.split(":");
		String hour = listTime[0];
		String m = listTime[1];
		String secounds = listTime[2].substring(0,2);
		String caser = listTime[2].substring(2,4);
		
		if (caser.equals("AM")) {
			if(hour.equals("12"))
				hour="00";
			System.out.print(hour + ":"+m+":"+secounds);
		}else {
			if (!hour.equals("12")) {
				int h = Integer.parseInt(hour);
				h = h + 12;
				hour = ""+ h;
				
			}
			System.out.print(hour+":"+m+":"+secounds);
		}
	}

}
