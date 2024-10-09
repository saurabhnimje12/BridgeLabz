package BridgeLabs_Collection_Set;

import java.util.Arrays;
import java.util.TreeSet;

public class Remove_Elements_Based_On_Condition {

	public static TreeSet<Integer> specifiedThreshold(TreeSet<Integer> treeSet, int threshold) {
		TreeSet<Integer> newTreeSet = new TreeSet<Integer>(treeSet);
		for (Integer num : treeSet) {
			if (num < threshold) {
				newTreeSet.remove(num);
			}
		}
		return newTreeSet;
	}

	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		int threshold = 3;
		TreeSet<Integer> specifiedThreshold = specifiedThreshold(treeSet, threshold);
		System.out.println(specifiedThreshold);
	}
}
