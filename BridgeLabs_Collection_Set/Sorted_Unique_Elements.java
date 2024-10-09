package BridgeLabs_Collection_Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Sorted_Unique_Elements {

	public static TreeSet<Integer> ascending_Order(ArrayList<Integer> list) {
//		TreeSet<Integer> treeSet = new TreeSet<Integer>();
//		for (Integer num : list) {
//			treeSet.add(num);
//		}
//		return treeSet;		
		return new TreeSet<Integer>(list);
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(7, 2, 9, 1, 2, 9));
		TreeSet<Integer> ascending_Order = ascending_Order(list);
		System.out.println(ascending_Order);
	}
}
