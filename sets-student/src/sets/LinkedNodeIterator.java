package sets;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedNodeIterator<E> implements Iterator<E> {
	private LinkedNode<E> log;

	public LinkedNodeIterator(LinkedNode<E> head) {
		this.log = head;
	}

	@Override
	public boolean hasNext() {
		return log != null;
	}

	@Override
	public E next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		E info = log.getData();
		log = log.getNext();
		return info;

	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
