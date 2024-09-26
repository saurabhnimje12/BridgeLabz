package BidgeLabz_Operators_Programs;

import java.util.Scanner;

public class Arithmetic_Operators {
	Scanner scanner = new Scanner(System.in);

	public void addition_And_Subtraction() {
		System.out.println("Enter num : 1");
		int input1 = scanner.nextInt();
		System.out.println("Enter num : 2");
		int input2 = scanner.nextInt();

		System.out.println("Addition : " + (input1 + input2));
		if (input2 > input1) {
			System.out.println("Difference : " + (input2 - input1));
		} else {
			System.out.println("Difference : " + (input1 - input2));
		}
	}

	public void multiplication_Table() {
		System.out.println("Enter num : ");
		int input = scanner.nextInt();

		for (int i = 1; i <= 10; i++) {
			System.out.println(input + " * " + i + " : " + (input * i));
		}
	}

	public void average_Calculation() {
		int add = 0;
		for (int i = 1; i <= 5; i++) {
			System.out.println("Enter num : " + i);
			int input = scanner.nextInt();
			add += input;
		}
		int average = add / 5;
		System.out.println("Average : " + average);
	}

	public void circle_Measurements() {
		System.out.println("Enter radius : ");
		double radius = scanner.nextInt();

		double area = Math.PI * radius * radius;
		System.out.println("Area of circle : " + area);

		double circumference = 2 * Math.PI * radius;
		System.out.println("Circumference of circle : " + circumference);
	}

	public static void main(String[] args) {
		Arithmetic_Operators ar = new Arithmetic_Operators();
		ar.addition_And_Subtraction();
		ar.multiplication_Table();
		ar.average_Calculation();
		ar.circle_Measurements();
	}

}
