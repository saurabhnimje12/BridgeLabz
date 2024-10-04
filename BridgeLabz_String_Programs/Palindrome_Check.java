package BridgeLabz_String_Programs;

import java.util.Scanner;

public class Palindrome_Check {

	public static boolean palindrome(String str) {

		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a String");
		String str = scanner.nextLine();

		if (palindrome(str) != false) {
			System.out.println("String is Palindrome : " + str);
		} else {
			System.out.println("String is NOT Palindrome : " + str);
		}
	}
}
