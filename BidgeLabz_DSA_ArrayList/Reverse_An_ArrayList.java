package BidgeLabz_DSA_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Reverse_An_ArrayList {

	public static ArrayList<Integer> reverse(ArrayList<Integer> list) {
		int left = 0;
		int right = list.size() - 1;
		while (left < right) {
			int next = list.get(left);
			list.set(left, list.get(right));
			list.set(right, next);
			left++;
			right--;
		}
		return list;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(6, 2, 4, 12, 8, 10));
		System.out.println("Before Reverse : " + list);
		reverse(list);
		System.out.println("=================");
		System.out.println("After Reverse : " + list);

	}
}
