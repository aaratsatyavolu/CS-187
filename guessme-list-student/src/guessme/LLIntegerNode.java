package guessme;

/**
 * This class defines a linked list node storing an integer. Use primitive type
 * int (do not use wrapper class Integer) You must provide the following
 * methods: - a constructor - a setInfo method and a getInfo method - a setLink
 * method and a getLink method
 */
public class LLIntegerNode {
	private int info;
	private LLIntegerNode link;

	public LLIntegerNode() {
		this.info = 0;
		this.link = null;
	}

	public LLIntegerNode(int info) {
		this.info = info;
		this.link = null;
	}

	public int getInfo() {
		return info;
	}

	public LLIntegerNode getLink() {
		return link;
	}

	public void setInfo(int n) {
		info = n;
	}

	public void setLink(LLIntegerNode link) {
		this.link = link;
	}

	public String toString() {
		if (!(getLink() == null))
			return "Info: " + getInfo() + "\nPoints To Node with: " + getLink().getInfo();
		return "Info: " + getInfo() + "\nLast Node in List";
	}
}
