package BridgeLabs_Collection_Map;

import java.util.HashMap;

class Employee {
	int id;
	String name;
	String dept;

	public Employee(int id, String name, String dept) {
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + "]";
	}
}

public class EmployeeRecords {
	private HashMap<Integer, Employee> emp;

	public EmployeeRecords() {
		emp = new HashMap<Integer, Employee>();
	}

	public void addEmployy(Employee employee) {
		emp.put(employee.id, employee);
		System.out.println("Employee Added Successfully");
	}

	public Employee searchById(int id) {
		if (emp.containsKey(id)) {
			return emp.get(id);
		} else {
			System.out.println("Employee NOT Found");
		}
		return null;
	}

	public static void main(String[] args) {

		Employee e1 = new Employee(101, "Alice", "HR");
		Employee e2 = new Employee(102, "Bob", "Engineering");
		Employee e3 = new Employee(103, "Charlie", "Marketing");

		EmployeeRecords empRecords = new EmployeeRecords();
		empRecords.addEmployy(e1);
		empRecords.addEmployy(e2);
		empRecords.addEmployy(e3);

		Employee searchById = empRecords.searchById(102);
		if (searchById != null) {
			System.out.println("EMployee : " + searchById);
		}
	}
}
