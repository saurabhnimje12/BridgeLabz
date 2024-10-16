package BridegeLabz_Exception_Handling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatchBlocks {
	public static void check() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter a No 1 :");
			int input1 = scanner.nextInt();
			System.out.println("Enter a No 2 :");
			int input2 = scanner.nextInt();
			int result = 100 / input2;
		} catch (ArithmeticException ae) {
			System.out.println("Enter a Valid No not Zero");
		} catch (InputMismatchException ie) {
			System.out.println("Enter a Valid No not Character");
		}
	}

	public static void main(String[] args) {
		check();
	}
}
