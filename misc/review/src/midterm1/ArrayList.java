package midterm1;

public class ArrayList<T> {
	private int maxIndex = -1;
	private T[] log;

	@SuppressWarnings("unchecked")
	public ArrayList(int size) {
		this.log = (T[]) new Object[size];
	}

	public ArrayList() {
		this(10);
	}

	public void insert(T element) {
		log[++maxIndex] = element;
	}

	public boolean isFull() {
		return maxIndex + 1 == log.length;
	}

	public boolean contains(T element) {
		for (int i = 0; i <= maxIndex; i++) {
			if (log[i].equals(element))
				return true;
		}
		return false;
	}

	public int size() {
		return maxIndex + 1;
	}

	public void clear() {
		for (int i = 0; i <= maxIndex; i++) {
			log[i] = null;
		}
		maxIndex = -1;
	}

	public void recursiveClear() {
		if (maxIndex != -1) {
			log[maxIndex] = null;
			maxIndex--;
			recursiveClear();
		}
	}

	public String toString() {
		String retString = "";
		for (int i = 0; i <= maxIndex; i++) {
			retString += log[i];
		}
		return retString;
	}

}
