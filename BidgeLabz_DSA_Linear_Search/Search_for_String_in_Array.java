package BidgeLabz_DSA_Linear_Search;

public class Search_for_String_in_Array {

	public static int linearSearchForString() {
		String str = "mnbvcxzfghjkl";
		char key = 'c';
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == 'c') {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int linearSearch = linearSearchForString();
		if (linearSearch == -1) {
			System.out.println("Element is NOT present");
		} else {
			System.out.println("Element is present at INDEX position : " + linearSearch);
		}
	}
}
