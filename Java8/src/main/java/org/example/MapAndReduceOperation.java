package org.example;

import java.util.Arrays;
import java.util.List;

public class MapAndReduceOperation {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sumOfSquares = numbers.stream()
                .filter(num -> num % 2 == 0)                    // Filter even numbers
                .map(num -> num * num)                            // Square each even number
                .reduce(0, Integer::sum);            // Sum up the squares
        System.out.println("Sum of squares of even numbers: " + sumOfSquares);
    }
}
