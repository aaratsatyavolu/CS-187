package midterm2;

import org.junit.Test;

public class BinarySearchTest extends BinarySearch<Integer> {
	@Test
	public void testBS() {
		Integer[] array = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
		System.out.println(binarySearchRec(11, 0, array.length - 1, array));
	}
}
