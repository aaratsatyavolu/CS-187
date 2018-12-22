package finalE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph<T> {
	// array of vertices
	protected ArrayList<Vertex<T>> verts;

	/*
	 * 2D array representing adjacency matrix of an unweighted graph. If
	 * adjMat[i][j] is true, there is an edge from vertex i to j; otherwise the
	 * element adjMat[i][j] is false.
	 */
	protected boolean[][] adjMat;

	public Graph(ArrayList<Vertex<T>> _verts, boolean[][] _mat) {
		/* check the validity of input parameters */
		int nverts = _verts.size();
		// adjacency matrix must be square matrix of NxN
		if (_mat.length != nverts)
			return;
		for (int i = 0; i < nverts; i++) {
			if (_mat[i].length != nverts)
				return;
		}
		verts = _verts;
		adjMat = _mat;
	}

	public int numVerts() {
		return verts.size();
	}

	// Return the next unvisited neighbor of a given vertex
	protected int getNextUnvisitedNeighbor(int vid) {
		for (int j = 0; j < numVerts(); j++) {
			if (adjMat[vid][j] && verts.get(j).visited == false)
				return j;
		}
		return -1; // return index -1 if none found
	}

	// Print out the graph, including vertex list and adjacency matrix
	public void print() {
		int nverts = numVerts();
		System.out.println("Vertex List:");
		for (int i = 0; i < nverts; i++) {
			System.out.println(i + ": " + verts.get(i) + " (valence: " + valence(i) + ")");
		}
		System.out.println("Adjacency Matrix:");
		for (int i = 0; i < nverts; i++) {
			for (int j = 0; j < nverts; j++) {
				System.out.print(adjMat[i][j] ? "1 " : "0 ");
			}
			System.out.println("");
		}
	}

	public void completeGraph() {
		for (int i = 0; i < adjMat.length; i++) {
			for (int j = 0; j < adjMat.length; j++) {
				adjMat[i][j] = !(i == j);
			}
		}
	}

	public int valence(int vid) {
		if (vid < 0 || vid >= adjMat.length)
			return -1;
		int count = 0;
		for (int i = 0; i < adjMat.length; i++) {
			if (adjMat[i][vid])
				count++;
		}
		return count;
	}

	public void DFS(int start) {
		for (int i = 0; i < numVerts(); i++) {
			verts.get(i).visited = false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		System.out.print(verts.get(start).data + " ");
		stack.push(start);
		verts.get(start).visited = true;
		while (!stack.isEmpty()) {
			int n = getNextUnvisitedNeighbor(stack.peek());
			if (n == -1) {
				stack.pop();
			} else {
				verts.get(n).visited = true;
				stack.push(n);
				System.out.print(verts.get(n).data + " ");
			}
		}
	}

	public void recursiveDFS(int index) {
		if (getNextUnvisitedNeighbor(index) == -1)
			System.out.print(verts.get(index).data + " ");
		else {
			verts.get(index).visited = true;
			System.out.print(verts.get(index).data + " ");
			recursiveDFS(getNextUnvisitedNeighbor(index));
		}
	}

	public void BFS(int start) {
		for (int i = 0; i < numVerts(); i++) {
			verts.get(i).visited = false;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		System.out.print(verts.get(start).data + " ");
		verts.get(start).visited = true;
		q.add(start);

		int b;
		while (!q.isEmpty()) {
			int v = q.poll();
			while ((b = getNextUnvisitedNeighbor(v)) != -1) {
				verts.get(b).visited = true;
				System.out.print(verts.get(b).data + " ");
				q.add(b);
			}
		}
	}

	public ArrayList<Integer> BFS(int start, int end) {
		ArrayList<Integer> path = new ArrayList<Integer>(), previous = new ArrayList<Integer>();
		ArrayList<Integer> bfs = new ArrayList<Integer>();
		for (int i = 0; i < numVerts(); i++) {
			verts.get(i).visited = false;
		}
		Queue<Integer> q = new LinkedList<Integer>();

		verts.get(start).visited = true;
		previous.add(null);
		q.add(start);
		bfs.add(start);
		path.add(end);

		int b;
		while (!q.isEmpty()) {
			int v = q.poll();
			while ((b = getNextUnvisitedNeighbor(v)) != -1) {
				verts.get(b).visited = true;
				q.add(b);
				bfs.add(b);
				previous.add(v);
			}
		}

		if (!bfs.contains(end))
			return null;

		int index = bfs.indexOf(end);
		while (index != start) {
			path.add(previous.get(index));
			index = bfs.indexOf(previous.get(index));
		}
		Collections.reverse(path);
		return path;
	}

}
