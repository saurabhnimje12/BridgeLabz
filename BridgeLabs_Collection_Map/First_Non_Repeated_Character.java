package BridgeLabs_Collection_Map;

import java.util.LinkedHashMap;

public class First_Non_Repeated_Character {
	public static char nonRepeatedCharacter(String str) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (char ch : str.toCharArray()) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		for (Character character : map.keySet()) {
			if (map.get(character) == 1) {
				return character;
			}
		}
		return '\0'; // Null character (can also use another approach to signal no character found)
	}

	public static void main(String[] args) {
		String str = "abcdafcb";
		char nonRepeatedCharacter = nonRepeatedCharacter(str);
		System.out.println(nonRepeatedCharacter);
	}
}
