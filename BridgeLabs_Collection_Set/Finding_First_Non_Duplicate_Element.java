package BridgeLabs_Collection_Set;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Finding_First_Non_Duplicate_Element {

	public static Integer firstNonDuplicateElement(int[] arr) {
		LinkedHashSet<Integer> newLinkedhashSet = new LinkedHashSet<Integer>();
		HashSet<Integer> hashSet = new LinkedHashSet<Integer>();

		for (Integer num : arr) {
			if (newLinkedhashSet.contains(num)) {
				hashSet.add(num);
				newLinkedhashSet.remove(num);
			} else {
				newLinkedhashSet.add(num);
			}
		}
		return newLinkedhashSet.iterator().next();
	}

	public static void main(String[] args) {

		int[] arr = { 4, 5, 6, 4, 7, 8, 5 };

		int element = firstNonDuplicateElement(arr);
		if (element != -1) {
			System.out.println("First Non-Duplicate Element : " + element);
		} else {
			System.out.println("No Non-Duplicate Element");
		}
	}
}
