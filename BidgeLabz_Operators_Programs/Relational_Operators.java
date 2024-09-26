package BidgeLabz_Operators_Programs;

import java.util.Scanner;

public class Relational_Operators {
	Scanner scanner = new Scanner(System.in);

	public void max_of_Three_Numbers() {
		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter a no : " + (i + 1));
			int input = scanner.nextInt();
			arr[i] += input;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int k = arr[j];
					arr[j] = arr[i];
					arr[i] = k;
				}
			}
		}
		System.out.println("Max no : " + (arr[arr.length - 1]));
	}

	public int equality_Check() {
		System.out.println("Enter a String : 1");
		String str1 = scanner.nextLine();
		System.out.println("Enter a String : 2");
		String str2 = scanner.nextLine();

		if (str1.length() != str2.length()) {
			return -1;
		}
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Relational_Operators ro = new Relational_Operators();

		ro.max_of_Three_Numbers();

		int output = ro.equality_Check();
		if (output == 0) {
			System.out.println("String is same");
		} else if (output == -1) {
			System.out.println("Length of String is NOT same");
		} else {
			System.out.println("String is NOT same at " + output);
		}
	}
}
