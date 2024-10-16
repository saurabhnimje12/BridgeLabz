package BridegeLabz_Exception_Handling;

import java.util.Scanner;

class NegativeNumberException extends RuntimeException {
	public NegativeNumberException(String str) {
		super(str);
	}
}

public class CustomUncheckedException {
	public static void check(int num) {
		if (num < 0) {
			throw new NegativeNumberException("No is Negative");
		} else {
			System.out.println("No is NOT Negative");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the No : ");
		check(scanner.nextInt());
	}

}
