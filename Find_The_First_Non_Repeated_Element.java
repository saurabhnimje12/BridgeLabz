package BidgeLabz_DSA_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Find_The_First_Non_Repeated_Element {

	public static int search(ArrayList<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				if (arr.get(i) == arr.get(j)) {
					return j;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5, 2, 7, 8));
		int result = search(arr);
		if (result != -1) {
			System.out.println("First Non Repeated Element Found at INDEX location : " + result);
		} else {
			System.out.println("Element NOT Found");
		}
	}
}
