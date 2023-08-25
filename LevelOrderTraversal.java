package in.Algo.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(10);

//		root.left = new Node(6);
//		root.right = new Node(8);
//
//		root.right.right = new Node(7);
//		root.right.right.left = new Node(11);
//		root.right.right.right = new Node(12);

		root.left = new Node(20);
		root.right = new Node(30);

		root.left.left = new Node(40);
		root.left.right = new Node(50);

		root.right.right = new Node(70);

//		levelOrderTraversal(root, height(root));
//		levelOrderTraversal(root);

//		levelOrderTraversalPrintLineByLine(root);
		
		levelOrderTraversalPrintLineByLine2(root);

	}

	private static void levelOrderTraversalPrintLineByLine2(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(root);
		
		while(q.isEmpty() == false)
		{
			int size = q.size();
			for(int i = 0 ; i < size; i++)
			{
				Node curr = q.poll();
				
				System.out.print(curr.key + " ");
				
				if(curr.left != null) q.add(curr.left);
				
				if(curr.right != null) q.add(curr.right);
			}
			
			System.out.println();
		}
	}

	private static void levelOrderTraversalPrintLineByLine(Node root) {

		Queue<Node> q = new LinkedList<Node>();

		q.add(root);
		q.add(null);

		while (q.size() > 1) {
			Node curr = q.poll();

			if (curr == null) {
				System.out.println();
				q.add(null);
			}

			else {
				System.out.print(curr.key + " ");

				if (curr.left != null)
					q.add(curr.left);

				if (curr.right != null)
					q.add(curr.right);

			}

		}
	}

	private static void levelOrderTraversal(Node root, int height) {

		if (height == 0)
			return;

		else
			for (int i = 0; i < height; i++)
				printNodes(root, i);

	}

	private static void levelOrderTraversal(Node root) {

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);

		while (q.isEmpty() == false) {
			Node curr = q.poll();
			System.out.print(curr.key + " ");

			if (curr.left != null) {
				q.add(curr.left);
			}

			if (curr.right != null) {
				q.add(curr.right);
			}
		}

	}

	private static void printNodes(Node root, int k) {

		if (root == null)
			return;

		if (k == 0) {
			System.out.print(root.key + " ");
		}

		else {
			printNodes(root.left, k - 1);
			printNodes(root.right, k - 1);
		}
	}

	private static int height(Node root) {

		if (root == null)
			return 0;

		return Math.max(height(root.left), height(root.right)) + 1;

	}

}
