package BidgeLabz_Operators_Programs;

import java.util.Scanner;

public class Logical_Operators {
	Scanner scanner = new Scanner(System.in);

	public void leap_Year_Check() {
		System.out.println("Enter a year : ");
		int input = scanner.nextInt();

		if (input % 4 == 0 || input % 400 == 0) {
			System.out.println(input + " is a LEAP year");
		} else {
			System.out.println(input + " is NOT a LEAP year");
		}
	}

	public void divisibility_Check() {
		System.out.println("Enter a year : ");
		int input = scanner.nextInt();

		if (input % 5 == 0 && input % 7 == 0) {
			System.out.println(input + " is Divisibility 5 & 7");
		} else {
			System.out.println(input + " is NOT Divisibility 5 & 7");
		}
	}

	public static void main(String[] args) {
		Logical_Operators lo = new Logical_Operators();
		lo.leap_Year_Check();
		lo.divisibility_Check();
	}
}
