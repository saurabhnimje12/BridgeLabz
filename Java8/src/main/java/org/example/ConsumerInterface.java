package org.example;

import java.util.function.Consumer;

public class ConsumerInterface {
    public static void main(String[] args) {
        String[] names = {"Anushka", "Deepika", "Anupama", "Kajal", "Sunny"};
        Consumer<String> consumer = name -> System.out.println(name.toUpperCase());
        for (String name : names) {
            consumer.accept(name);
        }
    }
}
