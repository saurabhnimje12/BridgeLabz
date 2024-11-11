package org.FunctionalInterface;

import javax.swing.plaf.synth.SynthOptionPaneUI;

@FunctionalInterface
interface FunInterface {
    int apply(int x, int y);
}

public class FunctionalInterfaceExample {

    public static void check(int a, int b) {
        FunInterface addition = (x, y) -> x + y;
        FunInterface subtraction = (x, y) -> x - y;
        FunInterface multiply = (x, y) -> x * y;
        FunInterface division = (x, y) -> {
            if (y == 0) {
                throw new ArithmeticException("Division by zero is not allowed");
            }
            return x / y;
        };

        System.out.println("Addition : " + addition.apply(a, b));
        System.out.println("Subtraction : " + subtraction.apply(a, b));
        System.out.println("Multiply : " + multiply.apply(a, b));
        System.out.println("Division : " + division.apply(a, b));
    }

    public static void main(String[] args) {
        int x = 8;
        int y = 2;
        check(x, y);
    }
}
