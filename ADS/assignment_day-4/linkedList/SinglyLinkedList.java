package linkedList;

public class SinglyLinkedList implements LinkedListIntf {
	private class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;
	Node tail;

	public SinglyLinkedList() {
		head = null;
		tail = null;
	}

	@Override
	public void AddAtFront(int element) {
		Node newNode = new Node(element);

		// When list is empty
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			return;
		}

		// When list is not empty
		newNode.next = this.head;
		this.head = newNode;
	}

	@Override
	public void Print() {
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	@Override
	public void AddAtRear(int element) {
		Node newNode = new Node(element);

		// When list is empty
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			return;
		}

		// When list not empty
		this.tail.next = newNode;
		this.tail = newNode;
	}

	@Override
	public void DeleteFirstNode() {
		// When List empty
		if (this.head == null)
			return;

		// List not empty
		Node temp = this.head;
		this.head = this.head.next;
		temp.next = null;
	}

	@Override
	public void DeleteLastNode() {
		// When List empty
		if (this.head == null)
			return;

		// When list not empty
		Node prev = null;
		Node curr = this.head;

		// until curr is last node
		while (curr.next != null) {
			prev = curr;
			curr = curr.next;
		}

		// switch tail pointer to second last node
		this.tail = prev;
		this.tail.next = null;
	}

	public int getHeadElement() {
		return this.head.data;
	}

	public int getTailElement() {
		return this.tail.data;
	}
	public boolean isEmpty() {
		if (this.head == null)
			return true;
		return false;
	}
}
