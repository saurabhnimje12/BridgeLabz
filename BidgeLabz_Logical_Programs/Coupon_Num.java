package BidgeLabz_Logical_Programs;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Coupon_Num {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number : ");
		int input = scanner.nextInt();

		HashSet<Integer> set = new HashSet<>();

		Random random = new Random();
		int attempt = 0;

		while (set.size() < input) {
			int num = random.nextInt(input) + 1;
			System.out.println("Num : " + num);

			set.add(num);
			attempt++;
		}
		System.out.println(set);
		System.out.println("Input : " + input + " Attempts : " + attempt);
	}
}
