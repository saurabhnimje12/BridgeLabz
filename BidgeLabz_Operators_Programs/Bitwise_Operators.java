package BidgeLabz_Operators_Programs;

public class Bitwise_Operators {

	public void bitwise() {
		// Initialize two integer variables
		int a = 5; // 0101 in binary
		int b = 3; // 0011 in binary

		// Perform bitwise AND
		int andResult = a & b; // 0001 in binary, which is 1
		System.out.println("Bitwise AND of " + a + " and " + b + ": " + andResult);

		// Perform bitwise OR
		int orResult = a | b; // 0111 in binary, which is 7
		System.out.println("Bitwise OR of " + a + " and " + b + ": " + orResult);

		// Perform bitwise XOR
		int xorResult = a ^ b; // 0110 in binary, which is 6
		System.out.println("Bitwise XOR of " + a + " and " + b + ": " + xorResult);
	}

	public static void main(String[] args) {
		Bitwise_Operators bo = new Bitwise_Operators();
		bo.bitwise();
	}

}
