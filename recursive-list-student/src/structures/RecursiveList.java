package structures;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {

	private int size;
	private LLNode<T> head, tail;

	@Override
	public Iterator<T> iterator() {
		return new RecursiveListIterator<T>(this.head);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ListInterface<T> insertFirst(T elem) {
		if (elem == null)
			throw new NullPointerException();
		LLNode<T> node = new LLNode<T>(elem, head);
		head = node;
		if (tail == null)
			tail = head;
		size++;
		return this;
	}

	@Override
	public ListInterface<T> insertLast(T elem) {
		if (elem == null)
			throw new NullPointerException();
		LLNode<T> node = new LLNode<T>(elem);
		if (isEmpty()) {
			return insertFirst(elem);
		} else {
			tail.link = node;
			tail = node;
			size++;
		}
		return this;
	}

	@Override
	public ListInterface<T> insertAt(int index, T elem) {
		if (elem == null)
			throw new NullPointerException();
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		if (index == 0)
			return insertFirst(elem);
		if (index == size)
			return insertLast(elem);
		else {
			LLNode<T> node = new LLNode<T>(elem), beforeNode = indexBeforeNode(index, 0, head);
			node.link = beforeNode.link;
			beforeNode.link = node;
			size++;
		}
		return this;
	}

	@Override
	public T removeFirst() {
		T data = this.getFirst();
		head = head.link;
		size--;
		return data;
	}

	@Override
	public T removeLast() {
		T data = this.getLast();
		if (size == 1)
			return removeFirst();
		else {
			LLNode<T> newTail = indexBeforeNode(size - 1, 0, head);
			newTail.link = null;
			tail = newTail;
			size--;
		}
		return data;
	}

	@Override
	public T removeAt(int i) {
		T data;
		if (i < 0 || i >= size)
			throw new IndexOutOfBoundsException();
		if (i == 0)
			return removeFirst();
		if (i == this.size - 1)
			return removeLast();
		else {
			LLNode<T> node = indexBeforeNode(i, 0, head);
			data = node.link.info;
			node.link = node.link.link;
			size--;
		}
		return data;
	}

	@Override
	public T getFirst() {
		if (isEmpty())
			throw new IllegalStateException();
		return head.info;
	}

	@Override
	public T getLast() {
		if (isEmpty())
			throw new IllegalStateException();
		return tail.info;

	}

	@Override
	public T get(int i) {
		if (i < 0 || i >= size)
			throw new IndexOutOfBoundsException();
		if (i == 0)
			return getFirst();
		if (i == size - 1)
			return getLast();
		else {
			return indexBeforeNode(i, 0, head).link.info;
		}
	}

	@Override
	public boolean remove(T elem) {
		if (elem == null)
			throw new NullPointerException();
		int index = indexOf(elem, 0, head);
		if (index >= 0) {
			removeAt(index);
			return true;
		}
		return false;
	}

	@Override
	public int indexOf(T elem) {
		return indexOf(elem, 0, head);
	}

	// finds the first index of the desired element
	private int indexOf(T elem, int currIndex, LLNode<T> currNode) {
		if (elem == null)
			throw new NullPointerException();
		if (currNode == null)
			return -1;
		if (currNode.info.equals(elem))
			return currIndex;
		else
			return indexOf(elem, currIndex + 1, currNode.link);
	}

	// finds the node before the target
	private LLNode<T> indexBeforeNode(int targetIndex, int currIndex, LLNode<T> currNode) {
		if (currIndex == targetIndex - 1) {
			return currNode;
		}
		return indexBeforeNode(targetIndex, ++currIndex, currNode.link);
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
}
