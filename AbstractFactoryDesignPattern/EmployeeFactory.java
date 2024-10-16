package AbstractFactoryDesignPattern;

public class EmployeeFactory {

	public static Employee getEmployee(EmployeeAbstractFactory abstractFactory) {
		return abstractFactory.createEmployee();
	}
}
