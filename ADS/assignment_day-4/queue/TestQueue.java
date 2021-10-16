package queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestQueue {

	@Test
	void insertOnEmpty() {
		QueueUsingSLL queue = new QueueUsingSLL();
		
		queue.addQ(15);
		
		assertEquals(15, queue.deleteQ());
	}

	@Test
	void removeOnEmpty() {
		QueueUsingSLL queue = new QueueUsingSLL();
		
		assertEquals(-1, queue.deleteQ());
	}

	@Test
	void addElemets() {
		QueueUsingSLL queue = new QueueUsingSLL();
		
		queue.addQ(15);
		queue.addQ(25);
		queue.addQ(35);
		queue.addQ(45);
		queue.addQ(55);
		
		assertEquals(15, queue.deleteQ());
	}

	@Test
	void removeAfterAdding() {
		QueueUsingSLL queue = new QueueUsingSLL();
		
		queue.addQ(15);
		queue.addQ(25);
		queue.addQ(35);
		queue.addQ(45);
		queue.addQ(55);
		queue.deleteQ();
		queue.deleteQ();
		queue.deleteQ();
		
		assertEquals(45, queue.deleteQ());
	}

	@Test
	void removeAllAfterAdding() {
		QueueUsingSLL queue = new QueueUsingSLL();
		
		queue.addQ(15);
		queue.addQ(25);
		queue.addQ(35);
		queue.addQ(45);
		queue.addQ(55);
		queue.deleteQ();
		queue.deleteQ();
		queue.deleteQ();
		queue.deleteQ();
		queue.deleteQ();
		
		assertEquals(-1, queue.deleteQ());
	}
}
