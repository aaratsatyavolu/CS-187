package midterm2;

public class BST<T extends Comparable<T>> {
	public BSTNode<T> root;

	public BST(BSTNode<T> root) {
		this.root = root;
	}

	public BST() {
		this(null);
	}

	public BSTNode<T> balance(int lower, int upper, T[] array) {
		if (lower > upper)
			return null;
		int mid = (upper + lower) / 2;
		BSTNode<T> node = new BSTNode<T>(array[mid]);
		node.left = balance(lower, mid - 1, array);
		node.right = balance(mid + 1, upper, array);
		return node;
	}

}
