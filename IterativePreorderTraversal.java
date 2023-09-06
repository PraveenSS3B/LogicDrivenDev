package in.Algo.Tree.LogicDrivenDev;

import java.util.Stack;

public class IterativePreorderTraversal {

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
		preorder(root);
	}

	private static void preorder(Node root) {
		Stack<Node> s = new Stack<>();

		s.add(root);

		Node currNode = null;

		while (!s.isEmpty()) {
			currNode = s.pop();
			System.out.print(currNode.key + " ");
			if (currNode.right != null)
				s.add(currNode.right);
			if (currNode.left != null)
				s.add(currNode.left);
		}

	}

}
