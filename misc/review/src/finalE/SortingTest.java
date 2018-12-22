package finalE;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import midterm1.LLNode;
import midterm1.LinkedList;

public class SortingTest extends Sorting {

	public List<Integer> list = Arrays.asList(new Integer[] { 13, 1, 5, 10, 7 });
	public ArrayList<Integer> list1, list2;

	@Test
	public void testBubbleSort() {
		list = Arrays.asList(new Integer[] { 13, 1, 5, 10, 7 });
		bubbleSort(list);
		assertEquals(Arrays.asList(new Integer[] { 1, 5, 7, 10, 13 }), list);
	}

	@Test
	public void testSelectionSort() {
		list = Arrays.asList(new Integer[] { 13, 1, 5, 10, 7 });
		selectionSort(list);
		assertEquals(Arrays.asList(new Integer[] { 1, 5, 7, 10, 13 }), list);
	}

	@Test
	public void testInsertionSort() {
		list = Arrays.asList(new Integer[] { 13, 1, 14, 10, 7 });
		List<Integer> list2 = Arrays.asList(new Integer[] { 5, 3, 8, 1, 2 });
		insertionSort(list);
		assertEquals(Arrays.asList(new Integer[] { 1, 7, 10, 13, 14 }), list);
		insertionSort(list2);
	}

	@Test
	public void testMergeSort() {
		list1 = new ArrayList<Integer>(Arrays.asList(new Integer[] { 4, 6, 10, 13 }));
		list2 = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 3, 5, 7, 8 }));
		assertEquals(Arrays.asList(new Integer[] { 1, 3, 4, 5, 6, 7, 8, 10, 13 }), mergeSort(list1, list2));
	}

	@Test
	public void testMerge() {
		Integer[] a = new Integer[] { 1, 4, 6, 1, 3 };
		Integer[] temp = new Integer[a.length];
		merge(a, temp, 0, 3, 4);
		System.out.print(Arrays.toString(a));
	}

	@Test
	public void testRecursiveMerge() {
		Integer[] a = new Integer[] { 38, 27, 43, 3, 9, 82, 10 }, temp = new Integer[a.length];
		recursiveMerge(a, temp, 0, a.length - 1);
		System.out.println(Arrays.asList(a));
	}

	@Test
	public void testIterativeMerge() {
		Integer[] a = new Integer[] { 38, 27, 43, 3, 9, 82, 10, 11 };
		iterativeMerge(a);
		System.out.println(Arrays.asList(a));
	}

	@Test
	public void testPartition() {
		Integer[] a = new Integer[] { 3, 9, 7, 5, 8, 2, 6 };
		partition(a, 0, a.length - 1);
		System.out.print(Arrays.toString(a));
	}

	@Test
	public void quickSort() {
		Integer[] a = new Integer[] { 8, 5, 3, 7, 1, 9, 6 };
		quickSort(a);
		System.out.print(Arrays.toString(a));
	}

	@Test
	public void IterativeQuickSort() {
		Integer[] a = new Integer[] { 8, 5, 3, 7, 1, 9, 6 };
		iterativeQuickSort(a);
		System.out.print(Arrays.toString(a));
	}

	@Test
	public void testLinkedMerge() {
		midterm1.LinkedList<Integer> L1 = new LinkedList<Integer>();
		midterm1.LinkedList<Integer> L2 = new LinkedList<Integer>();
		L1.addEnd(1);
		L1.addEnd(2);
		L1.addEnd(3);
		L1.addEnd(4);
		L2.addEnd(2);
		L2.addEnd(5);
		L2.addEnd(7);
		L2.addEnd(8);
		midterm1.LinkedList<Integer> L3 = merge(L1, L2);
		LLNode<Integer> node3 = L3.head;
		while (node3 != null) {
			System.out.print(node3.getContents() + " ");
			node3 = node3.getNext();
		}

	}

	@Test
	public void testRecListMerge() {
		midterm1.LinkedList<Integer> L1 = new LinkedList<Integer>();
		midterm1.LinkedList<Integer> L2 = new LinkedList<Integer>();
		L1.addEnd(1);
		L1.addEnd(2);
		L1.addEnd(3);
		L1.addEnd(4);
		L2.addEnd(2);
		L2.addEnd(5);
		L2.addEnd(7);
		L2.addEnd(8);
		recMerge(L1.head, L2.head);
	}

}
