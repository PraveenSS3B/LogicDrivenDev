package in.Algo.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfBinaryTree {

	public static void main(String[] args) {

		Node root = new Node(10);

		root.left = new Node(20);
		root.right = new Node(30);

		root.left.left = new Node(40);
		root.left.right = new Node(50);

		root.right.right = new Node(70);

		System.out.println(findSize(root));
	}

	private static int findSize(Node root) {

//		if (root == null)
//			return 0;
//
//		return findSize(root.left) + findSize(root.right) + 1;

		Queue<Node> q = new LinkedList<>();

		int c = 0;

		if (root == null)
			return c;

		q.add(root);

		while (q.isEmpty() == false) {
			c++;
			Node curr = q.poll();

			if (curr.left != null) {
				q.add(curr.left);
			}

			if (curr.right != null) {
				q.add(curr.right);
			}
		}

		return c;

	}

}
