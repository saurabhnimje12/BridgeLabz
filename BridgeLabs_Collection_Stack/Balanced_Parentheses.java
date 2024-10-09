package BridgeLabs_Collection_Stack;

import java.util.Stack;

public class Balanced_Parentheses {

	// Function to check if the parentheses are balanced
	public boolean isBalanced(String s) {
		// Stack to store opening brackets
		Stack<Character> stack = new Stack<>();

		// Traverse through the characters in the string
		for (char c : s.toCharArray()) {
			// If it's an opening bracket, push it onto the stack
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}
			// If it's a closing bracket, check for the corresponding opening bracket
			else if (c == ')' || c == '}' || c == ']') {
				// If the stack is empty or top of stack does not match the closing bracket
				if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
					return false;
				}
			}
		}

		// If the stack is empty at the end, the parentheses are balanced
		return stack.isEmpty();
	}

	// Helper function to check if the pairs of brackets match
	private boolean isMatchingPair(char open, char close) {
		return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
	}

	// Main method for testing
	public static void main(String[] args) {
		Balanced_Parentheses checker = new Balanced_Parentheses();

		// Test cases
		String test1 = "{[()]}";
		String test2 = "{[(])}";
		String test3 = "{[}";
		String test4 = "";

		System.out.println("Is \"" + test1 + "\" balanced? " + checker.isBalanced(test1)); // true
		System.out.println("Is \"" + test2 + "\" balanced? " + checker.isBalanced(test2)); // false
		System.out.println("Is \"" + test3 + "\" balanced? " + checker.isBalanced(test3)); // false
		System.out.println("Is \"" + test4 + "\" balanced? " + checker.isBalanced(test4)); // true
	}
}
