package in.Algo.Tree.LogicDrivenDev;

import java.util.Stack;

public class IterativeInorderTraversal {

	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(20);

		root.left.right = new Node(50);
		root.left.right.right = new Node(90);

		root.left.left = new Node(40);
		root.left.left.left = new Node(70);
		root.left.left.right = new Node(80);

		root.right = new Node(30);

		root.right.right = new Node(60);
		inorder(root);
	}

	private static void inorder(Node root) {

		Stack<Node> s = new Stack<>();

		Node curr = root;

		while (curr != null || !s.isEmpty()) {
			while (curr != null) {
				s.add(curr);
				curr = curr.left;
			}

			curr = s.pop();
			System.out.print(curr.key + " ");
			curr = curr.right;
		}
	}

}
