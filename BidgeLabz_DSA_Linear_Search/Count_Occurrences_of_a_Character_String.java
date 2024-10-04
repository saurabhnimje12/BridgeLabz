package BidgeLabz_DSA_Linear_Search;

import java.util.HashMap;
import java.util.Set;

public class Count_Occurrences_of_a_Character_String {
	public static void frequency_Count(String str) {
		char[] charArray = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : charArray) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		Set<Character> keySet = map.keySet();

		for (Character ch : keySet) {
			System.out.println(ch + " : " + map.get(ch));
		}
	}

	public static void main(String[] args) {
		String str = "hellogoodmorning";
		frequency_Count(str);
	}

}
