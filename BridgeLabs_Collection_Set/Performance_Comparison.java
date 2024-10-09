package BridgeLabs_Collection_Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Performance_Comparison {
	public static void hashSet() {
		HashSet<Integer> newHashSet = new HashSet<Integer>();
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			newHashSet.add(i + 10);
		}
		long stopTime1 = System.currentTimeMillis();
		long result1 = stopTime1 - startTime1;
		System.out.println("HashSet take time to ADD 1,000,000 elements : " + result1 / 1000.0 + "sec");

		long startTime2 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			newHashSet.add(i + 10);
		}
		long stopTime2 = System.currentTimeMillis();
		long result2 = stopTime2 - startTime2;
		System.out.println("HashSet take time to GET 1,000,000 elements : " + result2 / 1000.0 + "sec");
	}

	public static void linkedHashSet() {
		LinkedHashSet<Integer> newlinkedHashSet = new LinkedHashSet<Integer>();
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			newlinkedHashSet.add(i + 10);
		}
		long stopTime1 = System.currentTimeMillis();
		long result1 = stopTime1 - startTime1;
		System.out.println("LinkedHashSet take time to ADD 1,000,000 elements : " + result1 / 1000.0 + "sec");

		long startTime2 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			newlinkedHashSet.add(i + 10);
		}
		long stopTime2 = System.currentTimeMillis();
		long result2 = stopTime2 - startTime2;
		System.out.println("LinkedHashSet take time to GET 1,000,000 elements : " + result2 / 1000.0 + "sec");
	}

	public static void treeSet() {
		TreeSet<Integer> newTreeSet = new TreeSet<Integer>();
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			newTreeSet.add(i + 10);
		}
		long stopTime1 = System.currentTimeMillis();
		long result1 = stopTime1 - startTime1;
		System.out.println("TreeSet take time to ADD 1,000,000 elements : " + result1 / 1000.0 + "sec");

		long startTime2 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			newTreeSet.add(i + 10);
		}
		long stopTime2 = System.currentTimeMillis();
		long result2 = stopTime2 - startTime2;
		System.out.println("TreeSet take time to GET 1,000,000 elements : " + result2 / 1000.0 + "sec");
	}

	public static void main(String[] args) {
		hashSet();
		linkedHashSet();
		treeSet();
	}
}
