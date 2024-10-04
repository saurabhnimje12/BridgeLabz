package BidgeLabz_DSA_Binary_Search;

public class Find_the_First_and_Last_Occurrence_of_a_Target_Element {
	
	public static int firstOccurrence(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		int result = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				result = mid;
				right = mid - 1;
			}
			if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return result;
	}

	public static int lastOccurrence(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		int result = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				result = mid;
				left = mid + 1;
			}
			if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 2, 3, 3, 3, 4, 5, 5, 6, 7, 8 };
		int target = 2;
		
		int result1 = firstOccurrence(arr, target);
		if (result1 != -1) {
			System.out.println("First occurrence of element found at index: " + result1);
		} else {
			System.out.println("Element not found in the array.");
		}

		int result2 = lastOccurrence(arr, target);
		if (result2 != -1) {
			System.out.println("First occurrence of element found at index: " + result2);
		} else {
			System.out.println("Element not found in the array.");
		}
	}
}
