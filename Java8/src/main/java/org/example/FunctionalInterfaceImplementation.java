package org.example;

import java.util.function.Predicate;

@FunctionalInterface
interface AddSum {
    public int sum(int a, int b);
}

public class FunctionalInterfaceImplementation {
    public static void main(String[] args) {
        AddSum addSum = (a, b) -> (a + b);
        System.out.println("SUM : " + addSum.sum(10, 20));
    }
}
