package org.example;

@FunctionalInterface
interface CustomInterface {
    public double square(double value);
    default void print(double value) {
        System.out.println("Square root of " + value + " : " + square(value));
    }
}

public class CustomFunctionalInterfaceWithDefaultMethod {
    public static void main(String[] args) {
      CustomInterface ci = value -> value * value;
      ci.print(5.5);
    }
}
