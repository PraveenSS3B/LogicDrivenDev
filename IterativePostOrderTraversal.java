package in.Algo.Tree.LogicDrivenDev;

import java.util.Stack;

public class IterativePostOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(20);
		root.left.left = new Node(40);

		root.right = new Node(30);
		root.right.right = new Node(60);

		root.left.right = new Node(50);

		postOrder(root);

	}

	static void postOrder(Node root) {
		if (root == null)
			return;

		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		s1.push(root);

		while (!s1.isEmpty()) {
			Node curr = s1.pop();
			s2.push(curr);

			if (curr.left != null)
				s1.push(curr.left);

			if (curr.right != null)
				s1.push(curr.right);
		}

		while (!s2.isEmpty()) {
			Node curr = s2.pop();
			System.out.print(curr.key + " ");
		}
	}
}