package BridgeLabs_Collection_Map;

import java.util.HashMap;

public class Duplicate_Elements_In_Array {

	public static void duplicate(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		for (int i : map.keySet()) {
			if (map.get(i) > 1) {
				System.out.println(i + " : " + map.get(i));
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 3, 2, 6, 7, 8, 2, 4, 6, 9 };
		duplicate(arr);
	}
}
