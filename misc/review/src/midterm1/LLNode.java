package midterm1;

public class LLNode<T> {
	private LLNode<T> next;
	private T contents;

	public void setContents(T x) {
		contents = x;
	}

	public T getContents() {
		return contents;
	}

	public void setNext(LLNode<T> t) {
		next = t;
	}

	public LLNode<T> getNext() {
		return next;
	}

	public LLNode(T x, LLNode<T> s) {
		contents = x;
		next = s;
	}
}
