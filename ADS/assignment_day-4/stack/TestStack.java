package stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestStack {

	@Test
	void insertOnEmpty() {
		StackUsingSLL stack = new StackUsingSLL();
		
		stack.push(15);
		
		assertEquals(15, stack.pop());
	}

	@Test
	void removeOnEmpty() {
		StackUsingSLL stack = new StackUsingSLL();
		
		assertEquals(-1, stack.pop());
	}

	@Test
	void addElemets() {
		StackUsingSLL stack = new StackUsingSLL();
		
		stack.push(15);
		stack.push(25);
		stack.push(35);
		stack.push(45);
		stack.push(55);
		
		assertEquals(55, stack.pop());
	}

	@Test
	void removeAfterAdding() {
		StackUsingSLL stack = new StackUsingSLL();
		
		stack.push(15);
		stack.push(25);
		stack.push(35);
		stack.push(45);
		stack.push(55);
		stack.pop();
		stack.pop();
		stack.pop();
		
		assertEquals(25, stack.pop());
	}

	@Test
	void removeAllAfterAdding() {
		StackUsingSLL stack = new StackUsingSLL();
		
		stack.push(15);
		stack.push(25);
		stack.push(35);
		stack.push(45);
		stack.push(55);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		
		assertEquals(-1, stack.pop());
	}
}
