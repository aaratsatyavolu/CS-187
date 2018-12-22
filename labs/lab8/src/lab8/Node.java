package lab8;

public class Node<T> {
	public T info;
	public Node<T> link;

	public Node(T in, Node<T> li) {
		info = in;
		link = li;
	}
}
