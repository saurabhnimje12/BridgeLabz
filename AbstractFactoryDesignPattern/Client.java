package AbstractFactoryDesignPattern;

public class Client {
	public static void main(String[] args) {
		Employee employee1 = EmployeeFactory.getEmployee(new WebDevFactory());
		System.out.println(employee1.name() + " :: " + employee1.salary());

		Employee employee2 = EmployeeFactory.getEmployee(new AndroidDevFactory());
		System.out.println(employee2.name() + " :: " + employee2.salary());
		
		Employee employee3 = EmployeeFactory.getEmployee(new IosDevFactory());
		System.out.println(employee3.name() + " :: " + employee3.salary());
	}
}
