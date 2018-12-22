import java.util.NoSuchElementException;

public class LinkedDeque<T> implements Deque<T> {

	private DLNode<T> head;
	private DLNode<T> tail;

	@Override
	public void addToFront(T element) {
		head = new DLNode<T>(element, head, null);
		if (head.next == null) {
			tail = head;
		} else {
			head.next.prev = head;
		}
	}

	@Override
	public T removeFront() throws NoSuchElementException {

		T data = this.first();

		if (head.next != null) {
			head = head.next;
			head.prev = null;
		} else {
			head = null;
			tail = null;
		}
		return data;
	}

	@Override
	public T first() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.data;
	}

	@Override
	public void addToRear(T element) {
		tail = new DLNode<T>(element, null, tail);

		if (tail.prev == null) {
			head = tail;
		} else {
			tail.prev.next = tail;
		}
	}

	@Override
	public T removeRear() throws NoSuchElementException {

		T data = this.last();

		if (tail.prev != null) {
			tail = tail.prev;
			tail.next = null;
		} else {
			head = null;
			tail = null;
		}

		return data;
	}

	@Override
	public T last() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return tail.data;
	}

	public String toString() {
		DLNode<T> node = head;
		String retstr = "";
		while (node != null) {
			retstr += " " + node.data;
			node = node.next;
		}

		return retstr;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

}