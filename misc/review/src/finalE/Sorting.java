package finalE;

import midterm1.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import midterm1.LLNode;

public class Sorting {

	public void bubbleSort(List<Integer> list) {
		for (int out = list.size() - 1; out > 0; out--) {
			for (int in = 0; in < out; in++) {
				if (list.get(in).compareTo(list.get(in + 1)) > 0)
					swap(list, in, in + 1);
			}
		}
	}

	public void selectionSort(List<Integer> list) {
		for (int out = list.size() - 1; out > 0; out--) {
			int max = out;
			for (int in = out - 1; in >= 0; in--) {
				if (list.get(in).compareTo(list.get(max)) > 0)
					max = in;
			}
			swap(list, max, out);
		}
	}

	public void insertionSort(List<Integer> list) {
		int out, in;
		for (out = 1; out < list.size(); out++) { // dividing line
			Integer temp = list.get(out);
			in = out; // start shifts at out
			while (in > 0 && list.get(in - 1).compareTo(temp) > 0) {
				list.set(in, list.get(in - 1)); // shift right until the
				in--; // element that’s no longer larger
			}
			list.set(in, temp);
		}
	}

	public ArrayList<Integer> mergeSort(ArrayList<Integer> one, ArrayList<Integer> two) {
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		while (!one.isEmpty() && !two.isEmpty()) {
			if (one.get(0).compareTo(two.get(0)) <= 0) {
				sorted.add(one.get(0));
				one.remove(0);
			} else {
				sorted.add(two.get(0));
				two.remove(0);
			}
		}

		if (one.isEmpty()) {
			sorted.addAll(two);
		} else {
			sorted.addAll(one);
		}

		return sorted;
	}

	public void merge(Integer[] A, Integer[] temp, int low, int mid, int high) {

		int li = low, ri = mid, ti = low;
		while ((li < mid) && (ri <= high)) {
			if (A[li].compareTo(A[ri]) < 0)
				temp[ti++] = A[li++];
			else
				temp[ti++] = A[ri++];
		} // end of loop
		while (li < mid)
			temp[ti++] = A[li++];
		while (ri <= high)
			temp[ti++] = A[ri++];
		for (int i = low; i <= high; i++)

		{
			A[i] = temp[i];
		}
	}

	public void mergeSort(Integer[] a) {
		Integer[] temp = new Integer[a.length];
		recursiveMerge(a, temp, 0, a.length - 1);
	}

	public void recursiveMerge(Integer[] a, Integer[] temp, int low, int high) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;
		recursiveMerge(a, temp, low, mid);
		recursiveMerge(a, temp, mid + 1, high);
		merge(a, temp, low, mid + 1, high);
	}

	public void iterativeMerge(Integer[] a) {
		Integer[] temp = new Integer[a.length];
		for (int k = 1; k < a.length; k = k * 2) {
			for (int i = 0; i < a.length - 1; i += (2 * k)) {
				merge(a, temp, i, i + k, i + k + k - 1);
			}
		}
	}

	public int partition(Integer[] a, int low, int high) {
		int pivot = a[high], storeIndex = low;
		for (int j = low; j < high; j++) {
			if (a[j].compareTo(pivot) <= 0) {
				swap(a, j, storeIndex++);
				// storeIndex++;
			}
		}
		swap(a, high, storeIndex);
		return storeIndex;
	}

	public void quickSort(Integer[] a) {
		recQuickSort(a, 0, a.length - 1);
	}

	public void recQuickSort(Integer[] a, int low, int high) {
		if (low < high) {
			int p = partition(a, low, high);
			recQuickSort(a, low, p - 1);
			recQuickSort(a, p + 1, high);
		}
	}

	public void iterativeQuickSort(Integer[] a) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		s.push(a.length - 1);
		while (!s.isEmpty()) {
			int end = s.pop();
			int start = s.pop();
			if (end - start <= 0) {
				continue;
			}
			int p = partition(a, start, end);
			s.push(p + 1);
			s.push(end);
			s.push(start);
			s.push(p - 1);
		}

	}

	public void swap(List<Integer> list, int a, int b) {
		Integer temp = list.get(b);
		list.set(b, list.get(a));
		list.set(a, temp);
	}

	public void swap(Integer[] list, int a, int b) {
		Integer temp = list[b];
		list[b] = list[a];
		list[a] = temp;
	}

	public LinkedList<Integer> merge(LinkedList<Integer> L1, LinkedList<Integer> L2) {
		LinkedList<Integer> retlist = new LinkedList<Integer>();
		LLNode<Integer> node1 = L1.head, node2 = L2.head;
		while (node1 != null && node2 != null) {
			if (node1.getContents().compareTo(node2.getContents()) <= 0) {
				retlist.addEnd(node1.getContents());
				node1 = node1.getNext();
			} else {
				retlist.addEnd(node2.getContents());
				node2 = node2.getNext();
			}
		}

		while (node1 != null) {
			retlist.addEnd(node1.getContents());
			node1 = node1.getNext();
		}

		while (node2 != null) {
			retlist.addEnd(node2.getContents());
			node2 = node2.getNext();
		}
		return retlist;
	}

	public LLNode<Integer> recMerge(LLNode<Integer> L1, LLNode<Integer> L2) {
		if (L1 == null)
			return L2;
		if (L2 == null) {
			return L1;
		}
		LLNode<Integer> L3 = null;
		if (L1.getContents().compareTo(L2.getContents()) <= 0) {
			L3 = L1;
			L3.setNext(recMerge(L1.getNext(), L2));
		} else {
			L3 = L2;
			L3.setNext(recMerge(L1, L2.getNext()));
		}
		return L3;
	}
}
