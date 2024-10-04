package BidgeLabz_DSA_Linear_Search;

import java.util.HashMap;
import java.util.Set;

public class Find_All_Occurrences_in_List {
	public static void find_All_Occurrences() {
		String[] str = { "hello", "goodmorning", "good", "hello", "greet" };
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String string : str) {
			if (map.containsKey(string)) {
				map.put(string, map.get(string) + 1);
			} else {
				map.put(string, 1);
			}
		}
		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			System.out.println(string + " : " + map.get(string));
		}
	}

	public static void main(String[] args) {
		find_All_Occurrences();
	}
}
