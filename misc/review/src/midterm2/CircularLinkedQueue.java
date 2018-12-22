package midterm2;

import midterm1.LLNode;

public class CircularLinkedQueue<T> {
	public LLNode<T> rear;

	public void enqueue(T element) {
		LLNode<T> node = null;
		if (rear == null) {
			node = new LLNode<T>(element, null);
			node.setNext(node);
		} else {
			node = new LLNode<T>(element, rear.getNext());
			rear.setNext(node);
		}
		rear = node;
	}

	public void dequeue() {
		if (rear.getNext() == rear)
			rear = null;
		else {
			rear.setNext(rear.getNext().getNext());
		}
	}

	public String toString() {
		String retstr = "";
		LLNode<T> node = rear.getNext();
		do {
			retstr += " " + node.getContents();
			node = node.getNext();
		} while (node != rear.getNext());
		return retstr;

	}
}
