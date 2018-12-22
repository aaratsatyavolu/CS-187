
/**
 * Lab 10 - Midterm Review Practice Exercise
 *
 * Q1. Tree Traversal
 *   - Preorder traversal
 *   - Inorder traversal
 *   - Postorder traversal
 */
import java.util.Stack;

class Node {
	int data;
	Node left, right;

	public Node(int val) {
		data = val;
		left = right = null;
	}
}

public class BinaryTree {
	// global variable
	Node root;

	// constructor
	BinaryTree() {
		root = null;
	}

	/**
	 * TODO: Given a binary tree, print its nodes according to the "bottom-up"
	 * postorder traversal.
	 */
	void printPostOrder(Node n) {
		if (n != null) {
			printPostOrder(n.left);
			printPostOrder(n.right);
			System.out.println(n.data);
		}
	}

	/**
	 * TODO: Given a binary tree, print its nodes in inorder
	 */
	void printInOrder(Node n) {
		if (n != null) {
			printInOrder(n.left);
			System.out.println(n.data);
			printInOrder(n.right);
		}
	}

	/**
	 * TODO: Given a binary tree, print its nodes in preorder
	 */
	void printPreOrder(Node n) {
		if (n != null) {
			System.out.println(n.data);
			printPreOrder(n.left);
			printPreOrder(n.right);
		}
	}

	void post_order_iterative(Node root) {
		// prints the post-order traversal of the BST
		if (root == null)
			return;

		Stack<Node> s = new Stack<Node>();
		Stack<Node> for_printing = new Stack<Node>();
		s.push(root);

		while (!s.empty()) {
			Node node = s.pop();
			for_printing.push(node);
			if (node.left != null)
				s.push(node.left);
			if (node.right != null)
				s.push(node.right);
		}

		while (!for_printing.empty()) {
			// print out the post order traversal
			Node temp = for_printing.pop();
			System.out.println(temp.data);
		}
	}

	void in_order_iterative(Node root) {
		// prints the in-order traversal of the BST
		if (root == null)
			return;
		Stack<Node> s = new Stack<Node>();
		Node node = root;
		while (node != null || !s.isEmpty()) {

			while (node != null) {
				s.push(node);
				node = node.left;
			}

			node = s.pop();
			System.out.println(node.data);
			node = node.right;
		}
	}

	void pre_order_iterative(Node root) {
		if (root == null)
			return;
		Stack<Node> s = new Stack<Node>();
		Node node = root;
		while (node != null || !s.isEmpty()) {
			while (node != null) {
				System.out.println(node.data);
				s.push(node);
				node = node.left;
			}
			node = s.pop().right;
		}
	}

	public Node mirror(Node node) {
		if (node == null)
			return node;

		/* do the subtrees */
		Node left = mirror(node.left);
		Node right = mirror(node.right);

		/* swap the left and right pointers */
		node.left = right;
		node.right = left;

		return node;
	}

	// Driver program
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		t.root = new Node(1);
		t.root.left = new Node(2);
		t.root.right = new Node(3);
		t.root.left.left = new Node(4);
		t.root.left.right = new Node(5);

		System.out.println("Recursive Preorder traversal of binary tree is ");
		t.printPreOrder(t.root);

		System.out.println("\n Inorder traversal of binary tree is ");
		System.out.println("For recursive: ");
		t.printInOrder(t.root);

		System.out.println("For iterative: ");
		t.in_order_iterative(t.root);

		System.out.println("\nPostorder traversal of binary tree is ");
		System.out.println("For recursive: ");
		t.printPostOrder(t.root);

		System.out.println("For iterative: ");
		t.post_order_iterative(t.root);
		
		System.out.println("Iterative pre-order traversal of the binary tree is: ");
		t.pre_order_iterative(t.root);

		t.mirror(t.root);

	}
}