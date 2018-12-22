package structures;

public class LLNode<T> {
	public T info;
	public LLNode<T> link;

	public LLNode() {
		this.info = null;
		this.link = null;
	}

	public LLNode(T info) {
		this.info = info;
		this.link = null;
	}
	public LLNode(T info, LLNode<T> link) {
		this.info = info;
		this.link = link;
	}

	public void setInfo(T n) {
		info = n;
	}

	public void setLink(LLNode<T> link) {
		this.link = link;
	}
	
	public String toString() {
		return "info: " + this.info + "\n" + "next: " + this.link;
	}
}
