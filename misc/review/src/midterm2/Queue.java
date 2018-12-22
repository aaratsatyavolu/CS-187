package midterm2;

import midterm1.LLNode;

public class Queue<T> implements QueueInterface<T> {

	private LLNode<T> front, rear;
	private int size, bound;

	public Queue() { // unbounded
		front = null;
		rear = null;
		size = 0;
		bound = -1;
	}

	public Queue(int bound) {
		this();
		this.bound = bound;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == bound;
	}

	@Override
	public T dequeue() throws Exception {
		if (isEmpty())
			throw new Exception("Queue is empty");
		T data = front.getContents();
		front = front.getNext();
		if (front == null)
			rear = null;
		size--;
		return data;
	}

	@Override
	public void enqueue(T e) throws Exception {
		if (isFull())
			throw new Exception("Queue is full");
		LLNode<T> node = new LLNode<T>(e, null);
		if (isEmpty())
			front = node;
		else
			rear.setNext(node);
		rear = node;
		size++;
	}
}
