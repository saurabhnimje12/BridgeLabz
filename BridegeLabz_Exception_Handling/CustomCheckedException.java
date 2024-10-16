package BridegeLabz_Exception_Handling;

import java.util.Scanner;

class InvalidAgeException extends RuntimeException {
	public InvalidAgeException(String str) {
		super(str);
	}
}

public class CustomCheckedException {

	public static void check(int num) {
		if (num < 18) {
			throw new InvalidAgeException("Age is less than 18");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Age : ");
		check(scanner.nextInt());
	}
}
