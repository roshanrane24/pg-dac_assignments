import linkedList.SinglyLinkedList;

public class SLLTest {
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		
		for (int i = 0; i < 1000; i++) {
			sll.AddAtFront((int)(Math.random() * 100));
		}
		
		sll.Print();
		
		int search = (int)(Math.random() * 100);
		System.out.println("Is " + search + " in the list = " + sll.Search(search));
		System.out.println("Frequency of " + search + " : " + sll.CountFrequency(search));
	}
}
