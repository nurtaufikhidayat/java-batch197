import java.util.Scanner;

public class soal8 {
	protected static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		System.out.println("Input your number = ");
		
		int n = Integer.parseInt(input.nextLine());
		
		int number = 3;
		
		for(int i = 0; i<n; i++) {
			System.out.print(number +"\t");
			
			number = number * 3;
		}

	}

}
