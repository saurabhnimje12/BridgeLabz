package BridgeLabz_String_Programs;

import java.util.Arrays;

public class String_Anagram {
	public static boolean string_Anagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		return Arrays.equals(charArray1, charArray2);

	}

	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = "elloh";
		if (string_Anagram(str1, str2)) {
			System.out.println("String is Anagram ");
		} else {
			System.out.println("String is NOT Anagram ");
		}
	}
}
