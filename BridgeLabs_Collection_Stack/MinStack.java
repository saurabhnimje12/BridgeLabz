package BridgeLabs_Collection_Stack;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> minStack;

	public MinStack() {
		minStack = new Stack<Integer>();
	}

	public Stack<Integer> findMinElement(Stack<Integer> stk) {
		for (Integer integer : stk) {
			if (minStack.isEmpty() || integer <= minStack.peek()) {
				minStack.push(integer);
			}
		}
		return minStack;
	}

	public Stack<Integer> sortStack(Stack<Integer> stk) {
		for (int i = 0; i < stk.size(); i++) {
			for (int j = i + 1; j < stk.size(); j++) {
				if (stk.get(i) > stk.get(j)) {
					int temp = stk.get(j);
					stk.set(j, stk.get(i));
					stk.set(i, temp);
				}
			}
		}
		return stk;
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(10);
		stk.push(30);
		stk.push(70);
		stk.push(20);
		stk.push(50);
		stk.pop();

		System.out.println("STACK : " + stk);
		Stack<Integer> findMinElement = minStack.findMinElement(stk);
		System.out.println("Minimum Element in Stack : " + findMinElement);

		minStack.sortStack(stk);
		System.out.println(stk);
		System.out.println("Top Element in Stack : " + stk.peek());
	}
}
