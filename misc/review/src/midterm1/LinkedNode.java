package midterm1;

public class LinkedNode {
	public String info;
	public LinkedNode link;

	public LinkedNode(String str) {
		info = str;
		link = null;
	}

	public LinkedNode getLink() {
		return link;
	}

	public String getInfo() {
		return info;
	}

}
