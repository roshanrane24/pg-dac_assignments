import java.util.Scanner;

public class Queue {
	static Scanner scan = new Scanner(System.in);
	
	public static void use(QueueInterface queue) {
		int choice;
		do {
			displayMenu();
			choice = scan.nextInt();
			
			switch (choice) {
				case 1 -> {
					System.out.print("Enter a number to add : ");
					queue.addQ(scan.nextInt());
				}
				case 2 -> {
					System.out.println(queue.deleteQ());
				}
				case 3 -> {
					System.out.println(queue.isEmpty() ? "YES" : "NO");
				}
				case 4 -> {
					System.out.println(queue.isFull() ? "YES" : "NO");
				}
				case 0 -> {
					System.out.println("--------------=============------------");
					System.out.println("--------------=====END=====------------");
					System.out.println("--------------=============------------");
				}
				default -> {
					System.out.println("Invalid option");
				}
			}
		} while (choice != 0);
	}

	private static void displayMenu() {
		System.out.println("1 -> Add Element.");
		System.out.println("2 -> Delete an element.");
		System.out.println("3 -> Is Empty?");
		System.out.println("4 -> Is Full?");
		System.out.println("0 -> Exit.");
	}
}
