package BridgeLabs_Collection_Set;

import java.util.LinkedHashSet;

public class Maintaining_Insertion_Order {

	public static LinkedHashSet<String> sortList(String[] str) {
		LinkedHashSet<String> newLinkedhashSet = new LinkedHashSet<String>();
		for (String s : str) {
			newLinkedhashSet.add(s);
		}
		return newLinkedhashSet;
	}

	public static void main(String[] args) {

		String[] str = { "apple", "banana", "apple", "orange" };
		LinkedHashSet<String> list = sortList(str);
		System.out.println(list);
	}
}
