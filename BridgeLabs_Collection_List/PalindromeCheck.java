package BridgeLabs_Collection_List;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PalindromeCheck {
	public static List<String> palindrome(LinkedList<String> list) {
		LinkedList<String> linkList = new LinkedList<String>();
		for (String string : list) {
			if (isCheck(string)) {
				linkList.add(string);
			}
		}
		return linkList;
	}

	public static boolean isCheck(String string) {
		int left = 0;
		int right = string.length() - 1;
		while (left < right) {
			if (string.charAt(left) != string.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>(Arrays.asList("civic", "radar", "hello", "level"));
		List<String> palindrome = palindrome(list);
		if (!palindrome.isEmpty()) {
			System.out.println("Palindrome : " + palindrome);
		} else {
			System.out.println("No String is Palindrome");
		}
	}
}
