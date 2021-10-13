package linkedList;

public class SinglyLinkedList implements LinkedListIntf {

	private class Node {
		int data;
		Node next;
	}
	
	private Node head;
	private Node tail;
	
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	@Override
	public void AddAtFront(int element) {
		Node newNode = new Node();
		newNode.data = element;
		
		if (this.isEmpty()) {
			newNode.next = null;
			this.head = newNode;
			this.tail = newNode;
			
			return;
		}

		newNode.next = this.head;
		this.head = newNode;
	}

	@Override
	public void Print() {
		Node curr = this.head;
		
		System.out.print("[ ");
		while (curr != null) {
			System.out.print(curr.data + ", ");
			curr = curr.next;
		}
		System.out.println("]");
	}

	private boolean isEmpty() {
		if (this.head == null)
			return true;
		return false;
	}

	@Override
	public boolean Search(int element) {
		Node curr = this.head;

		while (curr != null) {
			if (curr.data == element)
				return true;
			curr = curr.next;
		}
		return false;
	}

	@Override
	public int CountFrequency(int element) {
		int count = 0;
		Node curr = this.head;

		while (curr != null) {
			if (curr.data == element)
				count++;
			curr = curr.next;
		}
		return count;
	}
}
