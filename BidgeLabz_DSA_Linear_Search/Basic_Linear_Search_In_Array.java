package BidgeLabz_DSA_Linear_Search;

public class Basic_Linear_Search_In_Array {

	public static int linearSearch() {
		int[] arr = { 10, 50, 30, 70, 80, 20, 90, 40 };
		int key = 30;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int linearSearch = linearSearch();
		if (linearSearch == -1){ 
			System.out.println("Element is NOT present");
		}else {
			System.out.println("Element is present at INDEX position : "+linearSearch);
		}
	}
}
