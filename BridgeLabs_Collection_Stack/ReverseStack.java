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
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		System.out.println("Before Reverse : " + stack);
		System.out.println("After Reverse : " + reverse(stack));
	}
}
