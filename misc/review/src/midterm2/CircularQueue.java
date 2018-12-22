package midterm2;

public class CircularQueue<T> implements QueueInterface<T> {
	protected final static int DEFCAP = 100;
	protected T[] queue;
	protected int front, rear;
	protected int numElements;

	@SuppressWarnings("unchecked")
	public CircularQueue(int capacity) {
		queue = (T[]) new Object[capacity];
		this.front = 0;
		this.rear = capacity - 1;
	}

	public CircularQueue() {
		this(DEFCAP);
	}

	@Override
	public T dequeue() throws Exception {
		if (isEmpty())
			throw new Exception("Queue is empty!");
		T data = queue[front];
		queue[front] = null;
		front = (front + 1) % queue.length;
		numElements--;
		return data;
	}

	@Override
	public void enqueue(T e) throws Exception {
		if (isFull())
			throw new Exception("Queue is full!");
		rear = (rear + 1) % queue.length;
		queue[rear] = e;
		numElements++;
	}

	@Override
	public boolean isEmpty() {
		return numElements == 0;
	}

	@Override
	public boolean isFull() {
		return numElements == queue.length;
	}

}
