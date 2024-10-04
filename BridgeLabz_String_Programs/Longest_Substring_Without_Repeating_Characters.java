package BridgeLabz_String_Programs;

import java.util.HashMap;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		String str = "mvnvbxbcaiebahsdmefb";
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
			if (map.get(ch) > 1) {
				System.out.print(ch);
			}
		}
	}
}
