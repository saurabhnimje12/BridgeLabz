package AbstractFactoryDesignPattern;

public class WebDeveloper implements Employee {
	@Override
	public String name() {
		System.out.println("WEB Developer :: Java");
		return "WEB";
	}

	@Override
	public int salary() {
		return 55000;
	}

}
