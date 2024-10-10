package BridgeLabs_Collection_Stack;

import java.util.Stack;

public class Balanced_Parentheses {
	public boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	private boolean isMatchingPair(char open, char close) {
		return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
	}

	public static void main(String[] args) {
		Balanced_Parentheses checker = new Balanced_Parentheses();
		String test1 = "{[()]}";
		String test2 = "{[(])}";
		String test3 = "{[}";
		String test4 = "";

		System.out.println("Is \"" + test1 + "\" balanced? " + checker.isBalanced(test1));
		System.out.println("Is \"" + test2 + "\" balanced? " + checker.isBalanced(test2));
		System.out.println("Is \"" + test3 + "\" balanced? " + checker.isBalanced(test3));
		System.out.println("Is \"" + test4 + "\" balanced? " + checker.isBalanced(test4));
	}
}
