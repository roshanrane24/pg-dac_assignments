import java.util.Scanner;

public class TestCircularQueue {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a size of queue : ");
		CircularQueueUsingArray cq = new CircularQueueUsingArray(scan.nextInt());
		Queue.use(cq);
		
	}
}
