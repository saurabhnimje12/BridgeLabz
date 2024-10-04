package BidgeLabz_DSA_Binary_Search;

public class RotatedSortedArray {

	public static int rotatedArray(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		int result = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			if (arr[left] <= arr[mid]) {
				if (target >= arr[left] && target < arr[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (target > arr[mid] && target <= arr[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int target = 10;

		int rArray = rotatedArray(arr, target);
		if (rArray != -1) {
			System.out.println("Target is Found at INDEX position location : " + rArray);
		} else {
			System.out.println("Target is NOT Found");
		}
	}

}
