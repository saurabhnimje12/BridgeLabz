package BridgeLabz_Array_Programs;

import java.util.Arrays;

public class Find_Maximum_And_Minimum {

	public static void Maximum() {
		double[] arr = { 432.46, 32.54, 23.435, 756.76, 78.45 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					double next = arr[j];
					arr[j] = arr[i];
					arr[i] = next;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(arr[arr.length - 1]);
	}

	public static void Minimum() {
		double[] arr = { 432.46, 32.54, 23.435, 756.76, 78.45 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					double next = arr[j];
					arr[j] = arr[i];
					arr[i] = next;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(arr[0]);
	}

	public static void main(String[] args) {
		Maximum();
		Minimum();
	}
}
