package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RecursiveListIterator<T> implements Iterator<T> {

	private LLNode<T> head;

	public RecursiveListIterator(LLNode<T> node) {
		this.head = node;
	}

	@Override
	public boolean hasNext() {
		return head != null;
	}

	@Override
	public T next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		T info = head.info;
		head = head.link;
		return info;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
