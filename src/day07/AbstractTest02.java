package day07;

public class AbstractTest02 {
	//main methode
	public static void main(String[] args) {
		//initial object
		Bank01 b1;
		//instance object
		b1 = new SBI01();
		System.out.println("Rate Of Interest Is : " + b1.getRateOfInterest());
		b1 = new PNB01();
		System.out.println("Rate Of Interest Is : " + b1.getRateOfInterest() );

	}

}
