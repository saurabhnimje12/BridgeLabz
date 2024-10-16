package BridegeLabz_Exception_Handling;

import java.util.Scanner;

public class FinallyBlock {
	public static void check(int num) {
		try {
			int result = 100 / num;
			System.out.println("Result :" + result);
		} catch (ArithmeticException ae) {
			System.out.println("Enter a Valid No not Zero");
		} finally {
			System.out.println("100 / by : " + num);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a No :");
		check(scanner.nextInt());
	}
}
