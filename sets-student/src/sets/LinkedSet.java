package sets;

import java.util.Iterator;

/**
 * A LinkedList-based implementation of Set
 */

/********************************************************
 * NOTE: Before you start, check the Set interface in
 * Set.java for detailed description of each method.
 *******************************************************/

/********************************************************
 * NOTE: for this project you must use linked lists
 * implemented by yourself. You are NOT ALLOWED to use
 * Java arrays of any type, or any Collection-based class 
 * such as ArrayList, Vector etc. You will receive a 0
 * if you use any of them.
 *******************************************************/

/********************************************************
 * NOTE: you are allowed to add new methods if necessary, but do NOT add new
 * files (as they will be ignored).
 *******************************************************/

public class LinkedSet<E> implements Set<E> {
	private LinkedNode<E> head = null;

	// Constructors
	public LinkedSet() {
		this.head = null;
	}

	public LinkedSet(E e) {
		this.head = new LinkedNode<E>(e, null);
	}

	private LinkedSet(LinkedNode<E> head) {
		this.head = head;
	}

	@Override
	public int size() {
		int count = 0;
		for (@SuppressWarnings("unused")
		E element : this) {
			count++;
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedNodeIterator<E>(this.head);
	}

	@Override
	public boolean contains(Object o) {
		for (E element : this) {
			if (element.equals(o))
				return true;
		}
		return false;
	}

	@Override
	public boolean isSubset(Set<E> that) {
		for (E element : this) {
			if (!that.contains(element))
				return false;
		}
		return true;
	}

	@Override
	public boolean isSuperset(Set<E> that) {
		return that.isSubset(this);
	}

	@Override
	public Set<E> adjoin(E e) {
		LinkedNode<E> newNode = new LinkedNode<E>(e, head);
		return new LinkedSet<E>(newNode);
	}

	@Override
	public Set<E> union(Set<E> that) {

		Set<E> union = that.subtract(this);
		Set<E> retSet = new LinkedSet<E>();

		for (E element : this) {
			retSet = retSet.adjoin(element);
		}
		for (E element : union) {
			retSet = retSet.adjoin(element);
		}
		return retSet;
	}

	@Override
	public Set<E> intersect(Set<E> that) {
		Set<E> inter = new LinkedSet<E>();
		for (E element : this) {
			if (that.contains(element))
				inter = inter.adjoin(element);
		}
		return inter;
	}

	@Override
	public Set<E> subtract(Set<E> that) {
		LinkedSet<E> diff = new LinkedSet<E>();
		for (E element : this) {
			if (that.contains(element))
				continue;
			LinkedNode<E> newNode = new LinkedNode<E>(element, diff.head);
			diff.head = newNode;
		}
		return diff;
	}

	@Override
	public Set<E> remove(E e) {
		return this.subtract(new LinkedSet<E>(e));
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		if (!(o instanceof Set)) {
			return false;
		}
		Set<E> that = (Set<E>) o;
		return this.isSubset(that) && that.isSubset(this);
	}

	@Override
	public int hashCode() {
		int result = 0;
		for (E e : this) {
			result += e.hashCode();
		}
		return result;
	}

	public String toString() {
		String retString = "";
		for (E element : this) {
			retString += element + ", ";
		}
		return retString;
	}

}
