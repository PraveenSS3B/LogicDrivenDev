package in.Algo.Tree.LogicDrivenDev;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLeftView {

	static int maxLevel = 0;

	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(50);

		root.right = new Node(60);
		root.right.left = new Node(70);
		root.right.right = new Node(20);

		root.right.left.right = new Node(8);

		printLeftView(root, 1);
		System.out.println();
		printLeftView(root);
	}

	// Recursive
	private static void printLeftView(Node root, int level) {

		if (root == null)
			return;

		if (level > maxLevel) {
			System.out.print(root.key + " ");
			maxLevel = level;
		}

		printLeftView(root.left, level + 1);

		printLeftView(root.right, level + 1);

	}

	// Iterative
	private static void printLeftView(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {
				Node curr = q.poll();
				if (i == 0)
					System.out.print(curr.key + " ");

				if (curr.left != null)
					q.add(curr.left);

				if (curr.right != null)
					q.add(curr.right);
			}

		}
	}

}
