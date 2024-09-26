package BidgeLabz_Operators_Programs;

import java.util.Scanner;

public class Ternary_Operator {
	Scanner scanner = new Scanner(System.in);

	public void min_of_Two_Numbers() {
		System.out.println("Enter a No : ");
		int input = scanner.nextInt();

		String str = (input % 2 == 0) ? "EVEN" : "ODD";
		System.out.println(input + " is " + str);
	}

	public void passOrFail() {
		int marks = 67;
		String str = (marks >= 60) ? "Passed" : "Failed";

		System.out.println("The student has " + str + ".");
	}

	public static void main(String[] args) {
		Ternary_Operator to = new Ternary_Operator();
		to.min_of_Two_Numbers();
		to.passOrFail();
	}
}
