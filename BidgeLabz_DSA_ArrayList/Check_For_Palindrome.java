package BidgeLabz_DSA_ArrayList;

public class Check_For_Palindrome {

	public static boolean palindrom(String str) {
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
		String str = "abcba";
		boolean status = palindrom(str);
		if (status) {
			System.out.println("String is PALINDROM");
		} else {
			System.out.println("String is NOT PALINDROM");
		}
	}
}
