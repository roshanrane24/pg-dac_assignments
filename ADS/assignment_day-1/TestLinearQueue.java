import java.util.Scanner;

public class TestLinearQueue {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a size of queue : ");
		LinearQueueUsingArray lq = new LinearQueueUsingArray(scan.nextInt());
		Queue.use(lq);
	}
}
