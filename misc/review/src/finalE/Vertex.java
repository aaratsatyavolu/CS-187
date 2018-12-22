package finalE;

class Vertex<T> {
	public T data;
	public boolean visited;
	public int predecessor;

	public Vertex() {
		data = null;
		visited = false;
		predecessor = 0;
	}

	public Vertex(T _data) {
		data = _data;
		visited = false;
	}

	public String toString() {
		return data.toString();
	}
	/* Declare any additional vertex attribute you may need */
}

