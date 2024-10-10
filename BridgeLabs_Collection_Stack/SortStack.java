package BridgeLabs_Collection_Stack;

import java.util.Stack;

public class SortStack {
	public static void sortStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int top = stack.pop();
		sortStack(stack);
		insertInSortedOrder(stack, top);
	}

	public static void insertInSortedOrder(Stack<Integer> stack, int element) {
		if (stack.isEmpty() || stack.peek() <= element) {
			stack.push(element);
			return;
		}
		int top = stack.pop();
		insertInSortedOrder(stack, element);
		stack.push(top);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(34);
		stack.push(3);
		stack.push(31);
		stack.push(98);
		stack.push(92);
		stack.push(23);
		System.out.println("Original Stack: " + stack);
		sortStack(stack);
		System.out.println("Sorted Stack: " + stack);
	}
}
