package BridgeLabz_Array_Programs;

public class Count_Even_And_Odd_Numbers {
	public static void even_And_Odd() {
		int[] num = { 1, 2, 3, 45, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99 };
		int evenCount = 0;
		int oddCount = 0;
		for (int i : num) {
			if (i % 2 == 0) {
				evenCount++;
			} else {
				oddCount++;
			}
		}
		System.out.println("Even Count : " + evenCount);
		System.out.println("Odd Count : " + oddCount);
	}

	public static void main(String[] args) {
		even_And_Odd();
	}
}
