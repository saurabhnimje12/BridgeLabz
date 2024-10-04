package BidgeLabz_DSA_Linear_Search;

public class Find_the_First_Occurrence_Number {
	public static int linearSearch() {
		int[] arr = { 10, 50, 30, 70, 80, 20, 90, 40 , 30};
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
