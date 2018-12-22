package midterm1;

public class LList<T> {
	private LLNode<T> head, tail;
	private int size;

	public LList(LLNode<T> node) {
		this.head = node;
		this.tail = node;
		size++;
	}

	public LList() {
		this(null);
		size--;
	}

	public void frontInsert(T element) {
		LLNode<T> newNode = new LLNode<T>(element, null);
		newNode.setNext(head);
		head = newNode;
		size++;
	}

	public int getSize() {
		return size;
	}

	public void endInsert(T element) {
		LLNode<T> newNode = new LLNode<T>(element, null);
		if (tail == null)
			head = newNode;
		else
			tail.setNext(newNode);
		tail = newNode;
		size++;
	}

	public void reverse() {
		LLNode<T> nHead = null, node = head;
		while (node != null) {
			LLNode<T> newNode = new LLNode<T>(node.getContents(), null);
			if (nHead != null)
				newNode.setNext(nHead);
			nHead = newNode;
			node = node.getNext();

			head = nHead;
		}

	}

	public void reverseRec(LLNode<T> n) {
		if (n == null)
			return;
		if (n.getNext() == null) {
			head = n;
			return;
		}
		reverseRec(n.getNext());
		n.getNext().setNext(n);
		n.setNext(null);

	}

	public void deleteLast() {
		LLNode<T> node = head;
		while (node != null) {
			if (node.getNext().getNext() == null) {
				node.setNext(null);
			}
			node = node.getNext();
		}
	}

	public String toString() {
		LLNode<T> node = head;
		String retString = "";
		while (node != null) {
			retString += node.getContents();
			node = node.getNext();
		}
		return retString;
	}

	public static void main(String[] args) {
		LList<String> valList = new LList<String>();
		valList.endInsert(("a"));
		valList.endInsert(("b"));
		valList.endInsert(("c"));
		valList.reverseRec(valList.head);
	}

}
