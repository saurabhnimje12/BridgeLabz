package BridgeLabs_Collection_List;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Remove_Nth_Node_From_End {
	public static List<Integer> removeFromLast(LinkedList<Integer> list) {
		list.remove(list.size() - 1);
		return list;
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		List<Integer> removeFromLast = removeFromLast(list);
		System.out.println(removeFromLast);
	}
}
