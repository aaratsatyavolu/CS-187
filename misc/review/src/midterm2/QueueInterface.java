package midterm2;

public interface QueueInterface<T> {
	T dequeue() throws Exception;

	void enqueue(T e) throws Exception;

	boolean isEmpty();

	boolean isFull();
}
