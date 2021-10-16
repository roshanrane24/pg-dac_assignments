package queue;

import linkedList.SinglyLinkedList;

public class QueueUsingSLL implements QueueInterface {
	
	SinglyLinkedList list = new SinglyLinkedList();

	@Override
	public void addQ(int element) {
		this.list.AddAtRear(element);		
	}

	@Override
	public int deleteQ() {
		if (this.isEmpty())
			return -1;
		int result = list.getHeadElement();
		list.DeleteFirstNode();
		return result;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return false;
	}

}
