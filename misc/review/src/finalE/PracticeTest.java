package finalE;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class PracticeTest extends Practice<Integer> {
	@Test
	public void testIterativeBinSearch() {
		Integer[] a = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		assertEquals(4, binarySearchIterative(5, a));
		assertEquals(-1, binarySearchIterative(10, a));
	}

	@Test
	public void testRecursiveBinSearch() {
		Integer[] a = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		assertEquals(4, binarySearchRecursive(0, a.length - 1, 5, a));
		assertEquals(-1, binarySearchRecursive(0, a.length - 1, 10, a));
	}

	@Test
	public void testSuccessorBST() {
		Integer[] a = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BSTNode<Integer> bst = sortedToBST(a, 0, a.length - 1);
		BSTNode<Integer> successor = findSuccessor(bst.left.left, bst);
		assertTrue(2 == successor.data);
	}

	@Test
	public void testSuccessorBSTRec() {
		Integer[] a = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BSTNode<Integer> bst = sortedToBST(a, 0, a.length - 1);
		BSTNode<Integer> successor = inorderSuccessor(bst, bst.left.left, null);
		assertTrue(2 == successor.data);
	}

	@Test
	public void testPredecessorBSTRecAndSearch() {
		Integer[] a = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BSTNode<Integer> bst = sortedToBST(a, 0, a.length - 1);
		BSTNode<Integer> successor = inorderSuccessor(bst, bst.left.right.right, null);
		assertTrue(5 == successor.data);
		assertTrue(search(7, bst));
		assertTrue(recSearch(5, bst));
	}

	@Test
	public void testPrintLeaves() {
		Integer[] a = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BSTNode<Integer> bst = sortedToBST(a, 0, a.length - 1);
		printLeaves(bst);
		System.out.println();
		System.out.println(sumLeaves(bst));
	}

	@Test
	public void testBubbleSort() {
		Integer[] a = new Integer[] { 5, 3, 1, 2, 8 };
		bubbleSortIterative(a);
		System.out.print(Arrays.toString(a));
		a = new Integer[] { 5, 3, 1, 2, 8 };
		recBubbleSort(a, a.length);
		System.out.print(Arrays.toString(a));
	}

	@Test
	public void testSelectionSort() {
		Integer[] a = new Integer[] { 5, 3, 1, 2, 8 };
		selectionSort(a);
		System.out.print(Arrays.toString(a));
	}

	@Test
	public void testInsertionSort() {
		Integer[] a = new Integer[] { 5, 3, 1, 2, 8 };
		selectionSort(a);
		System.out.print(Arrays.toString(a));
	}

	@Test
	public void testHeight() {
		Integer[] a = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BSTNode<Integer> bst = sortedToBST(a, 0, a.length - 1);
		findHeight(bst);
		System.out.println(alternateHeight(bst));
		findKthElement(bst, 6);
		hasPathSum(bst, 18);
	}

	// @Test
	// public void testBSTtoArray() {
	// Integer[] a = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, b = new
	// Integer[a.length];
	// BSTNode<Integer> bst = sortedToBST(a, 0, a.length - 1);
	// // AddToArray(bst, b, 0);
	// // Arrays.toString(b);
	// }

}
