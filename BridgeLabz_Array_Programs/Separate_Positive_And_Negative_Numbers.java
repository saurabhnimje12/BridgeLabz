package BridgeLabz_Array_Programs;

import java.util.ArrayList;

public class Separate_Positive_And_Negative_Numbers {

	public static void separate_Positive_And_Negative() {
		int[] num = { 1, 2, -3, -45, 6, 0, 7, 8, 9, -11, 22, -33, 44, 0, 55, 66, -77, 88, 99 };
		ArrayList<Integer> positive = new ArrayList<Integer>();
		ArrayList<Integer> negative = new ArrayList<Integer>();
		int zero = 0;
		for (int i : num) {
			if (i < 0) {
				positive.add(i);
			} else if (i > 0) {
				negative.add(i);
			} else {
				zero++;
			}
		}
		System.out.println("Positive Number : " + positive);
		System.out.println("Negative Number : " + negative);
		System.out.println("Zero Count : " + zero);
	}

	public static void main(String[] args) {
		separate_Positive_And_Negative();
	}
}
