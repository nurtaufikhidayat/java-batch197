package day07;

public class Yamaha01 extends Bike01 {

	void run() {
		System.out.println("methode run called");
	}
	public static void main(String[] args) {
		Bike01 b = new Honda01();
		b.run();

	}

}
