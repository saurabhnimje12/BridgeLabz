package BidgeLabz_DSA_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort_An_ArrayList {
	public static ArrayList<Integer> ascending(ArrayList<Integer> list) {
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

	public static ArrayList<Integer> descending(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) < list.get(j) + 1) {
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
		ascending(list);
		System.out.println("Ascending Sort : " + list);
		System.out.println("=================");
		descending(list);
		System.out.println("Descending Sort : " + list);

	}
}
