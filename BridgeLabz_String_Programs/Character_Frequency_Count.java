package BridgeLabz_String_Programs;

import java.util.HashMap;
import java.util.Set;

public class Character_Frequency_Count {
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
