
public class LinearQueueUsingArray implements QueueInterface {
	int SIZE;
	int[] queue;
	int front;
	int rear;
	
	public LinearQueueUsingArray(int n) {
		this.SIZE = n;
		this.queue = new int[n];
		this.front = -1;
		this.rear = -1;
	}
	
	@Override
	public void addQ(int element) {
		if (this.isFull()) {
			System.out.println("Queue is full cannot add " + element + " to queue.");
			return;
		}
		this.queue[++rear] = element;
	}

	@Override
	public int deleteQ() {
		if (this.isEmpty()) {
			System.out.println("Queue is empty cannot delete from queue.");
			return -1;
		}
		int t = queue[++front];
		System.out.println(t + " has been removed from queue.");
		return t;
	}

	@Override
	public boolean isEmpty() {
		if (front == rear)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if (rear == this.SIZE - 1)
			return true;
		return false;
	}

}
