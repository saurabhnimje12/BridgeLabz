package BidgeLabz_DSA_LinkedList;

class Node1 {
	int data;
	Node1 next;

	Node1(int data) {
		this.data = data;
		this.next = null;
	}
}

public class Reverse_a_LinkedList {
	private Node1 head;

	public boolean isEmpty() {
		return head == null;
	}

	public void addAtEnd(int data) {

		if (isEmpty()) {
			Node1 newNode = new Node1(data);
			head = newNode;
		} else {
			Node1 newNode = new Node1(data);
			Node1 temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

}
