package BidgeLabz_DSA_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Find_The_Union_Of_Two_Lists {
	public static void unionList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		HashSet<Integer> set = new HashSet<Integer>(list1);
		set.addAll(list2);
		ArrayList<Integer> unionList = new ArrayList<Integer>(set);
		System.out.println("Union-List : " + unionList);
	}

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(20, 4, 15, 10));
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(10, 2, 4, 8));
		unionList(list1, list2);
	}
}
