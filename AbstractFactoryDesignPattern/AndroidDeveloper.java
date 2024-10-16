package AbstractFactoryDesignPattern;

public class AndroidDeveloper implements Employee {
	@Override
	public String name() {
		System.out.println("Android Developer :: Kotlin");
		return "ANDROID";
	}

	@Override
	public int salary() {
		return 45000;
	}
}
