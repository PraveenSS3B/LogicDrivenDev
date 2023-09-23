package in.Algo.Tree.LogicDrivenDev;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

	class Node {
		int data;
		Node left;
		Node right;
		Node nextRight;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
			nextRight = null;
		}
	}

	public static void main(String[] args) {

		ConnectNodesAtSameLevel out_obj = new ConnectNodesAtSameLevel();
		/*
		 * Node root = out_obj.new Node(10);
		 * 
		 * root.left = out_obj.new Node(20);
		 * 
		 * root.left.left = out_obj.new Node(40); root.left.right = out_obj.new
		 * Node(60);
		 * 
		 * root.right = out_obj.new Node(30);
		 */

		Node root = out_obj.new Node(3);

		root.left = out_obj.new Node(1);

		root.right = out_obj.new Node(2);

		connect(root);
//		System.out.println("Level Order Traversal: ");
//		levelOrderTraversal(root);
		System.out.println("\nIn Order Traversal: ");
		printInorder(root);

	}

	static void connect(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (q.isEmpty() == false) {
			int s = q.size();
			Node prev = null;

			for (int i = 0; i < s; i++) {
				Node curr = q.poll();

				if (prev != null)
					prev.nextRight = curr;

				prev = curr;

				if (curr.left != null) {
					q.add(curr.left);
				}

				if (curr.right != null) {
					q.add(curr.right);
				}
			}
		}

	}

	private static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

}
