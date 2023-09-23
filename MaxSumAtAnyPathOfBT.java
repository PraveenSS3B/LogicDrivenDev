package in.Algo.Tree.LogicDrivenDev;

public class MaxSumAtAnyPathOfBT {

	static int maxi[] = new int[1];

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(5);
		root.right.right = new Node(-2);

		findMax(root, maxi);

		System.out.println(maxi[0]);
	}

	private static int findMax(Node root, int[] maxi) {
		if (root == null)
			return 0;

		// Here LeftSum is max sum from left subtree
		int leftSum = Math.max(0, findMax(root.left, maxi));

		// Here RightSum is max sum from Right subtree
		int rightSum = Math.max(0, findMax(root.right, maxi));

		maxi[0] = Math.max(maxi[0], rightSum + leftSum + root.key);

		// This Return Statement gives the best answer to calculate above line
		return Math.max(leftSum, rightSum) + root.key;
	}

}
