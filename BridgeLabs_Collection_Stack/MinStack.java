package BridgeLabs_Collection_Stack;

import java.util.Stack;

public class MinStack {

	// Two stacks: one for the actual values and one for the minimum values
	private Stack<Integer> mainStack;
	private Stack<Integer> minStack;

	// Constructor to initialize the stacks
	public MinStack() {
		mainStack = new Stack<>();
		minStack = new Stack<>();
	}

	// Push element x onto the stack
	public void push(int x) {
		mainStack.push(x);

		// Push onto minStack if it's empty or the current element is <= top of minStack
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}

	// Removes the element on top of the stack
	public void pop() {
		// Pop from both mainStack and minStack if the top elements are the same
		if (!mainStack.isEmpty()) {
			int popped = mainStack.pop();
			if (!minStack.isEmpty() && popped == minStack.peek()) {
				minStack.pop();
			}
		}
	}

	// Get the top element
	public int top() {
		if (!mainStack.isEmpty()) {
			return mainStack.peek();
		}
		return -1; // Or throw an exception if desired
	}

	// Retrieve the minimum element in constant time
	public int getMin() {
		if (!minStack.isEmpty()) {
			return minStack.peek();
		}
		return -1; // Or throw an exception if desired
	}

	// Main method to test the MinStack functionality
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(5);
		minStack.push(3);
		minStack.push(7);
		minStack.push(2);
		minStack.push(8);

		System.out.println("Current top: " + minStack.top()); // Should print 8
		System.out.println("Current min: " + minStack.getMin()); // Should print 2

		minStack.pop(); // Pop 8
		System.out.println("After popping, top: " + minStack.top()); // Should print 2
		System.out.println("After popping, min: " + minStack.getMin()); // Should print 2

		minStack.pop(); // Pop 2
		System.out.println("After popping, top: " + minStack.top()); // Should print 7
		System.out.println("After popping, min: " + minStack.getMin()); // Should print 3

		minStack.pop(); // Pop 7
		System.out.println("After popping, top: " + minStack.top()); // Should print 3
		System.out.println("After popping, min: " + minStack.getMin()); // Should print 3
	}
}

// NOT Understand