package BridgeLabz_Array_Programs;

import java.util.HashMap;

public class Frequency_Of_Elements {
	public static void countFrequency(int[] arr) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (hashMap.containsKey(i)) {
				hashMap.put(i, hashMap.get(i) + 1);
			} else
				hashMap.put(i, 1);
		}
		for (HashMap.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }	
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 3, 4, 4, 4, 5, 3, 2, 7 };
		countFrequency(arr);
	}
}
