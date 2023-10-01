package in.Algo.Tree.LogicDrivenDev;

import java.util.LinkedList;
import java.util.Queue;

public class InsertNodeInBinaryTree_AtFirstPositionAvailable {

	public static void main(String[] args) {
		Node root = VerticalWidth_BT.buildTree("10 11 9 7 N 15 8");

		int key = 12;

		Node updatedNode = insert(root, key);

		LevelOrderTraversal.levelOrderTraversalPrintLineByLine2(updatedNode);
	}

	private static Node insert(Node root, int key) {

		Queue<Node> q = new LinkedList<>();

		q.add(root);

		boolean flag = true;

		while (!q.isEmpty()) {
			int qs = q.size();

			for (int i = 0; i < qs; i++) {
				Node curr = q.poll();

				if (curr.left != null)
					q.add(curr.left);
				else if (flag && curr.left == null) {
					curr.left = new Node(key);
					q.add(curr.left);
					flag = false;
				}

				if (curr.right != null)
					q.add(curr.right);
				else if (flag && curr.right == null) {
					curr.right = new Node(key);
					q.add(curr.right);
					flag = false;
				}

			}
		}

		return root;

	}

}
