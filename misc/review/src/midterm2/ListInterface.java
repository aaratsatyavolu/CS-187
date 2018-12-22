package midterm2;

public interface ListInterface<T> {
	int size();

	// add an element.
	void add(T element);

	// return true if this list contains an element e
	// such that e.equals(element) is true
	boolean contains(T element);

	// remove an element from the list.
	// return true if successful, false if element doesn’t exist
	boolean remove(T element);

	// insert an element at a given index. Higher-indexed
	// elements move up. Return true if successful
	boolean insert(int index, T element);

	// set the element at a given index
	// return true if successful
	boolean set(int index, T element);

	// get the element at a given index
	// return null if element does not exist
	T get(int index);

	// return the index of the first occurrence
	// of the element. -1 if element does not exist.
	int indexOf(T element);

	// remove the element at a specified index.
	T remove(int index);
}
