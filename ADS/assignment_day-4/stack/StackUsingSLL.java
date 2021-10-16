package stack;

import linkedList.SinglyLinkedList;

public class StackUsingSLL implements StackInterface {
	
	SinglyLinkedList list = new SinglyLinkedList();

	@Override
	public void push(int element) {
		this.list.AddAtFront(element);
	}

	@Override
	public int pop() {
		if(this.isEmpty()) {
			System.out.println("StackUnderflow");
			return -1;
		}
		int element = this.list.getHeadElement();
		this.list.DeleteFirstNode();
		return element;
	}

	@Override
	public boolean isEmpty() {
		if (this.list.isEmpty())
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		return false;
	}

}
