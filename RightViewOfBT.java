package in.Algo.Tree.LogicDrivenDev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBT {

	static int maxLevel = 0;

	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(20);
		root.right = new Node(30);

		root.left.left = new Node(40);
		root.left.right = new Node(50);

		root.right.right = new Node(70);

		System.out.println(Arrays.toString(printRightView(root).toArray()));

		System.out.println(Arrays.toString(printRightViewRec(root, 1, new ArrayList<Integer>()).toArray()));

	}

	private static ArrayList<Integer> printRightViewRec(Node root, int lvl, ArrayList<Integer> res) {
		
		if(root == null)
			return res;

		if (lvl > maxLevel) {
			res.add(root.key);
			maxLevel = lvl;
		}

		printRightViewRec(root.right, lvl + 1, res);
		printRightViewRec(root.left, lvl + 1, res);

		return res;

	}

	/**
	 * Iterative Approach
	 * 
	 * @param root - top node of the tree
	 * @return the Right nodes of the tree in arrayList
	 */
	private static ArrayList<Integer> printRightView(Node root) {
		ArrayList<Integer> l = new ArrayList<Integer>();

		Queue<Node> q = new LinkedList<>();

		q.add(root);

		while (!q.isEmpty()) {
			int s = q.size();

			for (int i = 0; i < s; i++) {
				Node curr = q.poll();
				if (i == s - 1)
					l.add(curr.key);

				if (curr.left != null)
					q.add(curr.left);

				if (curr.right != null)
					q.add(curr.right);
			}
		}

		return l;
	}

}
