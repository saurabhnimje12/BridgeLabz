package BidgeLabz_DSA_Binary_Search;

public class Find_the_Smallest_and_Largest_Greater_than_the_Target {

//	Given a sorted array, write a method to find the smallest element that is greater than or equal to a target value. 
//	Return its index.
	public static int smallestElement(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		int result = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] >= target) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}

//	Implement a binary search algorithm to find the largest element that is smaller than or equal to a target value in a sorted array. 
//	Return its index.
	public static int largestElement(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		int result = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] > target) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 6, 7, 8 };
		int target = 3;

		int result1 = smallestElement(arr, target);
		if (result1 != -1) {
			System.out.println("The smallest element greater than or equal to the target is at index: " + result1);
		} else {
			System.out.println("No element greater than or equal to the target was found.");
		}

		int result2 = largestElement(arr, target);
		if (result2 != -1) {
			System.out.println("Largest Element greater than target at INDEX position : " + result2);
		} else {
			System.out.println("NO element greater than target was found.");
		}

	}
}
