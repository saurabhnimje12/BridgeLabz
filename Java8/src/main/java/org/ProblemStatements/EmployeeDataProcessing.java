package org.ProblemStatements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", department='" + department + '\'' + ", salary=" + salary + '}';
    }
}

public class EmployeeDataProcessing {
    public static void main(String[] args) {
        ArrayList<Employee> empList = new ArrayList<Employee>();
        empList.add(new Employee(1, "John", "Engineering", 55000));
        empList.add(new Employee(2, "Roy", "Doctor", 24000));
        empList.add(new Employee(3, "Smith", "Lawyer", 65000));
        empList.add(new Employee(4, "Alina", "Doctor", 57000));
        empList.add(new Employee(5, "Josh", "Lawyer", 86000));
        empList.add(new Employee(6, "Elijah", "Engineering", 89000));
        empList.add(new Employee(7, "Henry", "Doctor", 23000));
        empList.add(new Employee(8, "Henry", "Lawyer", 56000));
        empList.add(new Employee(9, "Benjamin", "Doctor", 75000));
        empList.add(new Employee(10, "James", "Engineering", 23000));
        empList.add(new Employee(11, "William", "Lawyer", 85000));
        empList.add(new Employee(12, "Ava", "Engineering", 35000));

//        1. Filter: Select employees who belong to the "Engineering" department and have a salary greater than $80,000.
        empList.stream()
                .filter(emp -> emp.getSalary() > 80000 && emp.getDepartment().equals("Engineering"))
                .collect(Collectors.toList())
                .forEach(emp -> System.out.println(emp));
        System.out.println("==========================================");

//        2. Sort: Sort these employees by their salary in descending order.
        empList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);
        System.out.println("==========================================");

//        3. Group: Group the resulting employees by their department.
        Map<String, List<Employee>> collect = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        collect.forEach((department, emplist) -> {
            System.out.println("\nDepartment : " + department);
            emplist.forEach(System.out::println);
        });
        System.out.println("==========================================");

//        4. Aggregate: For each department, calculate the average salary of employees.
        Map<String, Double> collect1 = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        collect1.forEach((department, salary) -> {
            System.out.println(department + " : " + salary);
        });
        System.out.println("==========================================");
    }
}
