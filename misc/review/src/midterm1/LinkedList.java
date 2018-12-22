package midterm1;

public class LinkedList<T> {
	public LLNode<T> head;
	public LLNode<T> tail;

	public LinkedList() {
		head = null;
		tail = null;
	}

	public LinkedList(LLNode<T> node) {
		head = node;
		tail = node;
	}

	public void addEnd(T element) {
		LLNode<T> node = new LLNode<T>(element, null);
		if (tail == null)
			head = node;
		else
			tail.setNext(node);
		tail = node;
	}

	public int size() {
		int count = 0;
		LLNode<T> node = head;
		while (node != null) {
			node = node.getNext();
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l1.addEnd(1);
		l1.addEnd(2);
		l1.addEnd(3);
		l1.addEnd(4);
		l1.addEnd(5);

		LLNode<Integer> n1 = l1.head;
		
		while(n1 != null) {
			l2.addEnd(n1.getContents());
			n1 = n1.getNext();
		}
			

	}

}
