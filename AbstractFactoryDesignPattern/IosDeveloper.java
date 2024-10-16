package AbstractFactoryDesignPattern;

public class IosDeveloper implements Employee {
	@Override
	public String name() {
		System.out.println("IOS Developer :: Swift");
		return "IOS";
	}

	@Override
	public int salary() {
		return 50000;
	}
}
