package BridgeLabs_Collection_Stack;

import java.util.Stack;

public class ReverseStack {
	public static Stack<Integer> reverse(Stack<Integer> stack) {
		Stack<Integer> st = new Stack<Integer>();
		while (!stack.empty()) {
			st.push(stack.pop());
		}
		return st;
	}

	public static void main(String[] args) {
		Stack stack = new Stack<Integer>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(5);

		System.out.println("Before Reverse : " + stack);
		System.out.println("After Reverse : " + reverse(stack));
	}
}
