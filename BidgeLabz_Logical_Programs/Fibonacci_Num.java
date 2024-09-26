package BidgeLabz_Logical_Programs;

import java.util.Scanner;

public class Fibonacci_Num {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the no in terms of Fibonacci series : ");
		int input = scanner.nextInt();

		int first = 0, second = 1;

		for (int i = 1; i <= input; i++) {
			System.out.print(first + " ");

			int next = first + second;
			first = second;
			second = next;
		}
	}
}
