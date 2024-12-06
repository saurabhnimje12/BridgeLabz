package org.example;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a no");
        int num = scanner.nextInt();    // num = 178 , 16 , 7
        int sum = 0;

        while (num >= 10) {
            sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        System.out.println(num);


    }
}
