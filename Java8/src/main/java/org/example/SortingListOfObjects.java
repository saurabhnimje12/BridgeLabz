package org.example;

import java.util.ArrayList;
import java.util.Arrays;

class Person {
    String name;
    int age;
    double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

}

public class SortingListOfObjects {
    public static void ascendingSortByAge(ArrayList<Person> list) {
        list.sort((l1, l2) -> Integer.compare(l1.getAge(), l2.getAge()));
    }

    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Kyla", 20, 45000.00));
        list.add(new Person("Richard", 25, 64000));
        list.add(new Person("Jennifer", 18, 87000));
        list.add(new Person("Amanda", 35, 98000));
        list.add(new Person("Jade", 27, 68000));

        ascendingSortByAge(list);
        System.out.println(list);
    }
}
