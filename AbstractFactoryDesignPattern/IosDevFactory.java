package AbstractFactoryDesignPattern;

public class IosDevFactory extends EmployeeAbstractFactory {
	@Override
	public Employee createEmployee() {
		return new IosDeveloper();
	}
}
