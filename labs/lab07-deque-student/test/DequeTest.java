import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DequeTest {

	Deque<String> deque;

	@Before
	public void setup() {
		deque = new LinkedDeque<String>();
	}

	@Test
	public void testFrontMethods() {
		assertTrue(deque.isEmpty()); // originally the deque should be empty
		deque.addToFront("Bob"); // add Bob to the front of the deque
		assertFalse(deque.isEmpty()); // deque should no longer be empty
		assertEquals("Bob", deque.first());
		deque.addToFront("VIP Alice"); // add VIP Alice to the front of the deque
		assertEquals("VIP Alice", deque.first());
		assertEquals("VIP Alice", deque.removeFront());
		assertFalse(deque.isEmpty());
		assertEquals("Bob", deque.first()); // Bob should still be in the deque
		deque.removeFront();
		assertTrue(deque.isEmpty());
	}

	@Test
	public void testRearMethods() {
		assertTrue(deque.isEmpty());
		deque.addToRear("Bob");
		assertFalse(deque.isEmpty());
		assertEquals("Bob", deque.first());
		assertEquals("Bob", deque.last());
		deque.addToRear("Lab");
		deque.addToRear("Val");
		assertEquals("Val", deque.last());
		assertEquals("Bob", deque.first());
		deque.removeRear();
		assertEquals("Lab", deque.last());
		System.out.println(deque.toString());
		String data = deque.removeRear();
		assertEquals("Lab", data);
		deque.removeRear();
		assertTrue(deque.isEmpty());
	}
}
