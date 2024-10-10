package BridgeLabs_Collection_Stack;

import java.util.Stack;

public class EvaluatePostfixExpression {

	public static int evaluatePostfix(String expression) {
		Stack<Integer> stack = new Stack<>();
		String[] tokens = expression.split(" ");
		for (String token : tokens) {
			if (isNumber(token)) {
				stack.push(Integer.parseInt(token));
			} else {
				int operand2 = stack.pop();
				int operand1 = stack.pop();
				switch (token) {
				case "+":
					stack.push(operand1 + operand2);
					break;
				case "-":
					stack.push(operand1 - operand2);
					break;
				case "*":
					stack.push(operand1 * operand2);
					break;
				case "/":
					stack.push(operand1 / operand2);
					break;
				}
			}
		}
		return stack.pop();
	}

	private static boolean isNumber(String token) {
		try {
			Integer.parseInt(token);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		String expression = "5 6 2 + * 12 4 / -";
		System.out.println("Postfix Expression: " + expression);
		System.out.println("Evaluated Result: " + evaluatePostfix(expression));
	}
}
