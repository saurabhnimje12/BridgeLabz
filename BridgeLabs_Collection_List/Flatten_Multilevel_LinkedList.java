package BridgeLabs_Collection_List;

class Node {
	int val;
	Node next;
	Node child;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.child = null;
	}
}

public class Flatten_Multilevel_LinkedList {
	public Node flatten(Node head) {
		if (head == null)
			return null;

		Node current = head;
		while (current != null) {
			// If the current node has a child
			if (current.child != null) {
				Node child = current.child;

				// Find the tail of the child list
				Node childTail = child;
				while (childTail.next != null) {
					childTail = childTail.next;
				}

				// Connect the child list's tail to the next node of current
				childTail.next = current.next;

				// Connect current node's next to the start of the child list
				current.next = child;

				// Remove the child pointer since it's now part of the main list
				current.child = null;
			}

			// Move to the next node in the list (next of the current or child list)
			current = current.next;
		}

		return head;
	}

	// Utility function to print the flattened list (for testing purposes)
	public void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {

		Flatten_Multilevel_LinkedList fml = new Flatten_Multilevel_LinkedList();

		// Creating a multilevel linked list
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		head.next.next.child = new Node(6);
		head.next.next.child.next = new Node(7);
		head.next.next.child.next.next = new Node(8);
		head.next.next.child.next.child = new Node(9);

		System.out.println("Original Multilevel List:");
		fml.printList(head);

		// Flatten the list
		Node flattenedHead = fml.flatten(head);

		System.out.println("Flattened List:");
		fml.printList(flattenedHead);
	}
}

// Code NOT UNDERSTAND

//
//		1 -> 2 -> 3 -> 4 -> 5
//				  |
//				  6 -> 7 -> 8
//		    		   |
//		    		   9
//
//================================================
//
//		1 -> 2 -> 3 -> 6 -> 7 -> 9 -> 8 -> 4 -> 5
//