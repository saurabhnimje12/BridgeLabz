package BridgeLabs_Collection_List;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Merge_Sorted_Lists {

	public static List<Integer> mergeAndSort(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		Collections.sort(list1);
		Collections.sort(list2);
		LinkedList<Integer> list = new LinkedList<Integer>(list1);
		for (Integer integer : list2) {
			if (!list1.contains(integer)) {
				list.add(integer);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>(Arrays.asList(1, 4, 2, 5, 3));
		LinkedList<Integer> list2 = new LinkedList<Integer>(Arrays.asList(7, 3, 8, 9, 5, 3));
		List<Integer> mergeAndSort = mergeAndSort(list1, list2);
		System.out.println(mergeAndSort);
	}

}
