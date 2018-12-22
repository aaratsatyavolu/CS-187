package finalE;

import java.util.ArrayList;
import java.util.Stack;

public class Practice<T extends Comparable<T>> {
	public int binarySearchIterative(T elem, T[] a) { // array
		int low = 0, high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (elem.compareTo(a[mid]) > 0) {
				low = mid + 1;
			} else if (elem.compareTo(a[mid]) < 0) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public int binarySearchRecursive(int low, int high, T elem, T[] a) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (a[mid].compareTo(elem) < 0)
			return binarySearchRecursive(mid + 1, high, elem, a);
		if (a[mid].compareTo(elem) > 0)
			return binarySearchRecursive(low, mid - 1, elem, a);
		return mid;
	}

	public BSTNode<T> sortedToBST(T[] a, int low, int high) {
		if (low > high)
			return null;
		int mid = (low + high) / 2;
		BSTNode<T> node = new BSTNode<T>(a[mid]);
		node.left = sortedToBST(a, low, mid - 1);
		node.right = sortedToBST(a, mid + 1, high);
		return node;
	}

	public ArrayList<T> in_order(BSTNode<T> node, ArrayList<T> list) {
		if (node != null) {
			in_order(node.left, list);
			list.add(node.data);
			in_order(node.right, list);
		}
		return list;
	}

	public BSTNode<T> findSuccessor(BSTNode<T> node, BSTNode<T> root) {
		if (node == null || root == null)
			return null;
		if (node.right != null) {
			node = node.right;
			while (node.left != null)
				node = node.left;
			return node;
		} else {
			BSTNode<T> lastLeft = null;
			while (root != null) {
				if (root.data.compareTo(node.data) > 0) {
					lastLeft = root;
					root = root.left;
				} else if (root.data.compareTo(node.data) < 0)
					root = root.right;
				else
					return lastLeft;
			}
		}
		return null;
	}

	public BSTNode<T> inorderSuccessor(BSTNode<T> root, BSTNode<T> t, BSTNode<T> successor) {
		if (root == null)
			return null;
		int cmp = t.data.compareTo(root.data);
		if (cmp == 0) {
			if (root.right != null)
				return findMin(root.right);
			else
				return successor;
		}
		if (cmp < 0)
			return inorderSuccessor(root.left, t, root);
		return inorderSuccessor(root.right, t, successor);
	}

	public BSTNode<T> inorderPredecessor(BSTNode<T> root, BSTNode<T> t, BSTNode<T> predecessor) {

		if (root == null)
			return null;
		int cmp = t.data.compareTo(root.data);
		if (cmp == 0) {
			if (root.left != null)
				return findMax(root.left);
			else
				return predecessor;
		}
		if (cmp < 0)
			return inorderSuccessor(root.left, t, predecessor);
		return inorderSuccessor(root.right, t, root);
	}

	public BSTNode<T> findMin(BSTNode<T> t) {
		if (t == null)
			return t;
		while (t.left != null)
			t = t.left;
		return t;
	}

	public BSTNode<T> findMax(BSTNode<T> t) {
		if (t == null)
			return t;
		while (t.right != null)
			t = t.right;
		return t;
	}

	public boolean search(T elem, BSTNode<T> node) {
		while (node != null) {
			int comparison = elem.compareTo(node.data);
			if (comparison < 0)
				node = node.left;
			else if (comparison > 0)
				node = node.right;
			else
				return true;
		}
		return false;
	}

	public boolean recSearch(T elem, BSTNode<T> node) {
		if (node == null)
			return false;
		int comparison = elem.compareTo(node.data);
		if (comparison < 0)
			return recSearch(elem, node.left);
		if (comparison > 0)
			return recSearch(elem, node.right);
		return true;
	}

	public void printLeaves(BSTNode<T> node) {
		if (node == null)
			return;
		if (node.left == null && node.right == null)
			System.out.print(node.data);
		printLeaves(node.left);
		printLeaves(node.right);
	}

	public int sumLeaves(BSTNode<Integer> node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return node.data;
		return sumLeaves(node.right) + sumLeaves(node.left);
	}

	public void bubbleSortIterative(T[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j].compareTo(array[j + 1]) > 0)
					swap(j, j + 1, array);
			}
		}
	}

	public void recBubbleSort(T[] array, int size) {
		if (size == 1)
			return;
		for (int i = 0; i < size - 1; i++) {
			if (array[i].compareTo(array[i + 1]) > 0)
				swap(i, i + 1, array);
		}

		recBubbleSort(array, --size);
	}

	public void selectionSort(T[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j].compareTo(array[min]) < 0) {
					min = j;
				}
			}
			swap(i, min, array);
		}
	}

	public void insertionSort(T[] array) {
		if (array.length == 1)
			return;
		for (int i = 1; i < array.length; i++) {
			T temp = array[i];
			int j = i;
			while (j > 0 && array[j - 1].compareTo(temp) > 0) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = temp;
		}
	}

	public void swap(int i, int j, T[] array) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public int findHeight(BSTNode<T> node) {
		if (node == null)
			return -1;
		int lefth = findHeight(node.left);
		int righth = findHeight(node.right);

		if (lefth > righth)
			return 1 + lefth;
		else
			return 1 + righth;
	}

	public int alternateHeight(BSTNode<T> node) {
		if (node == null)
			return -1;
		return 1 + Math.max(alternateHeight(node.left), alternateHeight(node.right));
	}

	public void findKthElement(BSTNode<T> node, int count) {
		if (node == null)
			return;
		Stack<BSTNode<T>> s = new Stack<BSTNode<T>>();
		int tmp = count;
		BSTNode<T> log = node;
		while (log != null || !s.isEmpty()) {
			while (log != null) {
				s.push(log);
				log = log.left;
			}
			log = s.pop();
			tmp--;
			if (tmp == 0) {
				System.out.print(log.data);
				return;
			}
			log = log.right;
		}
	}

	public boolean hasPathSum(BSTNode<Integer> node, int sum) {
		if (node == null)
			return (sum == 0);
		else {
			int subSum = sum - node.data;
			return hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum);
		}
	}

	// public void AddToArray(BSTNode<Integer> node, Integer[] arr, int i) {
	// Stack<BSTNode<Integer>> s = new Stack<BSTNode<Integer>>();
	// while (node != null || !s.isEmpty()) {
	// while (node != null) {
	// arr[i] = node.data;
	// s.push(node);
	// node = node.left;
	// i = i * 2 + 1;
	// }
	//
	// node = s.pop();
	// i = (i - 1) / 2;
	// if (node.right != null) {
	// node = node.right;
	// i = i * 2 + 2;
	// }
	//
	// else
	// node = null;
	// }
	// }
}
