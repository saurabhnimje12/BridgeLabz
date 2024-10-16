package BridegeLabz_Exception_Handling;

public class ExceptionHierarchy {
	public static void check() {
		try {
			// int result = 100 / 0;
			String str = null;
			System.out.println(str.length());
		} catch (ArithmeticException ae) {
			System.out.println("Arithmetic Exception Occured");
		} catch (NullPointerException npe) {
			System.out.println("Null Pointer Exception Occured");
		}
	}

	public static void main(String[] args) {
		check();
	}
}
