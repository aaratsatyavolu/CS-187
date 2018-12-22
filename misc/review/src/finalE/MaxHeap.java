package finalE;

public class MaxHeap<T extends Comparable<T>> {

	public T[] array;
	public int size;

	@SuppressWarnings("unchecked")
	public MaxHeap(int capacity) {
		array = (T[]) new Object[capacity];
		size = 0;
	}

	public T get(int index) {
		return array[index];
	}

	public int getLeftChild(int index) {
		if (index < 0)
			return -1;
		return index * 2 + 1;
	}

	public int getRightChild(int index) {
		return index * 2 + 2;
	}

	public int getParent(int index) {
		return (index - 1) / 2;
	}

	public int getSize() {
		return size;
	}

	public void add(T elem) throws Exception {
		if (size == array.length - 1) {
			throw new Exception("heap is full!");
		}
		array[size] = elem;
		size++;
		bubbleUp(size);
	}

	private void bubbleUp(int index) {
		T elem = array[index];
		int parent = getParent(index);
		while (index > 0 && elem.compareTo(array[parent]) < 0) {
			array[index] = array[parent];
			index = parent;
			parent = getParent(index);
		}
		array[index] = elem;
	}

	public void delete(T elem) throws Exception {
		if (size == 0)
			throw new Exception("heap is empty!");
		array[0] = array[size - 1];
		size--;
		bubbleDown(0);
	}

	private void bubbleDown(int index) {
		T elem = array[index];

		int greaterChild = 0;
		while (index < size / 2) {
			int left = getLeftChild(index), right = getRightChild(index);
			if (right < size && array[left].compareTo(array[right]) < 0)
				greaterChild = right;
			else
				greaterChild = left;
			if (elem.compareTo(array[greaterChild]) >= 0)
				break;
			array[index] = array[greaterChild];
			index = greaterChild;
		}
		array[index] = elem;
	}
}
