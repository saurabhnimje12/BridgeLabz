package BidgeLabz_Logical_Programs;

import java.util.Scanner;

public class Stopwatch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Press 'S' to start the stopwatch : ");
		char ch1 = scanner.next().toUpperCase().charAt(0);

		if (ch1 == 'S') {
			long startTime = System.currentTimeMillis();

			System.out.println("Press 'P' to stop the stopwatch : ");
			char ch2 = scanner.next().toUpperCase().charAt(0);
			
			if (ch2 == 'P') {
				long stopTime = System.currentTimeMillis();
				long time = stopTime - startTime;
				
				double timeInSecond = time / 1000.0;
				System.out.println("Total time : " + timeInSecond + " seconds");
			} else {
				System.out.println("Stopwatch not stopped ");
			}
		} else {
			System.out.println("Stopwatch not started ");
		}
	}
}
