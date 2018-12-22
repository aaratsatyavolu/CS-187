package midterm2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CircularLinkedQueueTest {
	@Test
	public void testEnqueueDequeue() {
		CircularLinkedQueue<Integer> queue = new CircularLinkedQueue<Integer>();
		queue.enqueue(new Integer(5));
//		queue.enqueue(new Integer(6));
//		queue.enqueue(new Integer(7));
		System.out.println(queue.toString());
		queue.dequeue();
//		queue.dequeue();
//		queue.dequeue();
		assertTrue(queue.rear == null);
		
	}
}
