package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalHandling {
    public static Optional<Integer> checkOptional(List<Integer> list) {
        return list.stream().max(Integer::compareTo);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 2, 1, 6, 9, 3));
        Optional<Integer> checked = checkOptional(list);
        checked.ifPresentOrElse(
                value -> System.out.println("MAX No : " + checked),
                () -> System.out.println("List is EMPTY")
        );

//      OR
//        if (checked.isPresent()){
//            System.out.println("MAX No : "+checked);
//        }else{
//            System.out.println("List is EMPTY");
//        }

    }


}
