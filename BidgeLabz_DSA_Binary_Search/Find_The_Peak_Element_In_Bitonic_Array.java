package BidgeLabz_DSA_Binary_Search;

public class Find_The_Peak_Element_In_Bitonic_Array {

	public static int bitonicArray(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
	//	int result = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			// Check if mid is the peak element
			if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
				return mid;
			}

			// If the slope is increasing, move to the right half
			if (mid < arr.length - 1 && arr[mid] < arr[mid + 1]) {
				left = mid + 1;
			}
			// Otherwise, move to the left half
			else {
				right = mid - 1;
			}
		}

//			if (arr[mid] == target) {
//				return mid;
//			}
//
//			if (arr[left] <= arr[mid]) {
//				if (target >= arr[left] && target < arr[mid]) {
//					right = mid - 1;
//				} else {
//					left = mid + 1;
//				}
//			} else {
//				if (target > arr[mid] && target <= arr[right]) {
//					left = mid + 1;
//				} else {
//					right = mid - 1;
//				}
//			}
	
		return -1;

	}

	public static void main(String[] args) {

//		int[] arr = { 5, 6, 7, 8, 9, 10, 3, 2, 1 };
//		int target = 5;
//
//		int bArray = bitonicArray(arr, target);
//		if (bArray != -1) {
//			System.out.println("Target is Found at INDEX position location : " + bArray);
//		} else {
//			System.out.println("Target is NOT Found");
//		}

		 int[] arr = {1, 3, 8, 12, 4, 2};
	        int peakIndex = bitonicArray(arr);
	        System.out.println("Index of the peak element: " + peakIndex);
		
	}
}
