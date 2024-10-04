package BidgeLabz_DSA_LinkedList;

public class SinglyLinkedList {
	// Define the Node class
	private static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// Head of the linked list
	private Node head;

	// Method to add a node to the end of the linked list
	public void addToEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	// Method to delete a node from the beginning of the linked list
	public void deleteFromBeginning() {
		if (head == null) {
			System.out.println("List is empty. No nodes to delete.");
		} else {
			head = head.next;
		}
	}

	// Method to display all nodes in the linked list
	public void display() {
		if (head == null) {
			System.out.println("List is empty.");
		} else {
			Node current = head;
			while (current != null) {
				System.out.print(current.data + " -> ");
				current = current.next;
			}
			System.out.println("null");
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();

		// Add nodes to the end
		list.addToEnd(10);
		list.addToEnd(20);
		list.addToEnd(30);

		// Display the linked list
		System.out.println("Linked list after adding nodes:");
		list.display();

		// Delete node from the beginning
		list.deleteFromBeginning();

		// Display the linked list
		System.out.println("Linked list after deleting a node from the beginning:");
		list.display();
	}
}
