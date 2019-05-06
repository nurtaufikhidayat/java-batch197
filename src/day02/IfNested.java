package day02;

public class IfNested {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age = 25;
		int weight = 48;
		
		if (age >= 18) {
			if(weight > 50) {
				System.out.println("Your are eligible to donate blood");
			} else {
				System.out.println("Your are not eligible to donate blood");
			}
		}else {
			System.out.println("Age must be greater than 18");
		}

	}

}
