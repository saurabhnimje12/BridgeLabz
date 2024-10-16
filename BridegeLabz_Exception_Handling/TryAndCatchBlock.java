package BridegeLabz_Exception_Handling;

import java.util.Scanner;

public class TryAndCatchBlock {
	public static void check(int num) {
		try {
			int result = 100 / num;
			System.out.println("100/" + num + " : " + result);
		} catch (ArithmeticException ae) {
			System.out.println("Enter a Valid No not Zero");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a No divide by 100");
		check(scanner.nextInt());
	}
}
