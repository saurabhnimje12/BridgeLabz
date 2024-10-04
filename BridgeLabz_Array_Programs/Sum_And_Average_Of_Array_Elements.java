package BridgeLabz_Array_Programs;

public class Sum_And_Average_Of_Array_Elements {
	public static void Sum() {
		double[] arr3 = { 432.46, 32.54, 23.435, 756.76, 78.45 };
		double sum = 0;
		for (double d : arr3) {
			sum += d;
		}
		System.out.println("Sum : " + sum);
	}

	public static void Average() {
		double[] arr3 = { 432.46, 32.54, 23.435, 756.76, 78.45 };
		double sum = 0;
		for (double d : arr3) {
			sum += d;
		}
		System.out.println("Average : " + (sum / 5));
	}

	public static void main(String[] args) {
		Sum();
		Average();
	}
}
