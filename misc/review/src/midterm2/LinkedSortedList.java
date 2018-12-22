package midterm2;

import midterm1.LLNode;

public class LinkedSortedList<T extends Comparable<T>> {

	public LLNode<T> head;
	private int numElements;

	public LinkedSortedList() {
		head = null;
	}

	public findVal<T> find(T elem) {
		LLNode<T> curr = head, prev = null;

		while (curr != null) {
			if (curr.getContents().equals(elem))
				break;
			else {
				prev = curr;
				curr = curr.getNext();
			}
		}

		return new findVal<T>(curr, prev);
	}

	public findVal<T> findIndex(int index) {
		int i = 0;
		LLNode<T> curr = head, prev = null;
		while (curr != null && i != index) {
			prev = curr;
			curr = curr.getNext();
			i++;
		}
		return new findVal<T>(curr, prev);
	}

	public LLNode<T> findCurrOnly(T elem) {
		LLNode<T> curr = head;
		while (curr != null) {
			if (curr.getContents().equals(elem))
				return curr;
			curr = curr.getNext();
		}
		return null;
	}

	public findVal<T> findSort(T elem) {
		LLNode<T> curr = head, prev = null;

		while (curr != null) {
			if (curr.getContents().compareTo(elem) < 0) {
				prev = curr;
				curr = curr.getNext();
			} else
				break;
		}
		return new findVal<T>(curr, prev);
	}

	public boolean remove(T element) {
		findVal<T> fval = find(element);
		if (fval.curr != null) {
			if (fval.prev == null) // node to remove is head
				head = head.getNext();
			else
				fval.prev.setNext(fval.curr.getNext());
			numElements--;
		}
		return (fval.curr != null);
	}

	public boolean removeOther(T element) {
		LLNode<T> curr = findCurrOnly(element);
		if (curr != null) {
			LLNode<T> next = curr.getNext();
			if (next != null) {
				curr.setContents((next.getContents()));
				curr.setNext(next.getNext());
			} else
				curr.setNext(null);
			numElements--;
		}
		return curr != null;
	}

	public boolean insert(int index, T element) {

		LLNode<T> newNode = new LLNode<T>(element, null);
		findVal<T> f = findIndex(index);
		if (f.curr != null) {
			if (f.prev == null) {
				newNode.setNext(head);
				head = newNode;
			} else {
				newNode.setNext(f.curr);
				f.prev.setNext(newNode);
			}
		}
		numElements++;

		return false;
	}

	public boolean set(int index, T element) {
		findVal<T> f = findIndex(index);
		f.curr.setContents(element);
		return f.curr != null;
	}

	public T get(int index) {
		findVal<T> f = findIndex(index);
		return f.curr.getContents();
	}

	public int indexOf(T element) {

		LLNode<T> curr = head;
		int i = 0;

		while (curr != null) {
			if (curr.getContents().equals(element))
				return i;
			else
				curr = curr.getNext();
		}

		return -1;
	}

	public T remove(int index) {
		findVal<T> f = findIndex(index);
		if (f.curr != null) {
			if (f.prev == null)
				head = head.getNext();
			else {
				f.prev.setNext(f.curr.getNext());
			}
			numElements--;
		}
		return null;
	}
}
