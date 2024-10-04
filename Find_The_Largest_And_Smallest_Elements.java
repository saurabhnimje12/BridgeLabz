package BidgeLabz_DSA_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Find_The_Largest_And_Smallest_Elements {
	public static ArrayList<Integer> sort(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) > list.get(j) + 1) {
					int temp = list.get(j);
					list.set(j, list.get(i));
					list.set(i, temp);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(6, 2, 4, 12, 8, 10));
		sort(list);
		System.out.println("Largest Element : " + list.get(0));
		System.out.println("=================");
		System.out.println("Smallest Element : " + list.get(list.size() - 1));
	}
}
