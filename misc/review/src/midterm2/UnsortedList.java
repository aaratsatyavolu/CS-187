package midterm2;

public class UnsortedList<T> implements ListInterface<T> {

	protected final static int DEFCAP = 100;
	protected T[] list;
	protected int numElements = 0;

	@SuppressWarnings("unchecked")
	public UnsortedList(int capacity) {
		list = (T[]) new Object[capacity];
	}

	public UnsortedList() {
		this(DEFCAP);
	}

	@Override
	public int size() {
		return numElements;
	}

	@Override
	public void add(T element) {
		if (numElements == list.length)
			enlarge();
		list[numElements++] = element;
	}

	@Override
	public boolean contains(T element) {
		return indexOf(element) != -1;
	}

	@Override
	public boolean remove(T element) {

		int index = indexOf(element);
		if (index == -1)
			return false;
		if (index != numElements - 1) {
			for (int i = index; i < numElements - 1; i++) {
				list[i] = list[i + 1];
			}
		}
		list[--numElements] = null;
		return true;
	}

	@Override
	public boolean insert(int index, T element) {
		if (index < 0 || index > numElements)
			return false;
		if (numElements == list.length)
			enlarge();
		for (int i = numElements; i > index; i--)
			list[i] = list[i - 1];
		list[index] = element;
		numElements++;
		return false;
	}

	@Override
	public boolean set(int index, T element) {
		if (index < 0 || index > numElements)
			return false;
		list[index] = element;
		return false;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index > numElements)
			return null;
		return list[index];
	}

	@Override
	public int indexOf(T element) {
		if (element == null)
			throw new NullPointerException();
		for (int i = 0; i < numElements; i++) {
			if (list[i].equals(element))
				return i;
		}
		return -1;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= numElements)
			return null;
		T data = list[index];
		for (int i = index; i < numElements - 1; i++) {
			list[i] = list[i + 1];
		}
		list[--numElements] = null;

		return data;
	}

	@SuppressWarnings("unchecked")
	public void enlarge() {
		T[] temp = (T[]) new Object[list.length * 2];
		for (int i = 0; i < numElements; i++) {
			temp[i] = list[i];
		}
		list = temp;
	}

	public int getSize() {
		return list.length;
	}

}
