package BidgeLabz_DSA_ArrayList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Duplicate_Elements {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(3);
		al.add(4);
		al.add(5);
		al.add(5);
		al.add(6);

		m2(al);
		m1(al);
	}

	public static void m2(ArrayList<Integer> al) {
		Set<Integer> set = new HashSet<Integer>();
		for (Integer i : al) {
			if (!set.contains(i)) {
				set.add(i);
			} else {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public static void m1(ArrayList<Integer> al) {
		Object[] array = al.toArray();
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					System.out.print(array[j] + " ");
				}
			}
		}
	}
}
