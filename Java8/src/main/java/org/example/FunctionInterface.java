package org.example;

import java.util.function.Function;

public class FunctionInterface {
    public static void main(String[] args) {
        Function<Double, Double> function = radius -> Math.PI * radius * radius;
        System.out.println("AREA : " + function.apply(5.5));
    }
}
