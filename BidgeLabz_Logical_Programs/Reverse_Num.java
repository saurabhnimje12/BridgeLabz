package BidgeLabz_Logical_Programs;

import java.util.Scanner;

public class Reverse_Num {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a number : ");
		int input = scanner.nextInt();

		int reverse = 0;

		for (int i = input; i != 0; i = i / 10) {
			// Get the last digit (remainder)
			int remainder = i % 10;

			// Build the reverse number
			reverse = reverse * 10 + remainder;
		}
		System.out.println("Reversed number: " + reverse);
	}
}
