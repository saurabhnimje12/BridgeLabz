package BidgeLabz_Logical_Programs;

import java.util.Scanner;

public class Perfect_Num {

	public static boolean isPerfect(int num) {
		int sum = 0;

		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				sum += i;
			}
		}
		return sum == num;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int input = scanner.nextInt();

		if (isPerfect(input)) {
			System.out.println(input + " is a perfect number");
		} else {
			System.out.println(input + " is not a perfect number");
		}
	}
}
