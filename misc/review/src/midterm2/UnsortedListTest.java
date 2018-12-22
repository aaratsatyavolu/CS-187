package midterm2;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UnsortedListTest {
	@Test
	public void testListU() {
		UnsortedList<Integer> list = new UnsortedList<Integer>(3);
		list.add(new Integer(5));
		list.add(new Integer(6));
		list.add(new Integer(7));
		assertEquals(new Integer(5), list.get(0));
		assertEquals(new Integer(6), list.get(1));
		assertEquals(new Integer(7), list.get(2));
		assertEquals(1, list.indexOf(6));
		assertEquals(0, list.indexOf(5));
		assertEquals(2, list.indexOf(7));
		list.add(new Integer(10));
		list.add(new Integer(11));
		list.add(new Integer(12));
		System.out.println(Arrays.toString(list.list));
		list.remove(2);
		assertEquals(1, list.indexOf(6));
		assertEquals(0, list.indexOf(5));
		assertEquals(2, list.indexOf(10));
		System.out.println(list.getSize());
		System.out.println(list.size());
		list.remove(new Integer(10));
		System.out.println(list.size());
		list.remove(new Integer(6));
		list.remove(0);
		assertTrue(list.numElements == 2);
		System.out.println(Arrays.toString(list.list));
		
	}
	
	@Test
	public void removeFullList() {
		UnsortedList<Integer> list = new UnsortedList<Integer>(3);
		list.add(new Integer(5));
		list.add(new Integer(6));
		list.add(new Integer(7));
		list.remove(new Integer(7));
		System.out.println(Arrays.toString(list.list));
	}
}
