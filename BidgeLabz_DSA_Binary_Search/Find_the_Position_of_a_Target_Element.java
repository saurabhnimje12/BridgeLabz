package BidgeLabz_DSA_Binary_Search;

public class Find_the_Position_of_a_Target_Element {
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 7, 9 };
		int target = 5;
	
		int bSearch = binarySearch(arr, target);
		if (bSearch != -1) {
			System.out.println("Element found at INDEX position : " + bSearch);
		} else {
			System.out.println("Element NOT Found");
		}
	}
}
