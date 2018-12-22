
class MaxHeap<T extends Comparable<T>> {
	private T[] heap = null; // array storing heap elements
	private int size = 0; // number of elements

	public void set(int index, T value) {
		// TODO A: set the value of a heap element
		if (index < 0 || index >= size)
			return;
		if (value.compareTo(heap[index]) > 0) {
			heap[index] = value;
			bubbleUp(index);
		}
		if (value.compareTo(heap[index]) < 0) {
			heap[index] = value;
			bubbleDown(index);
		}
	}

	public void bubbleUp(int index) {
		T elem = heap[index];
		int parent = (index - 1) / 2;
		if (index > 0 && elem.compareTo(heap[parent]) > 0) {
			heap[index] = heap[parent];
			heap[parent] = elem;
			bubbleUp(parent);
		}
	}

	public void bubbleDown(int index) {
		if (index >= size / 2)
			return;
		int left = 2 * index + 1, right = 2 * index + 2, larger;
		if (heap[left] == null)
			larger = -1;
		if (heap[right] == null)
			larger = 1;
		else
			larger = heap[left].compareTo(heap[right]);
		T elem = heap[index];
		if ((heap[left] != null && elem.compareTo(heap[left]) >= 0) && heap[right] != null
				&& elem.compareTo(heap[right]) >= 0)
			return;
		if (right < size && larger < 0) {
			heap[index] = heap[right];
			heap[right] = elem;
			bubbleDown(right);
		}
		if (left < size && larger > 0) {
			heap[index] = heap[left];
			heap[left] = elem;
			bubbleDown(left);
		}
	}

	// ==========================================
	// The methods below are provided for testing
	// purpose. You do NOT need to modify any of
	// them. Feel free to add your own tests.
	// ==========================================
	@SuppressWarnings("unchecked")
	public MaxHeap(int cap) { // constructor
		heap = (T[]) new Comparable[cap];
	}

	public void enqueue(T e) {
		// For now we'll just assume the capacity is
		// large enough so no need to expand array.
		heap[size++] = e;
		bubbleUp(size - 1);
	}

	public T dequeue() {
		if (size == 0)
			return null;
		T root = heap[0];
		heap[0] = heap[--size];
		bubbleDown(0);
		return root;
	}

	public void print() {
		for (int i = 0; i < size; i++)
			System.out.print(heap[i] + " ");
		System.out.println();
	}
}
