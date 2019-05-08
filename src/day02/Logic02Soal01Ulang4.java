package day02;

import java.util.Scanner;

public class Logic02Soal01Ulang4 {

	protected static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
        System.out.println("input n1 : ");
        int n1 = Integer.parseInt(input.nextLine());
        System.out.println("input n2 : ");
        int n2 = Integer.parseInt(input.nextLine());
        System.out.println("");
        int angka = 1;
       
        table(n1,angka);
        test(n2,angka);

	}
	public static void table(int t1, int t2) {
		for (int counter = 0; counter < t1; counter++) {
			System.out.print(counter+"\t");
		}
		System.out.println("");
		for(int counter1 = 0; counter1 < t1; counter1++) {
			System.out.print(t2+"\t");
			t2=t2*3;
		}
	}
	public static void test(int a, int b) {
        int c = 0;
        System.out.println("");
        for(int counter = 0;counter<a;counter++) {
            if(counter<a-1) {
                c=c+b;
                System.out.print(b+" + ");
                b=b*3;
               
            }else {
            System.out.print(b+" = ");
            c=c+b;
            System.out.print(c);
            }
        }
    }
}
