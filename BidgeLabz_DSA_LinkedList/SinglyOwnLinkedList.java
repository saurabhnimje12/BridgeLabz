package BidgeLabz_DSA_LinkedList;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class SinglyOwnLinkedList {
	private Node head;

	public boolean isEmpty() {
		return head == null;
	}

	public void addAtBeginning(int data) {
		if (isEmpty()) {
			head = new Node(data);
		} else {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}
	}

	public void addAtEnd(int data) {
		if (isEmpty()) {
			head = new Node(data);
		} else {
			Node newNode = new Node(data);
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public void addAtSpecificLocation(int data, int position) {
		if (isEmpty()) {
			head = new Node(data);
		} else {
			Node newNode = new Node(data);
			Node temp = head;
			for (int i = 0; i < position; i++) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}

	public void deleteFromBeginning() {
		if (isEmpty()) {
			System.out.println("List is empty.");
		} else {
			head = head.next;
		}
	}

	public void display() {
		if (isEmpty()) {
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

		SinglyOwnLinkedList list = new SinglyOwnLinkedList();
		list.addAtBeginning(10);
		list.addAtBeginning(20);
		list.addAtBeginning(30);
		list.addAtBeginning(40);
		System.out.println("Insertion At Beginning : ");
		list.display();

		list.addAtEnd(50);
		list.addAtEnd(60);
		list.addAtEnd(70);
		list.addAtEnd(80);
		System.out.println("Insertion At End : ");
		list.display();

		list.addAtSpecificLocation(100, 4);
		System.out.println("Insertion At End : ");
		list.display();

		list.deleteFromBeginning();
		System.out.println("Delete from Beggining : ");
		list.display();

	}
}
