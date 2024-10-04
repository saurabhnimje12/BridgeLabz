package BridgeLabz_Array_Programs;

import java.util.Arrays;

public class Array_Reversal {
	public static void Reverse() {
		int[] arr = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		for (int element : arr) {
			System.out.print(element + " ");
		}
	}

	public static void Rev() {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arr2[arr1.length - 1 - i] = arr1[i];
		}
		System.out.println("Array : " + Arrays.toString(arr1));
		System.out.println("Array Reverse : " + Arrays.toString(arr2));
	}

	public static void main(String[] args) {
		Reverse();
		Rev();
	}

}
