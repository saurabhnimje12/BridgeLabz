package BidgeLabz_DSA_ArrayList;

import java.util.ArrayList;

public class Find_The_Intersection_Of_Two_Lists {

	public static void commonElements(ArrayList<Integer> al1, ArrayList<Integer> al2) {
		Object[] array1 = al1.toArray();
		Object[] array2 = al2.toArray();

		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (array1[i] == array2[j]) {
					System.out.print(array1[i] + " ");
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(1);
		al1.add(2);
		al1.add(3);
		al1.add(4);
		al1.add(5);
		al1.add(6);

		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(7);
		al2.add(8);
		al2.add(3);
		al2.add(9);
		al2.add(10);
		al2.add(5);
		al2.add(11);
		al2.add(12);

		commonElements(al1, al2);
	}
}
