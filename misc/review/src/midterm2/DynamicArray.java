package midterm2;

public class DynamicArray<T> {

	public final static int DEFCAP = 100;
	public T[] array;
	public int rear;

	@SuppressWarnings("unchecked")
	public DynamicArray(int capacity) {
		array = (T[]) new Object[capacity];
		rear = -1;
	}

	public DynamicArray() {
		this(DEFCAP);
	}

	@SuppressWarnings("unchecked")
	public void add(T e) {
		if (rear == array.length - 1) {
			T[] temp = (T[]) new Object[array.length * 2];
			for (int i = 0; i <= rear; i++) {
				temp[i] = array[i];
			}
			array = temp;
		}
		array[++rear] = e;
	}
	
	public int getLength() {
		return this.array.length;
	}
}
