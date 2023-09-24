package in.Algo.Tree.LogicDrivenDev;

import java.util.ArrayList;

public class LowestCommonAncestor {

	static int n1 = 60;
	static int n2 = 70;

	public static void main(String[] args) {

		Node root = new Node(10);

		root.left = new Node(20);
		root.right = new Node(30);

		root.right.left = new Node(40);
		root.right.left.left = new Node(60);
		root.right.right = new Node(50);
		root.right.right.left = new Node(70);
		root.right.right.right = new Node(80);

		System.out.println(lca(root, n1, n2).key);

		System.out.println(lca_Efficient(root, n1, n2).key);

	}

	// Efficient Solution - Requires Non Extra Space

	private static Node lca_Efficient(Node root, int n1, int n2) {

		if (root == null)
			return null;

		if (root.key == n1 || root.key == n2)
			return root;

		Node lca1 = lca_Efficient(root.left, n1, n2);
		Node lca2 = lca_Efficient(root.right, n1, n2);

		if (lca1 != null && lca2 != null)
			return root;

		if (lca1 != null)
			return lca1;

		else
			return lca2;

	}

	// Tracking and storing the path from root node to target node
	private static boolean findPath(Node root, ArrayList<Node> l1, int n) {

		if (root == null)
			return false;

		l1.add(root);

		if (root.key == n)
			return true;

		// finding the path in both left and right subtrees,
		// if any one has the required node then return true.
		if (findPath(root.left, l1, n) || findPath(root.right, l1, n))
			return true;

		l1.remove(l1.size() - 1);

		return false;

	}

	// Naive Solution
	private static Node lca(Node root, int n1, int n2) {
		ArrayList<Node> l1 = new ArrayList<Node>();
		ArrayList<Node> l2 = new ArrayList<Node>();

		if (!findPath(root, l1, n1) || !findPath(root, l2, n2))
			return null;

//		int index = 0;
//
//		for (int i = 0, j = 0; i < l1.size() && j < l2.size(); i++, j++) {
//			if (l1.get(i) == l2.get(j)) {
//				index = Math.max(i, index);
//			}
//		}

//		return l1.get(index);

		int i;
		// Checking if first element we found is not equal each other then return (i -
		// 1) element
		for (i = 0; i < l1.size() - 1 && i < l2.size() - 1; i++) {
			if (l1.get(i + 1) != l2.get(i + 1))
				break;
		}

		return l1.get(i);
	}

}
