package in.Algo.Tree.LogicDrivenDev;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(1);

		root.left = new Node(3);

		root.left.left = new Node(3);
		root.left.right = new Node(3);

		root.right = new Node(2);
		root.right.right = new Node(9);

		getMaxWidth(root);

	}

	private static void getMaxWidth(Node root) {

		Queue<Node> q = new LinkedList<Node>();

		q.add(root);

		int max = Integer.MIN_VALUE;

		while (!q.isEmpty()) {

			int size = q.size();

			max = Math.max(max, size);

			for (int i = 0; i < size; i++) {
				Node curr = q.poll();

				if (curr.left != null)
					q.add(curr.left);

				if (curr.right != null)
					q.add(curr.right);

			}

		}

		System.out.println(max);

	}

}
