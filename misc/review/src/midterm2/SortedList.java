package midterm2;

public class SortedList<T> extends UnsortedList<T> {
	@SuppressWarnings("unchecked")
	public void add(T elem) { // must preserve sorted order
		int location = 0;
		if (numElements == list.length)
			enlarge();
		while (location < numElements) {
			if (((Comparable<T>) list[location]).compareTo(elem) < 0)
				location++;
			else
				break;
		}
		for (int index = numElements; index > location; index--)
			list[index] = list[index - 1];
		list[location] = elem;
		numElements++;
	}
}
