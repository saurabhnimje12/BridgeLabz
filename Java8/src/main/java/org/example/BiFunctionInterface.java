package org.example;

import java.util.function.BiFunction;

public class BiFunctionInterface {
    public static void main(String[] args) {
        BiFunction<String, String, String> str = (str1, str2) -> str1 + " " + str2;
        System.out.println("Concatenated String: " + str.apply("Spring", "Boot")) ;
    }
}
