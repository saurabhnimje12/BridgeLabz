package BidgeLabz_DSA_ArrayList;

public class Find_the_First_Non_duplicate_Character_in_a_String {
	public static int first_Non_duplicate_Character() {
		String str = "mnbvczmnnbvxz";
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return j;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int duplicate_Character = first_Non_duplicate_Character();
		if (duplicate_Character == -1) {
			System.out.println("No duplicate character in the String");
		} else {
			System.out.println("First Duplicate found in Index Position : " + duplicate_Character);
		}
	}
}
