package finalE;

import java.util.ArrayList;

public class BST<T extends Comparable<T>> {
	public BSTNode<T> root;

	public BST() {
		root = null;
	}

	public BST(BSTNode<T> root) {
		this.root = root;
	}

	public BST(T[] sorted) {
		/* This constructor builds a BST from a sorted array */
		root = sortedArrayToBST(sorted, 0, sorted.length - 1);
	}

	/*
	 * TODO: implement an iterative method (i.e. using a loop) that searches for a
	 * element in the BST. In lecture slides we covered a recursive version. Here
	 * you must implement it using a loop and no recursion. Return null if the
	 * element does not exist; or the node containing the element if it exists.
	 * Remember: for generic type T, you cannot use < or >, instead you must use the
	 * compareTo or equals method.
	 */
	public BSTNode<T> search(T elem) {
		BSTNode<T> node = root;
		while (node != null) {
			if (elem.compareTo(node.data) == 0) {
				return node;
			}
			if (elem.compareTo(node.data) < 0) {
				node = node.left;
			} else
				node = node.right;
			continue;
		}
		return null;

	}

	public T findSuccessor(BSTNode<T> node) {

		return null;
	}

	/*
	 * TODO: implement a method that checks whether this is a valid BST. There are
	 * at least two solutions. You can implement either. You are allowed to use
	 * recursion for this question. If you create any new method, you must include
	 * it in the written document.
	 * 
	 * In the first solution, perform an in-order traversal and save the traversed
	 * elements in a Java ArrayList, then use the ArrayList to help you check
	 * whether this is a valid BST or not (think about how). This solution is easy
	 * to implement but requires O(N) memory.
	 * 
	 * In the second solution, you can avoid using additional memory such as an
	 * ArrayList. Instead, make use of the definition of a BST to implement the
	 * validity checking. Hint: during recursion, you can pass minimum and maximum
	 * values down to the recursive calls to help you track what's the allowed range
	 * of values of the children node. Alternatively, you can have the recursive
	 * method return the minimum and maximum values of each subtree, and use those
	 * values to track the allowed range of values of the the parent.
	 */

	public boolean isValid() {
		ArrayList<T> list = new ArrayList<T>();
		generateInOrder(list, root);
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).compareTo(list.get(i + 1)) > 0)
				return false;
		}
		return true;
	}

	public T findMin(BSTNode<T> node) {
		if (node == null)
			return null;
		if (node.left == null)
			return node.data;
		return findMin(node.left);
	}

	public BSTNode<T> findMinNode(BSTNode<T> node) {
		if (node == null)
			return null;
		if (node.left == null)
			return node;
		return findMinNode(node.left);
	}

	public T findMax(BSTNode<T> node) {
		if (node == null)
			return null;
		if (node.right == null)
			return node.data;
		return findMax(node.right);
	}

	public boolean alternateIsValid() {
		return recCheck(root, findMin(root), findMax(root));
	}

	private boolean recCheck(BSTNode<T> node, T min, T max) {
		if (node == null)
			return true;
		if (node.data.compareTo(min) < 0 || node.data.compareTo(max) > 0)
			return false;
		return (recCheck(node.left, min, node.data) && recCheck(node.right, node.data, max));
	}

	private void generateInOrder(ArrayList<T> list, BSTNode<T> node) {
		if (node == null)
			return;
		generateInOrder(list, node.left);
		list.add(node.data);
		generateInOrder(list, node.right);
	}

	/* -------------------------------------------------- */
	/* YOU DO NOT NEED TO MODIFY ANY CODE BELOW THIS LINE */
	/* -------------------------------------------------- */
	private BSTNode<T> sortedArrayToBST(T array[], int start, int end) {
		if (start > end)
			return null; // if the range has crossed over
		int mid = (start + end) / 2; // find middle element
		BSTNode<T> node = new BSTNode<T>(array[mid]); // construct node
		node.left = sortedArrayToBST(array, start, mid - 1); // recursively build left subtree
		node.right = sortedArrayToBST(array, mid + 1, end); // recursively build right subtree
		return node;
	}

	public int size() {
		return sizeHelper(root);
	}

	private int sizeHelper(BSTNode<T> node) {
		if (node == null)
			return 0;
		return 1 + sizeHelper(node.left) + sizeHelper(node.right);
	}

	public BSTNode<T> findLCA(T x, T y) {
		if (this.root == null || search(x) == null || search(y) == null)
			return null;
		T larger = (x.compareTo(y) > 0) ? x : y;
		BSTNode<T> n = this.root;
		while (n != null) {
			if (n.data.compareTo(larger) > 0) {
				n = n.left;
			}
			if (n.data.compareTo(larger) < 0) {
				n = n.right;
			} else
				return n;
		}
		return n;
	}
}
