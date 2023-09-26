package in.Algo.Tree.LogicDrivenDev;

public class CountNumber_Of_SubTrees_Having_Given_Sum {

	public static void main(String[] args) {
//		4 0 1 N 2 0 -2 N -4 -1 -3 N 0 -3 -5
		Node root = VerticalWidth_BT.buildTree("5 -10 3 9 8 -4 7");

		int X = 7;

		countSubtreesWithSumX(root, X);

		System.out.println(count);

	}

	static int count = 0;

	static int countSubtreesWithSumX(Node root, int X) {
		find(root, X);
		return count;
	}

	static int find(Node root, int X) {
		if (root == null)
			return 0;

		if (root.key == X)
			count++;

		if (root.left == null && root.right == null)
			return root.key;

		int lv = find(root.left, X);
		int rv = find(root.right, X);

		if (root.key + lv + rv == X)
			count++;

		return root.key;
	}
}
