package midterm2;

public class BinarySearch<T> {

	public int binarySearchRec(T elem, int low, int high, T[] array) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		@SuppressWarnings("unchecked")
		int result = ((Comparable<T>) array[mid]).compareTo(elem);

		if (result == 0)
			return mid;
		if (result > 0)
			return binarySearchRec(elem, low, mid - 1, array);
		else
			return binarySearchRec(elem, mid + 1, high, array);
	}

	public int binarySearch(T elem, int low, int high, T[] array) {
		while (low <= high) {
			int curr = (low + high) / 2; // rounds down
			@SuppressWarnings("unchecked")
			int result = ((Comparable<T>) elem).compareTo(array[curr]);
			if (result == 0)
				return curr;
			else if (result < 0)
				high = curr - 1; 
			else
				low = curr + 1;
		}
		return -1;
	}
}
