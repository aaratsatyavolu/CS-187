package structures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T> {
	protected BSTNode<T> root;

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return subtreeSize(root);
	}

	protected int subtreeSize(BSTNode<T> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + subtreeSize(node.getLeft()) + subtreeSize(node.getRight());
		}
	}

	public boolean contains(T t) {
		if (t == null)
			throw new NullPointerException();
		return t.equals(get(t));
	}

	public boolean remove(T t) {
		if (t == null) {
			throw new NullPointerException();
		}
		boolean result = contains(t);
		if (result) {
			root = removeFromSubtree(root, t);
		}
		return result;
	}

	private BSTNode<T> removeFromSubtree(BSTNode<T> node, T t) {
		// node must not be null
		int result = t.compareTo(node.getData());
		if (result < 0) {
			node.setLeft(removeFromSubtree(node.getLeft(), t));
			if (node.getLeft() != null) {
				node.getLeft().setParent(node);
			}
			return node;
		} else if (result > 0) {
			node.setRight(removeFromSubtree(node.getRight(), t));
			if (node.getRight() != null) {
				node.getRight().setParent(node);
			}
			return node;
		} else { // result == 0
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else { // neither child is null
				T predecessorValue = getHighestValue(node.getLeft());
				node.setLeft(removeRightmost(node.getLeft()));
				if (node.getLeft() != null) {
					node.getLeft().setParent(node);
				}
				node.setData(predecessorValue);
				return node;
			}
		}
	}

	private T getHighestValue(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getData();
		} else {
			return getHighestValue(node.getRight());
		}
	}

	private T getSmallestValue(BSTNode<T> node) {
		if (node.getLeft() == null) {
			return node.getData();
		} else {
			return getSmallestValue(node.getLeft());
		}

	}

	private BSTNode<T> removeRightmost(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getLeft();
		} else {
			node.setRight(removeRightmost(node.getRight()));
			if (node.getRight() != null) {
				node.getRight().setParent(node);
			}
			return node;
		}
	}

	public T get(T t) {
		if (t == null) {
			throw new NullPointerException();
		}
		return recGet(t, root);
	}

	private T recGet(T t, BSTNode<T> node) {
		if (node == null)
			return null;
		else if (t.compareTo(node.getData()) < 0)
			return recGet(t, node.getLeft());
		else if (t.compareTo(node.getData()) > 0)
			return recGet(t, node.getRight());
		else
			return node.getData();
	}

	public void add(T t) {
		if (t == null) {
			throw new NullPointerException();
		}
		root = addToSubtree(root, new BSTNode<T>(t, null, null));
	}

	protected BSTNode<T> addToSubtree(BSTNode<T> node, BSTNode<T> toAdd) {
		if (node == null) {
			return toAdd;
		}
		int result = toAdd.getData().compareTo(node.getData());
		if (result <= 0) {
			node.setLeft(addToSubtree(node.getLeft(), toAdd));
			if (node.getLeft() != null) {
				node.getLeft().setParent(node);
			}
		} else {
			node.setRight(addToSubtree(node.getRight(), toAdd));
			if (node.getRight() != null) {
				node.getRight().setParent(node);
			}
		}
		return node;
	}

	@Override
	public T getMinimum() {
		if (isEmpty())
			return null;
		return getSmallestValue(root);
	}

	@Override
	public T getMaximum() {
		if (isEmpty())
			return null;
		return getHighestValue(root);
	}

	@Override
	public int height() {
		if (isEmpty())
			return -1;
		else
			return maxLevel(root);
	}

	private int maxLevel(BSTNode<T> node) {
		if (node == null)
			return -1;
		else {
			return 1 + Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight()));
		}
	}

	public Iterator<T> preorderIterator() {
		Queue<T> queue = new LinkedList<T>();
		preorderTraverse(queue, root);
		return queue.iterator();
	}

	private void preorderTraverse(Queue<T> queue, BSTNode<T> node) { // implement
		if (node != null) {
			queue.add(node.getData());
			preorderTraverse(queue, node.getLeft());
			preorderTraverse(queue, node.getRight());
		}
	}

	public Iterator<T> inorderIterator() {
		Queue<T> queue = new LinkedList<T>();
		inorderTraverse(queue, root);
		return queue.iterator();
	}

	private void inorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			inorderTraverse(queue, node.getLeft());
			queue.add(node.getData());
			inorderTraverse(queue, node.getRight());
		}
	}

	// public void inorderTraverse(T[] array, BSTNode<T> node, int index) {
	// if (node != null) {
	// inorderTraverse(array, node.getLeft(), index + 1);
	// array[index] = node.getData();
	// inorderTraverse(array, node.getRight(), index + 1);
	// }
	// }

	public Iterator<T> postorderIterator() {
		Queue<T> queue = new LinkedList<T>();
		postorderTraverse(queue, root);
		return queue.iterator();
	}

	private void postorderTraverse(Queue<T> queue, BSTNode<T> node) { // implement
		if (node != null) {
			postorderTraverse(queue, node.getLeft());
			postorderTraverse(queue, node.getRight());
			queue.add(node.getData());
		}
	}

	@Override
	public boolean equals(BSTInterface<T> other) {
		if (other == null)
			throw new NullPointerException();
		return checkEquals(root, other.getRoot());
	}

	private boolean checkEquals(BSTNode<T> node, BSTNode<T> other) {
		if (node == null)
			return node == other;
		if (other == null)
			return node == other;
		else if (node != null && !node.getData().equals(other.getData()))
			return false;
		else
			return checkEquals(node.getLeft(), other.getLeft()) && checkEquals(node.getRight(), other.getRight());

	}

	@Override
	public boolean sameValues(BSTInterface<T> other) {
		if (other == null)
			throw new NullPointerException();
		Iterator<T> i = this.inorderIterator();
		Iterator<T> t = other.inorderIterator();
		while (i.hasNext()) {
			if (!i.next().equals(t.next()))
				return false;
		}
		return true;
	}

	@Override
	public boolean isBalanced() {
		int height = this.height(), size = this.size();
		int leftBound = (int) Math.pow(2, height), rightBound = (int) Math.pow(2, height + 1);
		return (leftBound <= size && size < rightBound);
	}

	public void balance() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size()];
		Iterator<T> iter = inorderIterator();
		for (int i = 0; iter.hasNext(); i++)
			array[i] = iter.next();
		root = sortedArray2BST(0, array.length - 1, array);
	}

	private BSTNode<T> sortedArray2BST(int lower, int upper, T[] array) {
		if (lower > upper)
			return null;
		int mid = (lower + upper) / 2;
		BSTNode<T> node = new BSTNode<T>(array[mid], null, null);
		node.setLeft(sortedArray2BST(lower, mid - 1, array));
		node.setRight(sortedArray2BST(mid + 1, upper, array));
		return node;
	}

	public BSTNode<T> removeLargest(BSTNode<T> node) {
		if (node == null) {
			return null;
		}
		if (node.getRight() != null) {
			node.setRight(removeLargest(node.getRight()));
			return node;
		} else {
			return node.getLeft();
		}
	}

	@Override
	public BSTNode<T> getRoot() {
		// DO NOT MODIFY
		return root;
	}

	public static <T extends Comparable<T>> String toDotFormat(BSTNode<T> root) {
		// header
		int count = 0;
		String dot = "digraph G { \n";
		dot += "graph [ordering=\"out\"]; \n";
		// iterative traversal
		Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
		queue.add(root);
		BSTNode<T> cursor;
		while (!queue.isEmpty()) {
			cursor = queue.remove();
			if (cursor.getLeft() != null) {
				// add edge from cursor to left child
				dot += cursor.getData().toString() + " -> " + cursor.getLeft().getData().toString() + ";\n";
				queue.add(cursor.getLeft());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count + ";\n";
				count++;
			}
			if (cursor.getRight() != null) {
				// add edge from cursor to right child
				dot += cursor.getData().toString() + " -> " + cursor.getRight().getData().toString() + ";\n";
				queue.add(cursor.getRight());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count + ";\n";
				count++;
			}

		}
		dot += "};";
		return dot;
	}

	public static void main(String[] args) {
		for (String r : new String[] { "a", "b", "c", "d", "e", "f", "g" }) {
			BSTInterface<String> tree = new BinarySearchTree<String>();
			for (String s : new String[] { "d", "b", "a", "c", "f", "e", "g" }) {
				tree.add(s);
			}
			Iterator<String> iterator = tree.inorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();
			iterator = tree.preorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();
			iterator = tree.postorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();

			System.out.println(tree.remove(r));

			iterator = tree.inorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();
		}

		BSTInterface<String> tree = new BinarySearchTree<String>(), tree2 = new BinarySearchTree<String>();
		for (String r : new String[] { "b", "c", "a", "g", "e", "g", "f" }) {
			tree.add(r);
			tree2.add(r);
		}
		System.out.println(tree.size());
		System.out.println(tree2.size());
		System.out.println(tree.height());
		System.out.println(tree.isBalanced());
		System.out.println(tree.equals(tree2));
		System.out.println(tree.sameValues(tree2));
		tree.balance();
		System.out.println(tree.size());
		System.out.println(tree.height());
		System.out.println(tree.isBalanced());
		System.out.println(tree.sameValues(tree2));
		tree2.removeLargest(tree2.getRoot());

	}
}