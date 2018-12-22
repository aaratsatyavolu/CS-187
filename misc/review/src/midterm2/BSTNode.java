package midterm2;

public class BSTNode<T extends Comparable<T>> {
	protected T info; // info stored in a node
	protected BSTNode<T> left; // link to the left child
	protected BSTNode<T> right; // link to the right child

	public BSTNode(T info) {
		this.info = info;
		left = null;
		right = null;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public BSTNode<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}

	public BSTNode<T> getRight() {
		return right;
	}

	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
}