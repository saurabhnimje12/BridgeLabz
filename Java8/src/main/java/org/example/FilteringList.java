package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Anushka", "Deepika", "Anupama", "Kajal", "Sunny"));
        List<String> list = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
        System.out.println("List : " + list);
    }
}
