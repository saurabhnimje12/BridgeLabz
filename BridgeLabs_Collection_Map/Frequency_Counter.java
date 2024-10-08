package BridgeLabs_Collection_Map;

import java.util.HashMap;

public class Frequency_Counter {

	public static void charCount(String str) {
		char[] ch = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : ch) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		for (Character character : map.keySet()) {
			System.out.println(character + " : " + map.get(character));
		}
	}

	public static void main(String[] args) {
		String str = "hello world";
		charCount(str);
	}
}
