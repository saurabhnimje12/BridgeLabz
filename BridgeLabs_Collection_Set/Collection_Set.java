package BridgeLabs_Collection_Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Collection_Set {

	
	public static HashSet<Integer> sortSet1(int[] arr) {
		HashSet<Integer> newHashSet = new HashSet<Integer>();
		for (Integer num : arr) {
			newHashSet.add(num);
		}
		return newHashSet;
	}

	public static LinkedHashSet<Integer> sortSet2(int[] arr) {
		LinkedHashSet<Integer> newLinkedHashSet = new LinkedHashSet<Integer>();
		for (Integer num : arr) {
			newLinkedHashSet.add(num);
		}
		return newLinkedHashSet;
	}

	public static TreeSet<Integer> sortSet3(int[] arr) {
		TreeSet<Integer> newTreeSet = new TreeSet<Integer>();
		for (Integer num : arr) {
			newTreeSet.add(num);
		}
		return newTreeSet;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 5, 1, 2 };

		HashSet<Integer> hashSet = sortSet1(arr);
		System.out.println(hashSet);

		LinkedHashSet<Integer> linkedHashSet = sortSet2(arr);
		System.out.println(linkedHashSet);

		TreeSet<Integer> treeSet = sortSet3(arr);
		System.out.println(treeSet);
	}
}
