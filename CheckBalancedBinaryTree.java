package in.Algo.Tree.LogicDrivenDev;

public class CheckBalancedBinaryTree {

	public static void main(String[] args) {

		Node root = new Node(3);

		root.left = new Node(9);

		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);

		if (isBalanced(root) == -1)
			System.out.println("No");
		else
			System.out.println("Yes");
	}

	private static int isBalanced(Node root) {

		if (root == null)
			return 0;

		int lh = isBalanced(root.left);

		if (lh == -1)
			return -1;

		int rh = isBalanced(root.right);

		if (rh == -1)
			return -1;

		if (Math.abs(lh - rh) > 1)
			return -1;

		else
			return Math.max(lh, rh) + 1;

	}

}
