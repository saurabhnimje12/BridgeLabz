package BidgeLabz_Operators_Programs;

public class Unary_Operators {

	public void post_IncrementAnd_Pre_Increment() {
		int i = 100;

		System.out.println("Pre_Increment : " + (++i));

		System.out.println("Post_Increment : " + (i++));
	}

	public void toggle_Boolean() {
		boolean flag = false;

		System.out.println(flag);

		flag = !flag;
		System.out.println(flag);
	}

	public static void main(String[] args) {
		Unary_Operators uo = new Unary_Operators();

		uo.post_IncrementAnd_Pre_Increment();

		uo.toggle_Boolean();
	}
}
