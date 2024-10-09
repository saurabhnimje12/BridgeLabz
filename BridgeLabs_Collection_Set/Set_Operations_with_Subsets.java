package BridgeLabs_Collection_Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Set_Operations_with_Subsets {

	public static boolean hashSet() {
		HashSet<Integer> newHashSet1 = new HashSet<Integer>(Arrays.asList(1, 2, 3));
		HashSet<Integer> newHashSet2 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4));

		if (newHashSet1.size() >= newHashSet2.size()) {
			return newHashSet1.containsAll(newHashSet2);
		} else if (newHashSet1.size() < newHashSet2.size()) {
			return newHashSet2.containsAll(newHashSet1);
		}
		return false;
	}

	public static boolean linkedHashSet() {
		LinkedHashSet<Integer> newLinkedHashSet1 = new LinkedHashSet<Integer>(Arrays.asList(1, 2, 3));
		LinkedHashSet<Integer> newLinkedHashSet2 = new LinkedHashSet<Integer>(Arrays.asList(1, 2, 3, 4));

		if (newLinkedHashSet1.size() >= newLinkedHashSet2.size()) {
			return newLinkedHashSet1.containsAll(newLinkedHashSet2);
		} else if (newLinkedHashSet1.size() < newLinkedHashSet2.size()) {
			return newLinkedHashSet2.containsAll(newLinkedHashSet1);
		}
		return false;
	}

	public static boolean treeSet() {
		TreeSet<Integer> treeSet1 = new TreeSet<Integer>(Arrays.asList(1, 2, 3));
		TreeSet<Integer> treeSet2 = new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4));

		if (treeSet1.size() >= treeSet2.size()) {
			return treeSet1.containsAll(treeSet2);
		} else if (treeSet1.size() < treeSet2.size()) {
			return treeSet2.containsAll(treeSet1);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("HashSet : " + hashSet());
		System.out.println("LinkedHashSet : " + linkedHashSet());
		System.out.println("TreeSet : " + treeSet());
	}
}
