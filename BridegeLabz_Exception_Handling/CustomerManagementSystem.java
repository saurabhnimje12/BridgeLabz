package BridegeLabz_Exception_Handling;

import java.util.HashMap;
import java.util.Map;

class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(String mesg) {
		super(mesg);
	}
}

class InvalidCustomerDataException extends RuntimeException {
	public InvalidCustomerDataException(String mesg) {
		super(mesg);
	}
}

class Customer {
	int id;
	String name;
	int age;
	String city;

	public Customer(int id, String name, int age, String city) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	}
}

public class CustomerManagementSystem {
	static Map<Integer, Customer> map = new HashMap<Integer, Customer>();

	public static void AddCustomer(Customer customer, Map<Integer, Customer> map) {
		if (customer != null) {
			map.put(customer.id, customer);
			System.out.println("Customer Added Successfully");
		} else {
			throw new CustomerNotFoundException("Customer Not Found");
		}
	}

	public static void updateCustomer(Customer customer, Map<Integer, Customer> map) {
		if (map.containsKey(customer.id)) {
			map.put(customer.id, customer);
			System.out.println("Customer Updated Successfully");
		} else {
			throw new InvalidCustomerDataException("Enter a valid ID");
		}
	}

	public static void deleteCustomer(Integer id, Map<Integer, Customer> map) {
		if (map.containsKey(id)) {
			map.remove(id);
			System.out.println("Customer Deleted Successfully");
		} else {
			throw new InvalidCustomerDataException("Enter a valid ID");
		}
	}

	public static void main(String[] args) {
		try {
			AddCustomer(new Customer(101, "Raja", 20, "Pune"), map);
			AddCustomer(new Customer(102, "Rani", 22, "Mumbai"), map);
			System.out.println("After Adding : " + map);
			updateCustomer(new Customer(102, "John", 30, "Banglore"), map);
			System.out.println("After Updating : " + map);
			deleteCustomer(102, map);
			System.out.println("After Deleting : " + map);
		} catch (CustomerNotFoundException | InvalidCustomerDataException e) {
			System.out.println("Exception : " + e.getMessage());
		}
	}
}
