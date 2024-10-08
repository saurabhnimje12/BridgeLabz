package BridgeLabs_Collection_Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram_Grouping {

	public static List<List<String>> anagrams(String[] strArray) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strArray) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String sortedWord = new String(charArray);
			if (!map.containsKey(sortedWord)) {
				map.put(sortedWord, new ArrayList<>());
			}
			map.get(sortedWord).add(str);
		}
		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		String[] strArray = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> groupedAnagrams = anagrams(strArray);
		for (List<String> group : groupedAnagrams) {
			System.out.println(group);
		}
	}
}
