package BridgeLabs_Collection_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Intersection_Of_Two_Arrays {

	public static List<Integer> insertion(int[] arr1, int[] arr2) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr1) {
			map.put(i, map.getOrDefault(i, 1) + 1);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Integer i : arr2) {
			if (map.containsKey(i) && map.get(i) > 1) {
				list.add(i);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 2, 4, 6, 3, 8 };

		List<Integer> insertion = insertion(arr1, arr2);
		System.out.println(insertion);
	}
}
