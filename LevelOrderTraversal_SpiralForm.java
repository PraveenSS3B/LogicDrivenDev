package in.Algo.Tree.LogicDrivenDev;

import java.util.Stack;

public class LevelOrderTraversal_SpiralForm {

	public static void main(String[] args) {

		Node root = new Node(10);
		root.right = new Node(30);
		root.left = new Node(20);

		root.left.left = new Node(40);
		root.left.right = new Node(20);

		printSpiral(root);
	}

	/**
	 * Spiral order Traversal mean: Starting from level 0 for root node, for all the
	 * even levels we print the node's value from right to left and for all the odd
	 * levels we print the node's value from left to right.
	 */
	private static void printSpiral(Node root) {
		if (root == null)
			return;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		s2.push(root);

		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				Node curr = s1.pop();

				System.out.println(curr.key + " ");

				if (curr.left != null)
					s2.push(curr.left);

				if (curr.right != null)
					s2.push(curr.right);

			}

			while (!s2.isEmpty()) {
				Node curr = s2.pop();

				System.out.print(curr.key + " ");

				if (curr.right != null)
					s1.push(curr.right);

				if (curr.left != null)
					s1.push(curr.left);
			}
		}

	}

}
