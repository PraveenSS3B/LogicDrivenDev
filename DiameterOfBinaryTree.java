package in.Algo.Tree.LogicDrivenDev;

import java.util.HashMap;
import java.util.Map;

public class DiameterOfBinaryTree {

	public static void main(String[] args) {

		Node root = new Node(10);

		root.left = new Node(20);

		root.right = new Node(30);

		root.right.right = new Node(50);
		root.right.left = new Node(40);
		root.right.left.left = new Node(60);

		System.out.println(getDiameter(root));

		Map<Node, Integer> nodeHeights = new HashMap<>();

		height(root, nodeHeights);

		System.out.println(getDiameter(root, nodeHeights));

	}

	public static int height(Node root, Map<Node, Integer> map) {
		if (root == null)
			return 0;

		int lh = height(root.left, map);

		int rh = height(root.right, map);

		int currHeight = Math.max(lh, rh) + 1;

		map.put(root, currHeight);

		return currHeight;
	}

	// Better Solution - Using PreComputing Height Values of each Node..
	private static int getDiameter(Node root, Map<Node, Integer> nodeHeights) {

		if (root == null)
			return 0;

		int d1 = 1 + (nodeHeights.containsKey(root.left) ? nodeHeights.get(root.left) : 0)
				+ (nodeHeights.containsKey(root.right) ? nodeHeights.get(root.right) : 0);

		int d2 = getDiameter(root.left, nodeHeights);

		int d3 = getDiameter(root.right, nodeHeights);

		return Math.max(d1, Math.max(d2, d3));

	}

	public static int height(Node root) {
		if (root == null)
			return 0;

		return Math.max(height(root.left), height(root.right)) + 1;

	}

	// Time Complexity - O(n^2)
	private static int getDiameter(Node root) {

		if (root == null)
			return 0;

		int d1 = 1 + height(root.left) + height(root.right);

		int d2 = getDiameter(root.left);

		int d3 = getDiameter(root.right);

		return Math.max(d1, Math.max(d2, d3));

	}

}
