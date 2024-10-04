package BridgeLabz_Array_Programs;

public class Duplicate_Elements {

	public static void duplicateELement() {
		int[] arr = { 1, 2, 2, 3, 4, 4, 4, 5, 3, 2 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					System.out.print(arr[i]);
				}
			}
		}
	}

	public static void main(String[] args) {
		duplicateELement();
	}
}
