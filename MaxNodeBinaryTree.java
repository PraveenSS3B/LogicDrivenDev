package in.Algo.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxNodeBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(20);
		root.right = new Node(30);

		root.left.left = new Node(40);
		root.left.right = new Node(50);

		root.right.right = new Node(70);

//		System.out.println(findMax(root, root.key));

		System.out.println(findMax(root));
	}

	private static int findMax(Node root) {
		Queue<Node> q = new LinkedList<Node>();

		int max = Integer.MIN_VALUE;

		q.add(root);

		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			max = Math.max(max, curr.key);

			if (curr.left != null)
				q.add(curr.left);

			if (curr.right != null)
				q.add(curr.right);
		}

		return max;
	}

	private static int findMax(Node root, int max) {

		int leftMax = 0, rightMax = 0;

		if (root == null)
			return Integer.MIN_VALUE;

		if (root.left != null)
			leftMax = findMax(root.left, root.left.key);

		if (root.right != null)
			rightMax = findMax(root.right, root.right.key);

		int currMax = Math.max(leftMax, rightMax);

		return Math.max(max, currMax);

	}

}
