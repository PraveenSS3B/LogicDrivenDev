package in.Algo.Tree.LogicDrivenDev;

public class DiameterOfBinaryTree {

	static int maxDiameter = 0;

	public static void main(String[] args) {

		Node root = new Node(10);

		root.left = new Node(20);

		root.right = new Node(30);

		root.right.right = new Node(50);
		root.right.left = new Node(40);
		root.right.left.left = new Node(60);

		System.out.println(getDiameter(root));

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
