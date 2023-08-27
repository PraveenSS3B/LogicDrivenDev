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

		System.out.println();
		
		printSpiral_1(root);
	}

	private static void printSpiral_1(Node root) {

		if (root == null)
			return;

		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		s1.add(root);

		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				Node curr = s1.pop();

				System.out.print(curr.key + " ");

				if (curr.left != null)
					s2.add(curr.left);

				if (curr.right != null)
					s2.add(curr.right);
			}
			
			System.out.println();

			while (!s2.isEmpty()) {
				Node curr = s2.pop();

				System.out.print(curr.key + " ");

				if (curr.right != null)
					s1.add(curr.right);

				if (curr.left != null)
					s1.add(curr.left);
			}
			System.out.println();

		}

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
