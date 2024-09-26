package BidgeLabz_Logical_Programs;

import java.util.Scanner;

public class Prime_Number {
	Scanner scanner = new Scanner(System.in);

	public boolean isPrime() {
		boolean flag = true;
		System.out.println("Enter Num  : ");
		int input = scanner.nextInt();

		for (int i = 2; i < input; i++) {
			if (input % i == 0) {
				flag = false;
			}
		}
		
		return flag;
	}

	public static void main(String[] args) {
		Prime_Number pn = new Prime_Number();
		boolean flag = pn.isPrime();

		if (flag == true) {
			System.out.println("Num is Prime");
		} else {
			System.out.println("Num is NOT Prime");
		}
	}

}
