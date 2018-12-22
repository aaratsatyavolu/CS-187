package structures;

import java.util.NoSuchElementException;

/**************************************************************************************
 * NOTE: before starting to code, check
 * support/structures/UnboundedQueueInterface.java for detailed explanation of
 * each interface method, including the parameters, return values, assumptions,
 * and requirements
 ***************************************************************************************/
public class Queue<T> implements UnboundedQueueInterface<T> { // array-based queue

	private int size;
	private Node<T> head, tail;

	public Queue() {
	}

	public Queue(Queue<T> other) {
		
		Node<T> node = other.head;
		while (node != null) {
			this.enqueue(node.data);
			node = node.next;
		}
		this.size = other.size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void enqueue(T element) {
		Node<T> e = new Node<T>(element, null);
		this.size++;

		if (isEmpty())
			head = e;
		else
			tail.next = e;
		tail = e;

	}

	@Override
	public T dequeue() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException();
		T e = head.data;
		head = head.next;
		size--;
		return e;
	}

	@Override
	public T peek() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException();
		return head.data;
	}

	public String toString() {
		String retstr = "";
		Node<T> node = head;
		while (node != null) {
			retstr += " " + node.data;
			node = node.next;
		}

		return retstr;
	}

	@Override
	public UnboundedQueueInterface<T> reversed() {

		Queue<T> retQ = new Queue<T>();

		Node<T> node = head;
		while (node != null) {
			Node<T> e = new Node<T>(node.data, null);
			if (retQ.head == null)
				retQ.tail = e;
			e.next = retQ.head;
			retQ.head = e;
			retQ.size++;
			node = node.next;
		}
		return retQ;
	}

	@SuppressWarnings("hiding")
	class Node<T> {
		public T data;
		public Node<T> next;

		public Node(T data) {
			this.data = data;
		}

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
}
