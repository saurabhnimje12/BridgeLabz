package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateComposition {
    public static void main(String[] args) {
        String[] names = {"testExample", "sample", "exampleTest", "short", "testing", "Java"};
        Predicate<String> predicate = name -> name.length() > 5 && name.contains("test");
        for (String str : names) {
            if (predicate.test(str)) {
                System.out.println(str);
            }
        }

//      OR
//      List<String> collect = Arrays.stream(names).filter(name -> name.length() > 5).filter(name -> name.contains("test")).collect(Collectors.toList());
//      System.out.println(collect);
    }
}
