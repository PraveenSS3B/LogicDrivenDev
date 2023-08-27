package in.Algo.Tree.LogicDrivenDev;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralTreeTraversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.right = new Node(9);
		root.left.left.left = new Node(8);

		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.left.left = new Node(10);
		root.right.right = new Node(7);

		printSpiral(root);
	}

	private static void printSpiral(Node root) {

		Queue<Node> q = new LinkedList<>();

		q.add(root);

		Stack<Integer> s = new Stack<>();

		boolean reverse = false;

		while (!q.isEmpty()) {

			int size = q.size();

			for (int j = 0; j < size; j++) {

				Node curr = q.poll();

				if (reverse)
					s.push(curr.key);

				else
					System.out.print(curr.key + " ");

				if (curr.left != null)
					q.add(curr.left);

				if (curr.right != null)
					q.add(curr.right);
			}

			if (reverse)
				while (!s.isEmpty()) {
					System.out.print(s.pop() + " ");
				}
			
			reverse = !reverse;

			System.out.println();
		}

	}

}
