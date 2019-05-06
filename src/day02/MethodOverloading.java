	package day02;

public class MethodOverloading {

	public static void main(String[] args) {
		System.out.println(add(11,11));
		System.out.println(add(11.5,11.5,11.5));

	}
	static int add(int a, int b) {
		return a + b;
	}
	static double add( double a, double b, double c) {
		return a + b + c;
	}

}
