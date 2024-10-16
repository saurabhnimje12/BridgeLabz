package BridegeLabz_Exception_Handling;

import java.util.Scanner;

class InsufficientFundsException extends RuntimeException {
	public InsufficientFundsException(String mesg) {
		super(mesg);
	}
}

public class ThrowingExceptions {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Your A/C Balance is 5000");
		System.out.println("Enter a amount to withdraw");
		int input = sc.nextInt();
		int balance = 5000;

		try {
			int remaningAmt = balance - input;
			if (remaningAmt >= 0) {
				System.out.println("Withdraw Successfully");
				System.out.println("Your balance is : " + remaningAmt);
			} else {
				throw new InsufficientFundsException("Insufficient Funds Exception");
			}
		} catch (InsufficientFundsException ife) {
			throw new InsufficientFundsException("Exception" + ife.getMessage());
		}
	}
}
