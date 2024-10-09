package BridgeLabs_Collection_List;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Intersection_Of_Two_LinkedLists {

	public static List<Integer> intersection(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (Integer integer : list2) {
			if (list1.contains(integer) && !list.contains(integer)) {
				list.add(integer);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		LinkedList<Integer> list2 = new LinkedList<Integer>(Arrays.asList(7, 3, 8, 9, 5, 3));
		List<Integer> intersection = intersection(list1, list2);
		System.out.println("Intersection : " + intersection);
	}
}
