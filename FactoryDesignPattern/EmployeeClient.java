package FactoryDesignPattern;

import java.util.Scanner;

interface Employee {
	String developer();
}

class WebDeveloper implements Employee {
	@Override
	public String developer() {
		return "Web Developer :: JAVA : 55000";
	}
}

class AndroidDeveloper implements Employee {
	@Override
	public String developer() {
		return "Android Developer :: JAVA : 45000";
	}
}

class IosDeveloper implements Employee {
	@Override
	public String developer() {
		return "IOS Developer :: JAVA : 50000";
	}
}

class EmployeeFactory {
	public static Employee getEmployeeObject(String input) {
		if (input.trim().equalsIgnoreCase("WEB")) {
			return new WebDeveloper();
		} else if (input.trim().equalsIgnoreCase("ANDROID")) {
			return new AndroidDeveloper();
		} else if (input.trim().equalsIgnoreCase("IOS")) {
			return new IosDeveloper();
		} else {
			return null;
		}
	}
}

public class EmployeeClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter : WEB / ANDROID / IOS");
		Employee employee = EmployeeFactory.getEmployeeObject(sc.nextLine());
		if (null != employee) {
			System.out.println(employee.developer());
		} else {
			System.out.println("Enter Valid Input");
		}
	}
}
