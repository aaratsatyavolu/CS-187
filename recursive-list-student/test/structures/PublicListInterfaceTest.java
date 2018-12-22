package structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PublicListInterfaceTest {

	private ListInterface<String> list;
	private ListInterface<Integer> list2;

	@Before
	public void setup() {
		list = new RecursiveList<String>();
	}

	@Test(timeout = 500)
	public void testInsertFirstIsEmptySizeAndGetFirst1() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		assertEquals("Insert First should return instance of self", list, list.insertFirst("hello"));
		assertFalse("List should now have elements.", list.isEmpty());
		assertEquals("List should now have 1 element.", 1, list.size());
		assertEquals("First element should .equals \"hello\".", "hello", list.getFirst());
		list.insertFirst("world");
		assertEquals(2, list.size());
		list.insertFirst("foo");
		assertEquals(3, list.size());
		assertEquals("First element should .equals \"foo\".", "foo", list.getFirst());
	}

	@Test
	public void testCumulative() {
		list2 = new RecursiveList<Integer>();
		list2.insertFirst(new Integer(5));
		list2.insertFirst(new Integer(4));
		list2.insertFirst(new Integer(3));
		list2.insertFirst(new Integer(2));
		list2.insertFirst(new Integer(1));
		list2.insertAt(2, new Integer(10));
		assertEquals(6, list2.size());
		list2.insertLast(new Integer(9));
		assertTrue(list2.size() == 7);
		list2.removeAt(0);
		assertTrue(list2.size() == 6);
		list2.removeAt(5);
		list2.removeAt(3);
		assertTrue(list2.size() == 4);
		assertTrue(2 == list2.get(0));
		list2.get(3);
	}

	@Test(expected = NullPointerException.class)
	public void testInsertFirst() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		assertEquals(0, l.size());
		l.insertFirst(new Integer(1));
		assertEquals(1, l.size());
		l.insertFirst(new Integer(2));
		assertEquals(2, l.size());
		l.insertFirst(null);
	}

	@Test(expected = NullPointerException.class)
	public void testInsertLast() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		assertEquals(0, l.size());
		l.insertLast(new Integer(1));
		assertEquals(1, l.size());
		l.insertLast(new Integer(2));
		assertEquals(2, l.size());
		l.insertLast(null);
	}

	@Test(expected = NullPointerException.class)
	public void testInsertAtNull() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.insertAt(0, null);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertAt() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.insertAt(-1, new Integer(4));
		l.insertAt(0, new Integer(3));
		assertEquals(1, l.size());
		l.insertAt(0, new Integer(4));
		assertEquals(2, l.size());
		l.insertAt(0, new Integer(5));
		assertEquals(3, l.size());
		l.insertAt(l.size(), new Integer(3));
		l.insertAt(l.size() + 1, new Integer(3));
	}

	@Test(expected = IllegalStateException.class)
	public void testRemoveFirstEmpty() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.removeFirst();
	}

	@Test(expected = IllegalStateException.class)
	public void testRemoveFirstNotEmpty() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.insertAt(0, new Integer(5));
		l.insertAt(0, new Integer(4));
		l.insertAt(0, new Integer(3));
		l.insertAt(0, new Integer(2));
		l.insertAt(0, new Integer(1));
		assertEquals(5, l.size());
		l.removeFirst(); // returns 2, 3, 4, 5
		assertEquals(4, l.size());
		l.removeFirst(); // returns 3, 4, 5
		assertEquals(3, l.size());
		l.removeFirst(); // returns 4, 5
		assertEquals(2, l.size());
		l.removeFirst(); // returns 4,
		assertEquals(1, l.size());
		l.removeFirst(); // returns empty list
		assertEquals(0, l.size());
		l.removeFirst();

	}

	@Test(expected = IllegalStateException.class)
	public void testRemoveLastEmpty() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.removeLast();
	}

	@Test(expected = IllegalStateException.class)
	public void testRemoveLastNotEmpty() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.insertAt(0, new Integer(5));
		l.insertAt(0, new Integer(4));
		l.insertAt(0, new Integer(3));
		l.insertAt(0, new Integer(2));
		l.insertAt(0, new Integer(1));
		assertEquals(5, l.size());
		assertTrue(5 == l.removeLast()); // returns 1, 2, 3, 4
		assertEquals(4, l.size());
		assertTrue(4 == l.removeLast());// returns 1, 2, 3
		assertEquals(3, l.size());
		assertTrue(3 == l.removeLast()); // returns 1, 2
		assertEquals(2, l.size());
		assertTrue(2 == l.removeLast()); // returns 1
		assertEquals(1, l.size());
		assertTrue(1 == l.removeLast()); // returns empty list
		assertEquals(0, l.size());
		l.removeLast();

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveAtEmpty() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.removeAt(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveAtIndexGreaterSize() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.insertAt(0, new Integer(5));
		l.insertAt(0, new Integer(4));
		l.insertAt(0, new Integer(3));
		l.insertAt(0, new Integer(2));
		l.insertAt(0, new Integer(1));
		assertEquals(5, l.size());
		l.removeAt(5);
	}

	@Test
	public void testRemoveAtIndexProper() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.insertAt(0, new Integer(5));
		l.insertAt(0, new Integer(4));
		l.insertAt(0, new Integer(3));
		l.insertAt(0, new Integer(2));
		l.insertAt(0, new Integer(1));
		assertTrue(l.removeAt(2) == 3); // returns 1, 2, 4, 5
		assertEquals(4, l.size());
		assertTrue(l.removeAt(0) == 1); // returns 2, 4, 5
		assertEquals(3, l.size());
		assertTrue(l.removeAt(2) == 5); // returns 2, 4
		assertEquals(2, l.size());
		assertTrue(l.removeAt(0) == 2); // returns 2, 4
		assertEquals(1, l.size());
		assertTrue(l.removeAt(0) == 4); // returns 4
		assertEquals(0, l.size());
	}

	@Test(expected = IllegalStateException.class)
	public void testGetFirstEmpty() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.getFirst();
	}

	@Test(expected = IllegalStateException.class)
	public void testGetLastEmpty() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.getLast();
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetAtIndex() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.insertFirst(new Integer(5));
		l.insertFirst(new Integer(4));
		l.insertFirst(new Integer(3));
		l.insertFirst(new Integer(2));
		l.insertFirst(new Integer(1));
		assertTrue(1 == l.get(0));
		assertTrue(2 == l.get(1));
		assertTrue(2 == l.get(1));
		assertTrue(3 == l.get(2));
		assertTrue(4 == l.get(3));
		assertTrue(5 == l.get(4));
		ListInterface<Integer> l2 = new RecursiveList<Integer>();
		l2.get(-1);
		l2.insertFirst(new Integer(3));
		assertTrue(l2.get(0) == 3);
		l.get(5);
	}

	@Test(expected = NullPointerException.class)
	public void testRemove() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.insertLast(new Integer(1));
		l.insertLast(new Integer(2));
		l.insertLast(new Integer(3));
		l.insertLast(new Integer(4));
		l.insertLast(new Integer(4));
		l.insertLast(new Integer(6));
		l.insertLast(new Integer(3));
		assertTrue(l.remove(4));
		assertEquals(6, l.size());
		assertTrue(l.remove(1));
		assertEquals(5, l.size());
		assertTrue(l.remove(2));
		assertEquals(4, l.size());
		assertTrue(l.remove(3));
		assertEquals(3, l.size());
		assertTrue(l.remove(3));
		assertEquals(2, l.size());
		assertFalse(l.remove(10));
		ListInterface<Integer> l2 = new RecursiveList<Integer>();
		assertFalse(l2.remove(0));
		l.remove(null);
	}

	@Test(expected = IllegalStateException.class)
	public void testExceptionOnEmptyRemoveFirst() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.removeFirst();
	}

	@Test
	public void testRemoveFirstStillRemaining() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.insertAt(0, new Integer(5));
		l.insertAt(1, new Integer(6));
		l.removeFirst();
		assertEquals(1, l.size());
		l.removeFirst();
		l.insertAt(0, new Integer(6));
		l.removeAt(0);
		assertTrue(l.isEmpty());
	}

	@Test(expected = IllegalStateException.class)
	public void testExceptionOnEmptyGetLast() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		l.getLast();
	}

	@Test
	public void testInsertsGetsRemovesSize() {
		ListInterface<Integer> l = new RecursiveList<Integer>();
		assertEquals(0, l.size());
		l.insertAt(0, new Integer(5));
		assertEquals(1, l.size());
		l.removeAt(0);
		assertEquals(0, l.size());
		l.insertFirst(new Integer(5));
		assertEquals(1, l.size());
		l.removeFirst();
		assertEquals(0, l.size());
		l.insertLast(new Integer(5));
		assertEquals(1, l.size());
		l.removeLast();
		assertEquals(0, l.size());
	}
}
