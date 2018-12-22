package lab8;

public class LinkedList<T extends Comparable<T>> {

	protected Node<T> head = null;

	public LinkedList<T> add(T elem) {
		head = new Node<T>(elem, head);
		return this;
	}

	public void print() {
		for (Node<T> node = head; node != null; node = node.link) {
			System.out.print(node.info + " ");
		}
		System.out.println("");
	}

	public T maxValue() {
		if (head == null)
			return null;
		T value = head.info;
		for (Node<T> node = head.link; node != null; node = node.link) {
			if (node.info.compareTo(value) > 0)
				value = node.info;
		}
		return value;
	}

	public void threshold(T thres) {
		while (head != null && head.info.compareTo(thres) >= 0) {
			head = head.link;
		}
		if (head != null) {
			for (Node<T> node = head; node.link != null;) {
				if (node.link.info.compareTo(thres) >= 0) {
					node.link = node.link.link;
				} else {
					node = node.link;
				}
			}
		}
	}
}
