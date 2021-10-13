
public class CircularQueueUsingArray implements QueueInterface {
	private int SIZE;
	private int[] queue;
	private int front;
	private int rear;
	
	public CircularQueueUsingArray(int n) {
		this.SIZE = n + 1;
		this.queue = new int[n + 1];
		this.front = 0;
		this.rear = 0;
	}

	@Override
	public void addQ(int element) {
		if (this.isFull()) {
			System.out.println("Queue is Full cannot add " + element);
			return;
		}
		this.queue[rear] = element;
		this.rear = (this.rear + 1) % this.SIZE;
	}

	@Override
	public int deleteQ() {
		if (this.isEmpty()) {
			System.out.println("Queue Cannot remove element");
			return -1;
		}
		int t = queue[this.front];
		this.front = (this.front + 1) % this.SIZE;
		return t;
	}

	@Override
	public boolean isEmpty() {
		if (this.front == this.rear)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if (((this.rear + 1) % this.SIZE ) == this.front)
			return true;
		return false;
	}
}
